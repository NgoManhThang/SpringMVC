<%--
  Created by IntelliJ IDEA.
  User: ngomanhthang
  Date: 19/08/2019
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách thành viên</title>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>phone</th>
            <th>address</th>
            <th>email</th>
            <th>Detail</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${listData}">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.phone}</td>
                <td>${item.address}</td>
                <td>${item.email}</td>
                <td>
                    <a href="/student/${item.id}/detail">Click me</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
