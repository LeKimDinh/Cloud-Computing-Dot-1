<%-- 
    Document   : register
    Created on : Mar 28, 2020, 10:37:18 AM
    Author     : lekim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <body>
        <h1>Register account!</h1>
        <form action="" method="POST">
            <div>User Name: <input type="text" id="txtUserName" name="txtUserName"></div>
            <div>Pass Word: <input type="text" id="txtPassWord" name="txtPassWord"></div>
            <div>Full Name: <input type="text" id="txtFullName" name="txtFullName"></div>
            <div>Address: <input type="text" id="txtAddress" name="txtAddress"></div>
            <div>Salary: <input type="text" id="txtSalary" name="txtSalary"></div>
            <div>Birth Date: <input type="text" id="txtBirthDate" name="txtBirthDate"></div>
            <div><button type="submit">Register</button></div>
        </form>
        <a href="login">LogIn</a>
    </body>
</html>
