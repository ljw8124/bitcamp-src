<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">List Page</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Dashboard v1</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <!-- Small boxes (Stat box) -->

                <!-- Main row -->
                <div class="row">
                    <!-- Left col -->
                    <section class="col-lg-12">

                        <!-- TO DO List -->
                        <div class="card">
                            <form action="/board/register">
                                <div class="card-header">
                                    <h3 class="card-title">
                                        <i class="ion ion-clipboard mr-1"></i>
                                        To Do List
                                    </h3>
                                    <button type="submit" class="btn btn-primary btnRegister" style="float:right">글쓰기</button>
                                </div>
                            </form>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th style="width: 20px">BNO</th>
                                        <th>TITLE</th>
                                        <th>WRITER</th>
                                        <th>REGDATE</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${dtoList}" var="dto">
                                    <tr>
                                        <td><c:out value="${dto.bno}"></c:out></td> <!-- c:out을 쓰는 이유 보안성 문제 -->
                                        <td><a href="javascript:moveRead(${dto.bno})"><c:out value="${dto.title}"></c:out></a></td>
                                        <td><c:out value="${dto.writer}"></c:out></td>
                                        <td><c:out value="${dto.regDate}"></c:out></td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
                            <div class="card-footer clearfix">

                                <ul class="pagination pagination-sm m-0 float-right">

                                    <c:if test="${pageMaker.prev}">
                                    <li class="page-item"><a class="page-link" href="javascript:movePage(${pageMaker.start - 1})"> << </a></li>
                                    </c:if>

                                    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
                                    <li class="page-item ${pageMaker.page == num?'active':''}"><a class="page-link" href="javascript:movePage(${num})">${num}</a></li>
                                    </c:forEach>

                                    <c:if test="${pageMaker.next}">
                                        <li class="page-item"><a class="page-link" href="javascript:movePage(${pageMaker.end + 1})"> >> </a></li>
                                    </c:if>

                                </ul>

                            </div>
                        </div>
                        <!-- /.card -->
                    </section>
                    <!-- /.Left col -->

                </div>
                <!-- /.row (main row) -->
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>

<div class="modal fade" id="modal-sm">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Small Modal</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>One fine body&hellip;</p>
            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<form id="actionForm" action="/board/list" method="get">
    <input type="hidden" name="page" value="${pageMaker.page}">
    <input type="hidden" name="size" value="${pageMaker.size}">
</form>


<%@include file="../includes/footer.jsp"%>

<script>

    const actionForm = document.querySelector("#actionForm")

    const result = '${result}';

    if(result && result !== '') {
        $('#modal-sm').modal('show')
        window.history.replaceState(null,'','/board/list')
    } //모달호출

    function movePage(pageNum) {
        // event.preventDefault()
        // event.stopPropagation()

        actionForm.querySelector("input[name='page']").setAttribute("value",pageNum)

        actionForm.submit();
    }

    function moveRead(bno) {

        actionForm.setAttribute("action","/board/read") //action에 list였던 것을 read로 이동
        actionForm.innerHTML += `<input type='hidden' name='bno' value='\${bno}'>`

        actionForm.submit();

    }



</script>

</body>
</html>

