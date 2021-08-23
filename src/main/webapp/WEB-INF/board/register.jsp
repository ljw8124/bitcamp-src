<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-19
  Time: 오후 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/board/register.do" method="post">
        제목 : <input type="text" name="title" value="sample title">
        내용 : <textarea name="content">sample content</textarea>
        작성자 : <input type="text" name="writer" value="sample user">
        <button type="submit">등록</button>
    </form>

</body>
</html>
