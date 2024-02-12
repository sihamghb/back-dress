package com.example.demo.controllers;

import com.example.demo.models.Purchase;
import com.example.demo.services.PurchaseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
@CrossOrigin("*")

public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping()
    public Purchase buyProduct(@RequestParam Integer userId,
                                               @RequestParam Integer robeId,
                                               @RequestParam int quantity) {
        return purchaseService.buyRobe(userId, robeId, quantity);

    }

    @GetMapping("/{userId}")
    public List<Purchase> getPurchaseByUser(@PathVariable Integer userId) {
        return purchaseService.getPurchaseBYUser(userId);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePurchase(@PathVariable Integer id) {

        purchaseService.deletePurchase(id);
    }

}
