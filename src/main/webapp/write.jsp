<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-13
  Time: 오후 5:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object obj = session.getAttribute("name");
    if (obj == null) {
        response.sendRedirect("/login.jsp");
        return;
    }
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>write page</h1>

</body>
</html>
