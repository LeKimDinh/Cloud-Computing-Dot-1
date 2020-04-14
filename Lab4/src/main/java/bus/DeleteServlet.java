/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.HocSinhDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lekim
 */
@WebServlet("/xoa")
public class DeleteServlet extends HttpServlet {

    
    private HocSinhDAO objectDao = new HocSinhDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            objectDao.delete(id);
            response.sendRedirect(request.getContextPath()+"/trangchu");
            
        }
        catch(IOException | NumberFormatException | SQLException ex){
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, 0);
        }
        
    }

}
