/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.MyConnection;
import dto.HocSinh;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lekim
 */
public class HocSinhDAO {
    public List<HocSinh> readAll() throws SQLException{
        List<HocSinh> listItem = new ArrayList<>();
        MyConnection init = new MyConnection();
        try{
            init.init();
            Statement stmt = null;
            stmt = init.getConn().createStatement();
            String sql;
            sql = "Select * from thongtin";
            ResultSet rs =  stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                HocSinh item = new HocSinh(id,name);
                listItem.add(item);
            }
        }
        catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE,null,ex);
            
        }
        finally{
            init.getConn().close();
        }
        return listItem;
    }
    
    public HocSinh read(int id) throws SQLException{
        MyConnection init = new MyConnection();
        try{
            init.init();
            String sql;
            sql = "select * from thongtin where id=?";
            PreparedStatement preparedStatement = init.getConn().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                int _id = rs.getInt("id");
                String _name = rs.getString("Name");
                HocSinh item = new HocSinh(_id, _name);
                return item;
            }
        }
        catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null ,ex);
        }
        finally{
            init.getConn().close();
            
        }
        return null;
    }
    
    public void create(HocSinh obj) throws SQLException{
        MyConnection init = new MyConnection();
        try{
            init.init();
            String sql;
            sql = "insert into thongtin(name) values(?)";
            
            PreparedStatement preparedStatement = init.getConn().prepareStatement(sql);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.executeUpdate();
            
        }
        catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            init.getConn().close();
        }
    }
    
    public void update(HocSinh obj) throws SQLException{
        MyConnection init = new MyConnection();
        try{
            init.init();
            String sql;
            sql ="update thongtin set name=? where id=?";
            
            PreparedStatement preparedStatement = init.getConn().prepareStatement(sql);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setInt(2, obj.getId());
            
            preparedStatement.executeUpdate();
        }
        catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            init.getConn().close();
        }
    }
    
    public void delete(int id) throws SQLException{
        MyConnection init = new MyConnection();
        try{
            init.init();
            String sql;
            sql = "delete from thongtin where id=?";
            
            PreparedStatement preparedStatement = init.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        }
        catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(HocSinhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            init.getConn().close();
        }
    }
}
