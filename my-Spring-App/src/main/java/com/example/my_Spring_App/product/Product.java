package com.example.my_Spring_App.product;

import lombok.Getter;

import java.util.UUID;
@Getter
public class Product {
    private UUID productId;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

//    public String getName() {
//        System.out.println("Inside getName function");
//        return name;
//    }
}
