<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-17
  Time: 오후 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>WRITE PAGE</h1>
    <form action="/board/write" method="post">
        제목 : <input type="text" name="title"><br>
        내용 : <input type="textarea" name="content"><br>
        작성자 : <input type="text" name="writer"><br>
        <button type="submit">WRITE</button>
    </form>

</body>
</html>
