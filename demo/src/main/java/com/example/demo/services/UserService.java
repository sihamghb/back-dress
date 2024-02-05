package com.example.demo.services;


import com.example.demo.models.UserPo;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserPo> getUser() {
        return userRepository.findAll();
    }

    public UserPo getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteAccountById(Integer id) {
        UserPo userToDelete = userRepository.findById(id).orElse(null);
        if (userToDelete != null) {
            userRepository.delete(userToDelete);
        } else {
            log.error("Utilisateur non trouvé avec l'ID: {}", id);
            // Gérer l'erreur ou renvoyer une indication d'échec de suppression
        }
    }

    public UserPo updateAccount(Integer id, String name, String email, String address, String password) {
        UserPo existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            if (name != null) {
                existingUser.setName(name);
            }
            if (email != null) {
                existingUser.setEmail(email);
            }
            if (address != null) {
                existingUser.setAddress(address);
            }
            if (password != null) {
                existingUser.setPassword(password);
            }
            return userRepository.save(existingUser);
        } else {
            log.error("Utilisateur non trouvé avec l'ID: {}", id);
            return null;
        }
    }

    public UserPo createAccount(UserPo userPo) {
        return userRepository.save(userPo);
    }

    public Integer login(String email, String password) {
        var user = userRepository.getUserRobeByEmail(email);
        if (user == null) return 0;
        return user.getPassword().equals(password) ? user.getId() : 0;
    }
}
