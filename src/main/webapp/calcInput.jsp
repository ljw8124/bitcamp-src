<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-05
  Time: 오후 5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>계산기</h1>
    <form action="calcResult.jsp" method="post">
        <input name="frontNumber">
        <select name="logic">
            <option>+</option>
            <option>-</option>
            <option>*</option>
            <option>/</option>
        </select>
        <input name="secondNumber">
        <button>결과 확인</button>

    </form>

</body>
</html>
