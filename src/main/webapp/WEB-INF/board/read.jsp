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
<h1>read page</h1>
<ul>
    <li>글 번호 : <input type="text" name="bno" value="${boardDTO.bno}" readonly></li>
    <li>글 제목 : <input type="text" name="title" value="${boardDTO.title}" readonly></li>
    <li>글 내용 : <input type="text" name="content" value="${boardDTO.content}" readonly></li>
    <li>작성자 : <input type="text" name="writer" value="${boardDTO.writer}" readonly></li>
    <li>작성일 : <input type="text" name="regdate" value="${boardDTO.regdate}" readonly></li>
    <li>수정일 : <input type="text" name="updatedate" value="${boardDTO.updatedate}" readonly></li>
    <li>조회수 : <input type="text" name="viewcount" value="${boardDTO.viewcount}" readonly></li>
</ul>
    <hr>
    <div>${pageDTO}</div>

<a href="/board/list?page=${pageDTO.page}&size=${pageDTO.size}"> 목록가기 </a><br>
<a href="/board/modify?bno=${boardDTO.bno}">수정/삭제</a>
</body>
</html>

