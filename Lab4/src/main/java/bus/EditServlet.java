/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.HocSinhDAO;
import dto.HocSinh;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lekim
 */
@WebServlet("/capnhat")
public class EditServlet extends HttpServlet {
    
    private HocSinhDAO objectDao = new HocSinhDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            HocSinh item = objectDao.read(id);
            request.setAttribute("item",item);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/edit.jsp");
            rd.forward(request, response);
        }
        catch(SQLException ex){
            Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE, null ,ex);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("txtId"));
        String name = request.getParameter("txtName");
        try{
            HocSinh item = new HocSinh(id, name);
            objectDao.update(item);
            response.sendRedirect(request.getContextPath() + "/trangchu");
        }
        catch(SQLException ex){
            Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        

}
