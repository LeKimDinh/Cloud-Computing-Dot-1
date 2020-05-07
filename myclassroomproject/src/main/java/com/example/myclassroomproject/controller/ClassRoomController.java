/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myclassroomproject.controller;

import com.example.myclassroomproject.model.ClassRoom;
import com.example.myclassroomproject.repository.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lekim
 */
@RestController
public class ClassRoomController {
    @Autowired
    ClassRoomService service;

    
    //Get list items
    @GetMapping("/classroomrestful")
    Iterable<ClassRoom> readAll(){
        return service.findAll();
        
    }
    
    //Get single item
    @GetMapping("/classroomrestful/{id}")
    ClassRoom read(@PathVariable String id) throws Exception{
       ClassRoom classroom = service.findClassById(id);
       if(service.findClassById(id) == null){
           throw new RuntimeException("Not Found");
       }
       else{
        return classroom;
       }     
    }
    
    //Post create item
    @PostMapping("/classroomrestful")
    ClassRoom create(@RequestBody ClassRoom newClassRoom){
        return service.save(newClassRoom);
    }
    
    //Put edit item
    @PutMapping("/classroomrestful/{id}")
    ClassRoom update(@PathVariable String id, @RequestBody ClassRoom edittedClassRoom){
        ClassRoom  classroom = service.findClassById(id);
        if(classroom == null){
            edittedClassRoom.setId(id);
            return service.save(edittedClassRoom);
        }
        else{
            classroom.setName(edittedClassRoom.getName());
            classroom.setTeacher(edittedClassRoom.getTeacher());
            classroom.setAmount(edittedClassRoom.getAmount());
            return service.save(classroom);
        }
    }
    
    //Delete remove item
    @DeleteMapping("/classroomrestful/{id}")
    void delete(@PathVariable String id){
        ClassRoom  classroom = service.findClassById(id);
       if(classroom == null){
           throw new RuntimeException("Not Found");
       } 
       else{
             service.delete(classroom);
       }  
    }
}
