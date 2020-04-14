/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.TaiKhoan;
import Utils.HibernateUtils;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
     protected void doGet(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/edit.jsp");
        rd.forward(request, respone);
    }
     
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        int id = Integer.parseInt(request.getParameter("txtId"));
        String username = request.getParameter("txtUserName");
        String password = request.getParameter("txtPassWord");
        String fullname = request.getParameter("txtFullName");
        String address = request.getParameter("txtAddress");
        float salary = Float.parseFloat(request.getParameter("txtSalary"));
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        try {
            Date birthdate = fm.parse(request.getParameter("txtBirthDate"));
            TaiKhoan item = new TaiKhoan();
            item.setId(id);
            item.setUsername(username);
            item.setPassword(password);
            item.setFullname(fullname);
            item.setAddress(address);
            item.setSalary(salary);
            item.setBirthdate(birthdate);
            session.update(item);
            
            session.getTransaction().commit();
            
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("userId", id);
            httpSession.setAttribute("userName", username);
            httpSession.setAttribute("passWord", password);
            httpSession.setAttribute("fullName", fullname);
            httpSession.setAttribute("salary", salary);
            httpSession.setAttribute("address", address);
            httpSession.setAttribute("birthDate", birthdate);
            response.sendRedirect(request.getContextPath() + "/list");
        }
        catch (ParseException ex) {
           
        }
        finally{
            session.close();
        }
    }
}
