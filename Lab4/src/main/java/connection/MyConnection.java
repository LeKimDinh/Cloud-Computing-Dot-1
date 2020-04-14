/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lekim
 */
public class MyConnection {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/hocsinh-store?useUnicode=yes&chacracterEncoding=UTF-8";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "";
    public static final String FDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    private Connection conn = null;
    
    public Connection getConn(){
        return conn;
    }
    
    public void setConn(Connection conn){
        this.conn = conn;
    }
    
    public void init() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        
        System.out.println("Connecting to database ...");
        conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }
    
}
