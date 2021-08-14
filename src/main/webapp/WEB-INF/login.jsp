<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-13
  Time: 오후 5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
    <style>
        .fail {
            background-color: red;
        }
    </style>
<head>
    <title>Title</title>
</head>
<body>

    <h1>login PAGE</h1>

    <c:if test="${param.result != null}">
        <div class="fail">
        <h2>LOGIN FAILED</h2>
        </div>
    </c:if>


    <form action="/login" method="post">
        <input type="text" name="mid"><br>
        <input type="text" name="mpw"><br>
        <button type="submit">LOGIN</button>
    </form>
</body>
</html>
