package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "robe")
public class Robe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double price;

    private String label;

    private String description;
    private String size;

    @Lob
    private byte[] image;

    @ManyToMany(mappedBy = "robes", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserPo> users = new ArrayList<>();

    @OneToMany(mappedBy = "robe")
    @JsonIgnore
    private List<Purchase> purchases;
}
