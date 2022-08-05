<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-17
  Time: 오후 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>MODIFY PAGE</h1>
    <form action="/board/modify" method="post">
    <div>
        <input type="text" name="bno" value="${dto.bno}" readonly>
        <input type="text" name="title" value="${dto.title}">
        <input type="text" name="content" value="${dto.content}">
        <input type="text" name="writer" value="${dto.writer}" readonly>
    </div>
        <button type="submit">MODIFY</button>
    </form>
    <form action="/board/remove?bno=${dto.bno}" method="post">
        <button type="submit">DELETE</button>
    </form>


</body>
</html>
