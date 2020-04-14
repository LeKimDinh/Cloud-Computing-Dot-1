/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLayer;
import java.util.Date;
/**
 *
 * @author lekim
 */
public class LNhanVien implements java.io.Serializable{
    private String ID;
    private String Ten;
    private Date BirthDay;
    private float Luong;
    private String DiaChi;
    
    public String getID(){
        return ID;
    }
    
    public void  setID(String ID){
        this.ID = ID;
    }
    
    public String getTen(){
        return Ten;
    }
    
    public void setTen(String Ten){
        this.Ten = Ten;
    }
    
    public Date getBirthDay(){
        return BirthDay;
    }
    
    public void setBirthDay(Date BirthDay){
        this.BirthDay = BirthDay;
    }
    
    
    public Float getLuong(){
        return Luong;
    }
    
    public void setLuong(float Luong){
        this.Luong = Luong;
    }
    
    public String getDiaChi(){
        return DiaChi;
    }
    
    public void setDiaChi(String DiaChi){
        this.DiaChi = DiaChi;
    }
}
