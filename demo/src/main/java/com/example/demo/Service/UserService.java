package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register new user
    public boolean register(String username, String password, String email) {

        // Check if username exists
        if (userRepository.findByUsername(username).isPresent()) {
            return false; // username already exists
        }

        // Create new user object
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        // Save to database
        userRepository.save(user);

        return true; // registration successful
    }


    // Validate login
    public boolean validateUser(String username, String password) {

        return userRepository.findByUsername(username)
                .map(u -> u.getPassword().equals(password))
                .orElse(false);
    }
}

    
   


