<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-17
  Time: 오후 5:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>read PAGE</h1>
    <div>
        <input type="text" name="bno" value="${dto.bno}" readonly>
        <input type="text" name="title" value="${dto.title}" readonly>
        <input type="text" name="content" value="${dto.content}" readonly>
        <input type="text" name="writer" value="${dto.writer}" readonly>
        <input type="text" name="regdate" value="${dto.regdate}" readonly>
        <input type="text" name="viewcount" value="${dto.viewcount}" readonly>
    </div>
    <button><a href="/board/modify?bno=${dto.bno}">MODIFY</a></button>

</body>
</html>
