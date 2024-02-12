package com.example.demo.repository;

import com.example.demo.models.Robe;
import com.example.demo.models.UserPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RobeRepository extends JpaRepository<Robe, Integer> {
    @Query("SELECT u FROM UserPo u JOIN u.robes r WHERE r.id = :robeId")
    List<UserPo> findUsersByRobeId(@Param("robeId") Integer robeId);

}
