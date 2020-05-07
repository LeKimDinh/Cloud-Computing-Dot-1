/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myclassroomproject.model;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author lekim
 */
@Data
@Document(collection = "tblclassroom")
public class ClassRoom  implements Serializable{

    @Id
    private String _id;
    
    @Field(name="id")
    private String id;
    
    @Field(name="name")
    private String name;
    
    @Field(name="teacher")
    private String teacher;
    
    @Field(name="amount")
    private int amount;
    
   
}
