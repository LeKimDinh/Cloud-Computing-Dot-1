/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;
import lombok.Data;
/**
 *
 * @author lekim
 */
@Data
class LoginResponse {

   
    private String accessToken;
    private String tokenType = "Bearer ";
    
    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    } 
    
    
}
