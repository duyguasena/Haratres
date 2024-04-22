package com.example.Haratres.service.imp;

import com.example.Haratres.dto.AddressRequest;
import com.example.Haratres.model.Address;
import com.example.Haratres.model.Product;
import com.example.Haratres.repository.AddressRepository;
import com.example.Haratres.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Long addAddress(AddressRequest addressRequest) {
        Address address = new Address();
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());
        address.setPostalCode(addressRequest.getPostalCode());
        address.setAddressDetail(addressRequest.getAddressDetail());
        //address.setUser();
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
}
