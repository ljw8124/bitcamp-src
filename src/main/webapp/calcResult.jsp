<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-05
  Time: 오후 5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int frontNumber = Integer.parseInt(request.getParameter("frontNumber"));
    //getParameter는 저장된 정보를 가져오는 것
    int secondNumber = Integer.parseInt(request.getParameter("secondNumber"));
    String logic = request.getParameter("logic");
    int result = 0;
    if (logic.equals("+")) {
        result = frontNumber + secondNumber;
    } else if (logic.equals("-")) {
        result = frontNumber - secondNumber;
    } else if (logic.equals("*")) {
        result = frontNumber * secondNumber;
    } else {
        result = frontNumber / secondNumber;
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>결과 값</h1>
    <h1><%= result%></h1>

</body>
</html>
