package com.example.Haratres.service.imp;

import com.example.Haratres.dto.AddressRequest;
import com.example.Haratres.dto.AddressResponse;
import com.example.Haratres.model.Address;
import com.example.Haratres.repository.AddressRepository;
import com.example.Haratres.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public AddressResponse addAddress(AddressRequest addressRequest) {
    Address address=new Address();
    address.setCity(addressRequest.getCity());
    address.setStreet(addressRequest.getStreet());
    address.setPostalCode(address.getPostalCode());
    addressRepository.save(address);
    return new AddressResponse();
}
    @Override
    public void deleteProductById(Long id) {
        addressRepository.deleteById(id);
    }
    @Override
    public Address updateAddress(Long id, AddressRequest addressRequest) {
        Address realAddress=addressRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Id bulunamadı"));
        realAddress.setCity(addressRequest.getCity());
        realAddress.setStreet(addressRequest.getStreet());
        realAddress.setPostalCode(addressRequest.getPostalCode());
        addressRepository.save(realAddress);
        return realAddress;
    }
}
