<%--
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
    <h1>ADD</h1>
    <form action="addResult.jsp" method="post">
        <!-- 더미데이터 생산 -->
        <div>
            <input type="text" name="name" value="식당A">
            <!-- value를 default값으로 넣음 -->
        </div>
        <div>
            <input type="text" name="area" value="목동">
        </div>
        <div>
            <input type="text" name="desc" value="설명">
        </div>
        <div>
            <input type="text" name="link">
        </div>
        <div>
            <button type="reset">RESET</button>
            <button type="submit">SUBMIT</button>
        </div>
    </form>


</body>
</html>
