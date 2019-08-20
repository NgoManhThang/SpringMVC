<%--
  Created by IntelliJ IDEA.
  User: ngomanhthang
  Date: 20/08/2019
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách giáo viên</title>
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
        </tr>
    </c:forEach>
    </tbody>
</table>os

</body>
</html>
