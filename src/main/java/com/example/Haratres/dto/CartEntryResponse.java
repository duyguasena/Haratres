package com.example.Haratres.dto;

import com.example.Haratres.model.CartEntry;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
public class CartEntryResponse {
    private Long id;
    private String code;
    private Date creationTime=new Date();
    //private List<CartEntry> cartEntries;
    private int quantity;
    private int stockQuantity;
    private double totalPrice;
}
