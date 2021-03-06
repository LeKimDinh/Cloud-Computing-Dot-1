/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import dao.HocSinhDAO;
import dto.HocSinh;
import java.io.IOException;
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
@WebServlet("/taomoi")
public class CreateServlet extends HttpServlet {
    private HocSinhDAO objectDao = new HocSinhDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/create.jsp");
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("txtName");
        try{
            HocSinh item = new HocSinh(name);
            objectDao.create(item);
            response.sendRedirect(request.getContextPath() + "/trangchu");
            
        }
        catch(SQLException ex){
            Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
