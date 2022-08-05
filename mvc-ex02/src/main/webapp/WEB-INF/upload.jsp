<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-20
  Time: 오후 6:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>upload page</h1>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="text" name="title" value="text....">
    <input type="file" name="uploadFile" multiple>
    <button type="submit">Submit</button>
</form>

</body>
</html>
