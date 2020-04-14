/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
import lombok.Data;
/**
 *
 * @author lekim
 */


@Data
@Entity
@Table(name = "taikhoan")
public class TaiKhoan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String username;
    
     @Column
    private String password;
     
    @Column
    private String fullname;
    
    @Column
    private String address;
    
    @Column
    private float salary;
    
    @Column
    private Date birthdate;
}
