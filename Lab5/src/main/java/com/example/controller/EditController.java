/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.jwt.JwtTokenProvider;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lekim
 */
@RestController
public class EditController {
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    UserRepository userRepository;
    
     @Autowired
    PasswordEncoder passwordEncoder;
    
    @PutMapping("/update")
    User update(@RequestHeader(name = "Authorization") String token, @RequestBody User edittedUser) {
        token = token.replace("Bearer ", "");
        if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
            Long userId = tokenProvider.getUserIdFromJWT(token);
            return userRepository.findById(userId)
                    .map(user -> {
                        user.setPassword(passwordEncoder.encode(edittedUser.getPassword()));
                        return userRepository.save(user);
                    }).orElseGet(() -> {
                edittedUser.setId(userId);
                return userRepository.save(edittedUser);
            });
        } else {
            return new User();
        }
    }
}
