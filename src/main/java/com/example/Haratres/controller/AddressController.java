package com.example.Haratres.controller;

import com.example.Haratres.dto.AddressRequest;
import com.example.Haratres.dto.AddressResponse;
import com.example.Haratres.dto.ProductRequest;
import com.example.Haratres.model.Address;
import com.example.Haratres.model.Product;
import com.example.Haratres.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Secured("ROLE_CUSTOMER")
    @PostMapping
    public ResponseEntity<AddressResponse> addAddress(@RequestBody AddressRequest addressRequest) {
        AddressResponse addedAddress = addressService.addAddress(addressRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedAddress);
    }
    @Secured("ROLE_CUSTOMER")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @Secured("ROLE_CUSTOMER")
    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody AddressRequest addressRequest) {
        return addressService.updateAddress(id,addressRequest);

    }
}
