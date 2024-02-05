package com.example.demo.dto;


import lombok.Data;

@Data
public class UserRobeDto {
    private Integer userId;

    private double price;

    private String label;

    private String description;
    private String size;
}
