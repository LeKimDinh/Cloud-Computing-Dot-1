/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author lekim
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username)  {
        User user = userRepository.findByUsername(username); //To change body of generated methods, choose Tools | Templates.
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
               
    }

    public UserDetails loadUserById(Long userId) {
         User user = userRepository.findById(userId).orElseThrow(
        () -> new UsernameNotFoundException("User is not found !"));
        
       return new CustomUserDetails(user); 
            
    }
    
}
