<%-- 
    Document   : edit
    Created on : Mar 27, 2020, 9:14:13 AM
    Author     : lekim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <body>
        <form action="" method="POST">
            <div>Mã số: <input type="text" id="txtId" name="txtId" readonly="true" value="${requestScope.item.id}"></div>
            <div>Tên học sinh: <input type="text" id="txtName" name="txtName" value="${requestScope.item.name}"></div>
            <div><button type="submit">Cập nhật</button></div>
        </form>
            <a href="trangchu">Trang chủ</a>
    </body>
</html>
