<%@ page import="com.example.pratice02.dto.StoreDTO" %>
<%@ page import="com.example.pratice02.service.StoreService" %><%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-06
  Time: 오후 6:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8"); //한글 안깨지게 출력하는 방법, 한글은 3byte로 전송되면서 한글이 깨짐..
    String name = request.getParameter("name");
    String area = request.getParameter("area");
    String desc = request.getParameter("desc");
    String link = request.getParameter("link");

    //StoreDTO에 Build 어노테이션 이용 -> DTO 객체 생성에 좋음
    StoreDTO dto = StoreDTO.builder()
            .name(name)
            .area(area)
            .desc(desc)
            .link(link)
            .build();

    StoreService.INSTANCE.add(dto); // 위에서 입력한 식당 정보를 enum INSTANCE에 추가

    //response는 write 또는 out의 느낌을 가짐짐
    //redirect는 페이지 이동하기 (response하면 자동으로 show.jsp로 페이지 이동)
   response.sendRedirect("show.jsp");
%>
<!-- 기능만을 수행하기 때문에 연결페이지일 뿐이지 다른 출력문은 필요 없음.
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><a href="show.jsp">목록보기</a> </h1>
    <h2><%= name%></h2>
    <h2><%= area%></h2>
    <h2><%= desc%></h2>
    <h2><%= link%></h2>
</body>
</html>
-->