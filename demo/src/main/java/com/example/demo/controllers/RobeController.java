package com.example.demo.controllers;

import com.example.demo.dto.UserRobeDto;
import com.example.demo.models.Robe;
import com.example.demo.services.RobeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/robe")
@CrossOrigin("*")
public class RobeController {

    @Autowired
    private RobeService robeService;

    @PostMapping("/add")
    public Robe addRobe(@ModelAttribute UserRobeDto userRobe,
                        @RequestParam("image") MultipartFile image) throws IOException {
        return robeService.insertRobe(userRobe, image);
    }

    @GetMapping("/{userId}")
    public List<Robe> getRobesByUser(@PathVariable Integer userId) {
        return robeService.getRobesByUserId(userId);
    }

    @GetMapping("/all")
    public List<Robe> getAllRobes() {
        return robeService.getAllRobes();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDress(@PathVariable Integer id) {
        robeService.deleteRobeById(id);
    }
}




