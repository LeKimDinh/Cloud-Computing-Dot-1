<%-- 
    Document   : login
    Created on : Mar 28, 2020, 4:07:40 PM
    Author     : lekim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <body>
        <h1>LogIn</h1>
        <form action="" method="POST">
            <div>
                <label>User Name:</label>
                <input type="text" id="txtUserName" name="txtUserName">
            </div>
            <div>
                <label>PassWord:</label>
                <input type="text" id="txtPassWord" name="txtPassWord">
            </div>
            <div><button type="submit">LogIn</button></div>
        </form>
        
    </body>
</html>
