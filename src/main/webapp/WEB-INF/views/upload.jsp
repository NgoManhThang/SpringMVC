<%--
  Created by IntelliJ IDEA.
  User: ngomanhthang
  Date: 25/08/2019
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload file</title>
</head>
<body>
    <h1>Upload file</h1>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <button type="submit">Submit</button>
    </form>
</body>
</html>
