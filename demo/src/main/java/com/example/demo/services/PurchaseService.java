package com.example.demo.services;


import com.example.demo.models.Purchase;
import com.example.demo.models.Robe;
import com.example.demo.models.UserPo;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.repository.RobeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RobeRepository robeRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase buyRobe(Integer userId, Integer robeId, int quantity) {
        UserPo  user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Robe robe = robeRepository.findById(robeId)
                .orElseThrow(() -> new RuntimeException("Robe not found"));

        Purchase purchase = new Purchase();
        purchase.setUserPo(user);
        purchase.setRobe(robe);
        purchase.setQuantity(quantity);
        purchase.setTotalPrice(robe.getPrice() * quantity);

        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getPurchaseBYUser(Integer userId) {
        return purchaseRepository.findAllByUserPo_Id(userId);
    }

    public void deletePurchase (Integer id){
        purchaseRepository.deleteById(id);

    }
}
