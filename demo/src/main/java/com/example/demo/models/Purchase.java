package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Purchase { //classe d'achat d'une seule robe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserPo userPo;

    @ManyToOne
    @JoinColumn(name = "robe_id")
    private Robe robe;

    private int quantity; //comme nous on fait une location on peut l'enlever
    private double totalPrice;


}
