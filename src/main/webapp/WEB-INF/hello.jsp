<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-10
  Time: 오후 6:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <!-- JSP에서 JSTL 사용하려고 쓰는 코드. 구글링으로 찾음 -->
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>hello JSP Result</h1>

    <h2>${data}</h2> <!-- HelloController에 있는 request.setAttribute(이 값) -->
    <ul>
        <c:forEach items="${arr}" var="str">
            <li>${str}</li>
        </c:forEach>
    </ul>
</body>
</html>
