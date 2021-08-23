<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-19
  Time: 오후 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update page</h1>
<form action="/board/modify.do" method="post">
<ul>
    <li>글 번호 : <input type="text" name="bno" value="${boardDTO.bno}" readonly></li>
    <li>글 제목 : <input type="text" name="title" value="${boardDTO.title} / 수정할 내용을 입력하세요."></li>
    <li>글 내용 : <input type="text" name="content" value="${boardDTO.content} / 수정할 내용을 입력하세요."></li>
    <li>작성자 : <input type="text" name="writer" value="${boardDTO.writer}" readonly></li>

</ul>
    <button type="submit">UPDATE</button>
</form>
<form action="/board/remove.do?bno=${boardDTO.bno}" method="post">
<button type="submit">DELETE</button>
</form>
<hr>

</body>
</html>
