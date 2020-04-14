/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.jwt.JwtTokenProvider;
import com.example.model.CustomUserDetails;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lekim
 */
@RestController
public class RegistryController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/registry")
    LoginResponse registryUser(@RequestBody User newUser) {
        String beforcePasswordEncoded = newUser.getPassword();
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);

        Authentication authenciation = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(newUser.getUsername(), beforcePasswordEncoded));

        SecurityContextHolder.getContext().setAuthentication(authenciation);

        String jwt = tokenProvider.generateToken((CustomUserDetails) authenciation.getPrincipal());

        return new LoginResponse(jwt);
    }
}