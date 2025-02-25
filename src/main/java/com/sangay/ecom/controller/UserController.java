package com.sangay.ecom.controller;

import com.sangay.ecom.dto.LoginResponseDTO;
import com.sangay.ecom.dto.UserDTO;
import com.sangay.ecom.exceptionhandling.UserNotFoundException;
import com.sangay.ecom.model.Users;
import com.sangay.ecom.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    LoginResponseDTO loginResponseDTO = new LoginResponseDTO();


    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<String>> getAllUsers() {
        logger.info("Fetching all usernames");
        List<String> usernames = userService.getUsers();
        return new ResponseEntity<>(usernames, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody UserDTO userDTO) {
        String username = userDTO.getEmail();
        String password = userDTO.getPassword();

        try {
            if (userService.validateUserCredentials(username, password)) {
                loginResponseDTO.setStatus("success");
                loginResponseDTO.setMessage("success");
                loginResponseDTO.setStatus("Login successful");
                loginResponseDTO.setData(username);
                logger.info("login success for: {}", username);
                return new ResponseEntity<>(loginResponseDTO, HttpStatus.OK);
            } else {
                loginResponseDTO.setMessage("Login Failed");
                loginResponseDTO.setStatus("Login Unsuccessful");
                loginResponseDTO.setData(username);
                return new ResponseEntity<>(loginResponseDTO, HttpStatus.UNAUTHORIZED);
            }
        } catch (UserNotFoundException ex) {
            loginResponseDTO.setMessage("Login error");
            loginResponseDTO.setStatus("Error");
            loginResponseDTO.setData(ex.getMessage());
            logger.error("===User not found: {}===", ex.getMessage());
            return new ResponseEntity<>(loginResponseDTO, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Users> addUser(@RequestBody UserDTO userDTO) {
        logger.info("New user request with username: {}", userDTO.getUsername());
        Users newUser = userService.addUser(userDTO);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}