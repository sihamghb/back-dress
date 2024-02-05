package com.example.demo.repository;

import com.example.demo.models.Robe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobeRepository extends JpaRepository<Robe, Integer> {


}
