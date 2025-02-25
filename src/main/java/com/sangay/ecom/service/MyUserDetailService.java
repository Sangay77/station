package com.sangay.ecom.service;

import com.sangay.ecom.Repository.UserRepository;
import com.sangay.ecom.model.UserPrincipal;
import com.sangay.ecom.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.sangay.ecom.exceptionhandling.UserNotFoundException;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<Users> user = userRepository.findByEmail(username);

        if(user.isEmpty()){
            throw new UserNotFoundException("user not existed!");
        }

        return new UserPrincipal(user.orElse(null));
    }
}
