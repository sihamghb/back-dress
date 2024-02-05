package com.example.demo.repository;

import com.example.demo.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    List<Purchase> findAllByUserPo_Id(Integer userId);

    @Query(value = "select p from Purchase p")
    Purchase getFirstPurchase();

}
