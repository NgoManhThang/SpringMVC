<%--
  Created by IntelliJ IDEA.
  User: ngomanhthang
  Date: 26/08/2019
  Time: 00:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Them moi</title>
</head>
<body>
    <h1>Them moi sinh vien</h1>
    <form:form  modelAttribute="studendInformation" method="post" action="/save">
        <table>
            <tbody>
                <tr>
                    <td>Name:</td>
                    <td>
                        <form:input path="name" />
                    </td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td>
                        <form:input path="phone" />
                    </td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td>
                        <form:input path="address" />
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>
                        <form:input path="email" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button type="submit">Save</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </form:form>
</body>
</html>
