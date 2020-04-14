/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author lekim
 */
@Entity
@Table(name="tblclassroom")
public class ClassRoom implements Serializable{
    private static final long serialVersionUID = 876688928410084519L;
    @Id
    @Column(name="id", length = 5)
    private String id;
    
    @Column(name = "name", length = 50)
    private String name;
    
    @Column(name = "teacher", length=50)
    private String teacher;
    
    @Column(name="amount")
    private String amount;
    
    
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getTeacher(){
        return this.teacher;
    }
    
    public void setTeacher(String teacher){
        this.teacher = teacher;
    }
    
    public String getAmount(){
        return this.amount;
    }
    
    public void setAmount(String amount){
        this.amount = amount;
    }
    
}
