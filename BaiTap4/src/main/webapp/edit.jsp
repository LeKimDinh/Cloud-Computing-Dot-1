<%-- 
    Document   : edit
    Created on : Mar 28, 2020, 10:34:45 PM
    Author     : lekim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <body>
        <form action="" method="POST">
            <div>ID: <input type="text" id="txtId" name="txtId" readonly="true" value="<%=session.getAttribute("userId")%>"></div>
        <div>User Name: <input type="text" id="txtUserName" readonly="true" name="txtUserName" value="<%=session.getAttribute("userName")%>"></div>
            <div>Pass Word: <input type="text" id="txtPassWord" name="txtPassWord" value="<%=session.getAttribute("passWord") %>"></div>
            <div>Full Name: <input type="text" id="txtFullName" name="txtFullName" value="<%=session.getAttribute("fullName") %>"></div>
            <div>Salary: <input type="text" id="txtSalary" name="txtSalary" value="<%=session.getAttribute("salary") %>"></div>
            <div>Address: <input type="text" id="txtAddress" name="txtAddress" value="<%=session.getAttribute("address") %>"></div>
            <div>Birthdate: <input type="text" id="txtBirthDate" name="txtBirthDate" value="<%=session.getAttribute("birthDate") %>"></div>
            <div><button type="submit">Update</button></div>
        </form>
            <a href="list">List</a>
    </body>
</html>
