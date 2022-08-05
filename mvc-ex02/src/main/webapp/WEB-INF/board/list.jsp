<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-17
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jsp에 jstl 연결하기 위해서 추가 -->
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>LIST PAGE</h1>
    <c:forEach items="${list}" var="list">
        <div>
            번호 : <a href="/board/read?bno=${list.bno}"> ${list.bno} </a>/
            제목 : ${list.title}/
            작성자 : ${list.writer}/
            작성일 : ${list.regdate}/
            조회수 : ${list.viewcount}
        </div>
    </c:forEach>

</body>
</html>
