<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-06
  Time: 오전 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
    <h1>Input</h1>

    <form action="calcResult2.jsp" method="post" target="zero">
        <!-- style을 먹일때 div(영역구분,레이아웃때 주로 사용)를 대부분의 단위로함 -->
        <div>
            <input type="number" name="num1">
        </div>
        <div>
            <select name="oper">
                <option value="add" selected> + </option>
                <option value="sub"> - </option>
                <option value="mul"> * </option>
                <option value="div"> / </option>
            </select>
        </div>
        <div>
            <input type="number" name="num2">
        </div>
        <div>
            <button type="submit">SUBMIT</button>
        </div>
    </form>

    <!--
    iframe을 이용하면 배너와 같이 다른 페이지의 있는 것을 한페이지에서 보여주는 것처럼 구현 가능능
   -->
    <iframe name="zero"></iframe>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

</body>
</html>


