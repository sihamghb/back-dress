package com.example.demo.repository;

import com.example.demo.models.UserPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<UserPo, Integer> {

    UserPo getUserRobeByEmail(String email);

}



