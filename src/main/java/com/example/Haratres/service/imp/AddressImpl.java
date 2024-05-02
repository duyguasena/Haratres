package com.example.Haratres.service.imp;

import com.example.Haratres.dto.AddressRequest;
import com.example.Haratres.exception.ResourceNotFoundException;
import com.example.Haratres.model.Address;
import com.example.Haratres.model.User;
import com.example.Haratres.repository.AddressRepository;
import com.example.Haratres.repository.UserRepository;
import com.example.Haratres.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AddressImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public Address addAddress(AddressRequest addressRequest) {
        Address address = new Address();
        try {
            address.setStreet(addressRequest.getStreet());
            address.setCity(addressRequest.getCity());
            address.setPostalCode(addressRequest.getPostalCode());
            address.setAddressDetail(addressRequest.getAddressDetail());
            User currentUser = getCurrentUser();
            address.setUser(currentUser);
            addressRepository.save(address);
            return address;
        } catch (Exception e) {
            logger.error("Error adding address: {}", e.getMessage());
            return null;
        }
    }
    @Override
    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }
    @Override
    public Address updateAddress(Long id, AddressRequest addressRequest) {
        try {
            Address realAddress = addressRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Address not found with ID: " + id));
            realAddress.setCity(addressRequest.getCity());
            realAddress.setStreet(addressRequest.getStreet());
            realAddress.setPostalCode(addressRequest.getPostalCode());
            realAddress.setAddressDetail(addressRequest.getAddressDetail());
            addressRepository.save(realAddress);
            return realAddress;
        } catch (ResourceNotFoundException e) {
            logger.error("Error updating address: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Error updating address: {}", e.getMessage());
            throw new RuntimeException("Error updating address", e);
        }
    }
    @Override
    public boolean existsById(Long id) {
        return addressRepository.existsById(id);
    }
    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return (User) userRepository.findByUserName(userName);
    }
}
