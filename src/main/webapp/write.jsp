<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-13
  Time: 오후 5:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object obj = session.getAttribute("mid"); // 리턴타입이 Object
    //fakeLogin에서 셋팅한 session을 가져옴.
    if (obj == null) { //만약 로그인 하지 않았다면,,
        response.sendRedirect("/login?result=fail");
        //다시 로그인페이지로 redirect
        return;
    }
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>write page</h1>
    <form action="logout.jsp">
        <button type="submit">LOGOUT</button>
    </form>

</body>
</html>
