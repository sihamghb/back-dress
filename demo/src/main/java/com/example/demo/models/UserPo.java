package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity //créer table avec la classe
@AllArgsConstructor
@NoArgsConstructor
public class UserPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    private String address;
    private Integer phoneNumber;

    @Column(unique = true)  //permet l'unicité du mail
    private String email;

    @ManyToMany(cascade = { CascadeType.ALL }) //relation entre deux tables on a une table d'association
    @JoinTable( //table d'association
            name = "user_robe",
            joinColumns = { @JoinColumn(name = "user_id") }, //on ajoute 2 champs a la table d'association
            inverseJoinColumns = { @JoinColumn(name = "robe_id") }
    )
    @JsonIgnore //correspond à quoi ??
    private List<Robe> robes = new ArrayList<>();


    @OneToMany(mappedBy = "userPo")
    @JsonIgnore
    private List<Purchase> purchases; //liste des achats
}
