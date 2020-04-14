/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.TaiKhoan;
import Utils.HibernateUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.jboss.logging.Logger;

/**
 *
 * @author lekim
 */
@WebServlet("/login")
public class LogInServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        
        String username = request.getParameter("txtUserName");
        String password = request.getParameter("txtPassWord");
        
      
        try{
        //Long checkPassWord = session.createQuery("Select COUNT(id) from TaiKhoan where username='" + username + "' and password='"+password+"'", Long.class).uniqueResult();
        List<TaiKhoan> tk = session.createQuery("from TaiKhoan where username='" + username + "' and password='"+password+"'", TaiKhoan.class).list();
        if(tk.size() > 0){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("userId", tk.get(0).getId());
            httpSession.setAttribute("userName", tk.get(0).getUsername());
            httpSession.setAttribute("passWord", tk.get(0).getPassword());
            httpSession.setAttribute("fullName", tk.get(0).getFullname());
            httpSession.setAttribute("salary", tk.get(0).getSalary());
            httpSession.setAttribute("address", tk.get(0).getAddress());
            httpSession.setAttribute("birthDate", tk.get(0).getBirthdate());
           response.sendRedirect(request.getContextPath()+"/list");            
        }
        else{
            response.sendRedirect(request.getContextPath() +"/register");
        }
        }
        catch(Exception ex){
            
        }
        finally{
        session.getTransaction().commit();
        session.close();
        }
    }

}
