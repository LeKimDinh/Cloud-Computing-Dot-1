<%-- 
    Document   : list
    Created on : Mar 28, 2020, 7:20:06 PM
    Author     : lekim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <body>
        <div><a href="#">DownLoad</a></div>
        <div><a href="login">LogIn</a></div>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>User Name</th>
                </tr>
            </thead>
            <tbody>
        
                <tr>
                    <td><p><%=session.getAttribute("userId") %></p></td>
                    <td><p><%=session.getAttribute("userName") %></p></td>
                    <td>

                    <a href="edit?id=${requestScope.userId}">Edit</a>
                    <a href="delete?id=${requestScope.userId}">Delete</a>
                    </td>
                </tr>
           
            </tbody>
        </table>
    </body>
</html>
