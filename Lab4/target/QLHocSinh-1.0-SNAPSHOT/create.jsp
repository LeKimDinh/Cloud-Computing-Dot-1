<%-- 
    Document   : create
    Created on : Mar 26, 2020, 9:59:42 PM
    Author     : lekim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <body>
        <form action="" method="POST">
            <div>
                Tên học sinh: <input type="text" id="txtName" name="txtName">
            </div>
            <div>
                <button type="submit"> Tạo mới</button>
            </div>
        </form>
        <a href="trangchu">Trang chủ</a>
    </body>
</html>
