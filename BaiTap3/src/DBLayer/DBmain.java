/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLayer;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author lekim
 */
public class DBmain {
    String connection = "jdbc:sqlserver://localhost;database=NhanVien;integratedSecurity = true;";
    Connection conn = null;
    Statement statement = null;
    
    public DBmain() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(connection);
        statement = conn.createStatement();
    }
    
    public ResultSet ExecuteQueryResultSet(String strSql) throws SQLException{
        return statement.executeQuery(strSql);
    }
    
    public int ExecuteNoneQuery(String strSql) throws SQLException{
        return statement.executeUpdate(strSql);
    }
    
    public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database)
            throws SQLException, ClassNotFoundException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        String connection = "jdbc:sqlserver://localhost;database=NhanVien;integratedSecurity = true;";
        
        Connection conn = DriverManager.getConnection(connection);

        return conn;
    }
}
