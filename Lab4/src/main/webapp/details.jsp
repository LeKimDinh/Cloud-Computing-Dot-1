<%-- 
    Document   : details
    Created on : Mar 27, 2020, 8:52:39 AM
    Author     : lekim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <body>
        <p>Mã số: <c:out value="${requestScope.item.id}"></c:out> </p>
        <p>Tên học sinh: <c:out value="${requestScope.item.name}"></c:out> </p>
        <hr>
        <a href="trangchu">Trang chủ</a>
          
    </body>
</html>
