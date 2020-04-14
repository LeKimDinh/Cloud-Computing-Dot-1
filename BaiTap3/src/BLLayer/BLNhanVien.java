/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLLayer;
import DBLayer.*;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
/**
 *
 * @author lekim
 */
public class BLNhanVien {
    DBmain dB = null;
    
    public BLNhanVien() throws SQLException, ClassNotFoundException{
        dB = new DBmain();
    }
    
    public List<LNhanVien> getNhanVien() throws SQLException{
        ResultSet rs = dB.ExecuteQueryResultSet("Select * from NhanVien;");
        
        List<LNhanVien> nhanViens = new ArrayList<>();
        
        while(rs.next()){
            LNhanVien nhanVien = new LNhanVien();
            nhanVien.setID(rs.getString(1));
            nhanVien.setTen(rs.getString(2));
            nhanVien.setBirthDay(rs.getDate(3));
            nhanVien.setLuong(rs.getFloat(4));
            nhanVien.setDiaChi(rs.getString(5));
            
            nhanViens.add(nhanVien);
        }
        return nhanViens;
    }
    
    public int AddNhanVien(String ID, String Ten, Date BirthDay, float Luong, String DiaChi) throws SQLException{
        String fm = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(BirthDay);
        String strSQL = "Insert into NhanVien values('"+ID+"','"+Ten+"','"+fm+"','"+Luong+"','"+DiaChi+"');";
        try{
            return dB.ExecuteNoneQuery(strSQL);
        }
        catch(SQLException ex){
            System.out.println(ex);
            return 0;
        }
    }
    
    public int EditNhanVien(String ID, String Ten, Date BirthDay, float Luong, String DiaChi) throws SQLException{
        String fm = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(BirthDay);
        String strSQL = "Update NhanVien Set name='"+Ten+"', birthday='"+fm+"', salary='"+Luong+"', address='"+DiaChi+"' where code='"+ID+"';";
        try{
            return dB.ExecuteNoneQuery(strSQL);
        }
        catch(SQLException ex){
            System.out.println(ex);
            return 0;
        }
    }
    
    public int DeleteNhanVien(String ID) throws SQLException{
        String strSQL = "Delete from NhanVien where code ='"+ID+"';";
        try{
            return dB.ExecuteNoneQuery(strSQL);
        }
        catch(SQLException ex){
            System.out.println(ex);
            return 0;
        }
    }
}
