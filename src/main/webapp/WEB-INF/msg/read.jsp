<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-11
  Time: 오후 4:29
  To change this template use File | Settings | File Templates.
--%>
<!-- start bootStrap 적용 -->
<%@include file="../includes/header.jsp"%>

    <!-- Experience-->
    <section class="resume-section" id="experience">
        <div class="resume-section-content">
            <h2 class="mb-5">READ</h2>
            <form action="/msg/remove" method="post">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon0">Number</span>
                    </div>
                    <input type="text" name="mno" value="${dto.mno}" readonly class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">WHO</span>
                    </div>
                    <input type="text" name="who" value="${dto.who}" readonly class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon2">WHOM</span>
                    </div>
                    <input type="text" name="whom" value="${dto.whom}" readonly class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon3">CONTENT</span>
                    </div>
                    <input type="text" name="content" value="${dto.content}" readonly class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>
                <div>
                    <button type="submit" name="submit" class="btn btn-primary float--right">DELETE</button>
                </div>
            </form>


        </div>
    </section>

    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="/js/scripts.js"></script>

    <%@include file="../includes/footer.jsp"%>

