<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-20
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> </title>
</head>
<body>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="text" name="title" value="test....">
        <input type="file" name="uploadFiles" multiple><!-- multiple의 중요성! 파일첨부가 여러개로 가능하다 파일은 여러갠데 한줄로 처리 가능 -->
        <button type="submit">SUBMIT</button>
    </form>
</body>
</html>
