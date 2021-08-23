<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-17
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jsp에 jstl 연결하기 위해서 추가 -->
<html>
<head>
    <title>Title</title>
</head>
<style>
    .page {
        display: flex;
        flex-direction: row;
        list-style: none;
        font-size: 15px;
    }
    .page li {
        color: saddlebrown;
        margin-left: 1.5em;
    }
    a {
        text-decoration-line: none;
    }
    .current {
        color: crimson;
        font-size: 20px;
    }

</style>
<body>
<script>
    let bno = '${param.bno}'

    if(bno) {
        alert(bno)
        window.history.replaceState(null,'','/board/list')
    }

</script>
    <h1>LIST PAGE</h1>

    <form action="/board/list.do" method="get">
        <input type="hidden" name="page" value="1"> <!-- 화면에는 보이지 않으나 form을 날리면 page=1로 전달됨 -->
        <select name="size">
            <option value="10" ${pageMaker.size == 10 ? "selected" : ""}>10</option>
            <option value="20" ${pageMaker.size == 20 ? "selected" : ""}>20</option>
            <option value="50" ${pageMaker.size == 50 ? "selected" : ""}>50</option>
            <option value="100" ${pageMaker.size == 100 ? "selected" : ""}>100</option>
        </select>
        <button type="submit">적용</button>
    </form>

    <c:forEach items="${list}" var="list">
       <ul>
           <li>
               <div>
                   <div>${list.bno}</div>
                   <div><a href="/board/read.do?bno=${list.bno}&page=${pageMaker.page}&size=${pageMaker.size}">${list.title}</a></div>
                   <div>${list.viewcount}</div>
                   <div>${list.writer}</div>
                   <div>${list.regdate}</div>
               </div>
           </li>
       </ul>
    </c:forEach>

    <hr>

    <ul class="page">
        <c:if test="${pageMaker.prev}">
            <li>
                <a href="/board/list.do?page=${pageMaker.start - 1}">PREV</a>
            </li>
        </c:if>
    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="page">
            <li class="${page == pageMaker.page ? "current" : ""}">
                <a href="/board/list.do?page=${page}">${page}</a>
            </li>
    </c:forEach>
        <c:if test="${pageMaker.next}">
            <li>
                <a href="/board/list.do?page=${pageMaker.end + 1}">NEXT</a>
            </li>
        </c:if>
    </ul>

</body>
</html>
