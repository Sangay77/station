package com.sangay.ecom.service;

import com.sangay.ecom.Repository.UserRepository;
import com.sangay.ecom.controller.UserController;
import com.sangay.ecom.dto.UserDTO;
import com.sangay.ecom.exceptionhandling.UserNotFoundException;
import com.sangay.ecom.model.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CustomUserDetailsService userDetailsService;


    public Users addUser(UserDTO userDTO) {

        Users newUser = new Users();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newUser.setRole("USER"); // Default role
        newUser.setEmail(userDTO.getEmail());
        logger.info("Adding new user with username: {}", userDTO.getUsername());
        return userRepository.save(newUser);
    }


    public List<String> getUsers() {
        logger.info("Fetching all usernames");
        return userRepository.findAll()
                .stream()
                .map(Users::getUsername)
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean validateUserCredentials(String email, String password) {
        try {
            // Load user details by email (username)
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            // Verify the password using BCrypt
            if (passwordEncoder.matches(password, userDetails.getPassword())) {
                return true; // Password matches
            } else {
                throw new UserNotFoundException("Invalid email or password");
            }
        } catch (UsernameNotFoundException ex) {
            // Map UsernameNotFoundException to your custom UserNotFoundException
            throw new UserNotFoundException("User not found");
        }
    }
}