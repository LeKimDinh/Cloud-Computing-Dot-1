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
import java.util.List;
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
@WebServlet("/trangchu")
public class IndexServlet extends HttpServlet{
    private HocSinhDAO objectDao = new HocSinhDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        try{
            List<HocSinh> listItem = objectDao.readAll();
            request.setAttribute("listItem", listItem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        catch(IOException | SQLException | ServletException ex){
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
