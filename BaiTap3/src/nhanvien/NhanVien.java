/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhanvien;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;


import DBLayer.LNhanVien;
import java.rmi.server.*;
import java.util.*;

import BLLayer.BLNhanVien;
import java.sql.SQLException;
/**
 *
 * @author lekim
 */
public class NhanVien extends UnicastRemoteObject
                            implements NhanVienServices{
    BLNhanVien blnv = null;
    public NhanVien() throws RemoteException, SQLException, ClassNotFoundException{
        super();
        blnv = new BLNhanVien();
        
    }
    
    public List<LNhanVien> getNhanVien() throws RemoteException{
        try{
            return blnv.getNhanVien();
            
        }
        catch(SQLException ex){
            System.out.println(ex);
            return new ArrayList<>();
        }
    }
    
     public int AddNhanVien(String ID, String Ten, Date BirthDay, float Luong, String DiaChi) throws RemoteException{
         try{
             return blnv.AddNhanVien(ID, Ten, BirthDay, Luong, DiaChi);
         }
         catch(SQLException ex){
             System.out.println(ex);
             return 0;
         }
     }
     
     public int EditNhanVien(String ID, String Ten, Date BirthDay, float Luong, String DiaChi) throws RemoteException{
         try{
             return blnv.EditNhanVien(ID, Ten, BirthDay, Luong, DiaChi);
         }
         catch(SQLException ex){
             System.out.println(ex);
             return 0;
         }
     }
     
     public int DeleteNhanVien(String ID) throws RemoteException{
         try{
             return blnv.DeleteNhanVien(ID);
         }
         catch(SQLException ex){
             System.out.println(ex);
             return 0;
         }
     }
}
