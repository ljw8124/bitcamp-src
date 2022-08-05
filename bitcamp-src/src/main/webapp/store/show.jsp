<%@ page import="com.example.pratice02.service.StoreService" %><%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-06
  Time: 오후 6:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>맛집 목록</h1>
    <br>
    <%
        String area = request.getParameter("area");
    %>
    <h1><%= StoreService.INSTANCE.getDtoList(area) %></h1>
</body>
</html>
