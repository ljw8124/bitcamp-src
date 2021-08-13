<%--
  Created by IntelliJ IDEA.
  User: ljw81
  Date: 2021-08-11
  Time: 오후 4:29
  To change this template use File | Settings | File Templates.
--%>
<!-- start bootStrap 적용 -->
<%@include file="../includes/header.jsp"%>
<!-- Page Content-->
<div class="container-fluid p-0">
    <!-- About-->
    <section class="resume-section" id="about">
        <div class="resume-section-content">
            <h1 class="mb-0">
                Message
                <span class="text-primary">Taylor</span>
            </h1>
            <p class="lead mb-5">I am experienced in leveraging agile frameworks to provide a robust synopsis for high level overviews. Iterative approaches to corporate strategy foster collaborative thinking to further the overall value proposition.</p>
            <div class="social-icons">
                <a class="social-icon" href="#!"><i class="fab fa-linkedin-in"></i></a>
                <a class="social-icon" href="#!"><i class="fab fa-github"></i></a>
                <a class="social-icon" href="#!"><i class="fab fa-twitter"></i></a>
                <a class="social-icon" href="#!"><i class="fab fa-facebook-f"></i></a>
            </div>
        </div>
    </section>
    <hr class="m-0" />
    <!-- Experience-->
    <section class="resume-section" id="experience">
        <div class="resume-section-content">
            <h2 class="mb-5">Register</h2>
            <form action="/msg/register" method="post">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">WHO</span>
                    </div>
                    <input type="text" name="who" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon2">WHOM</span>
                </div>
                <input type="text" name="whom" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                 </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon3">CONTENT</span>
                    </div>
                    <input type="text" name="content" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>
                <div>
                    <button type="submit" name="submit" class="btn btn-primary float--right">SUBMIT</button>
                </div>
            </form>
        </div>
    </section>

    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="/js/scripts.js"></script>

    <%@include file="../includes/footer.jsp"%>

