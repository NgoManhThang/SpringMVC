<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: TDT computer
  Date: 8/16/2019
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Change Language</title>
</head>
<body>
    Language :
    <a href="?language=en">English</a>|
    <a href="?language=vi">Viet Nam</a>|

    <h2>hello :  <spring:message code="hello" text="default text" /></h2>

    Current Locale : ${pageContext.response.locale}
</body>
</html>
