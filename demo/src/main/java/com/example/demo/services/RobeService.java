package com.example.demo.services;


import com.example.demo.dto.UserRobeDto;
import com.example.demo.models.Robe;
import com.example.demo.models.UserPo;
import com.example.demo.repository.RobeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RobeService {

    @Autowired
    private RobeRepository repository;

    @Autowired
    private UserRepository userRepository;


    public Robe insertRobe(UserRobeDto userRobeDto, MultipartFile image) throws IOException {

        UserPo user = userRepository.findById(userRobeDto.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));

        Robe robe =new Robe();
        robe.setDescription(userRobeDto.getDescription());
        robe.setPrice(userRobeDto.getPrice());
        robe.setLabel(userRobeDto.getLabel());
        robe.setSize(userRobeDto.getSize());
        robe.setImage(image.getBytes());


        robe.getUsers().add(user);
        user.getRobes().add(robe);

        return repository.save(robe);
    }

    public List<Robe> getRobesByUserId(Integer userId) {
        UserPo user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getRobes();
    }
    public List<Robe> getAllRobes() {
        return repository.findAll();
    }
    public void deleteRobeById(Integer robeId) {
        // Vérifie si une robe avec l'ID fourni existe
        Robe robe = repository.findById(robeId).orElseThrow(() -> new RuntimeException("Robe not found with id " + robeId));

        // Si la robe existe, la supprimer
        repository.delete(robe);
    }

    }
