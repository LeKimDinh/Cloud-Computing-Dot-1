<%-- 
    Document   : index
    Created on : Mar 26, 2020, 9:33:02 PM
    Author     : lekim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp"></jsp:include>
    <body>
        <div><a href="taomoi">Tạo mới</a></div>
        <table>
            <thead>
                <tr>
                    <th>Mã số</th>
                    <th>Tên học sinh</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="row" items="${requestScope.listItem}">
                <tr>
                    <td><c:out value="${row.id}"></c:out></td>
                    <td><c:out value="${row.name}"></c:out></td>
                    <td>
                        <a href="chitiet?id=${row.id}">Chi tiết</a>
                    <a href="capnhat?id=${row.id}">Chỉnh sửa</a>
                    <a href="xoa?id=${row.id}">Xóa</a>
                    </td>
                </tr>
                
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>
