package com.example.Haratres.service.imp;

import com.example.Haratres.dto.AddressRequest;
import com.example.Haratres.model.Address;
import com.example.Haratres.model.User;
import com.example.Haratres.repository.AddressRepository;
import com.example.Haratres.repository.UserRepository;
import com.example.Haratres.service.AddressService;
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
    @Override
    public Long addAddress(AddressRequest addressRequest) {
        Address address = new Address();
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());
        address.setPostalCode(addressRequest.getPostalCode());
        address.setAddressDetail(addressRequest.getAddressDetail());
        User currentUser = getCurrentUser();
        address.setUser(currentUser);
        addressRepository.save(address);
        return address.getId();
    }

    @Override
    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address updateAddress(Long id, AddressRequest addressRequest) {
        Address realAddress=addressRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Id bulunamadı"));
        realAddress.setCity(addressRequest.getCity());
        realAddress.setStreet(addressRequest.getStreet());
        realAddress.setPostalCode(addressRequest.getPostalCode());
        realAddress.setAddressDetail(addressRequest.getAddressDetail());
        addressRepository.save(realAddress);
        return realAddress;
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
