/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.TaiKhoan;
import Utils.HibernateUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author lekim
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        HttpSession httpSession = request.getSession();
        try{
        int id = (int) httpSession.getAttribute("userId");
        TaiKhoan tk = session.find(TaiKhoan.class, id);
        session.delete(tk);
        session.getTransaction().commit();
        response.sendRedirect(request.getContextPath() + "/register");
        }
        catch(Exception ex){
            
        }
        finally{
            session.close();
        }
    }
}
