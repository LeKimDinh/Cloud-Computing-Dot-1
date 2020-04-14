/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author lekim
 */
public class HocSinh {
    private int id;
    private String name;
    
    public HocSinh(){
        
    }
    
    public HocSinh(String name){
        this.name = name;
    }
    
    public HocSinh(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId(){
        return this.id;
    }
   
    
    
}
