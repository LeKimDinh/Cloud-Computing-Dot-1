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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadController {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    UserRepository userRepository;
    
     @GetMapping("/read")
    User readMe(@RequestHeader(name = "Authorization") String token) {
        token = token.replace("Bearer ", "");
        if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
            Long userId = tokenProvider.getUserIdFromJWT(token);
            return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        } else {
            return new User();
        }
    }
}
