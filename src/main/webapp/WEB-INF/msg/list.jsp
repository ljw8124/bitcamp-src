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
            <h2 class="mb-5">Receive Message</h2>
            <c:forEach items="${Receive}" var="dto">
            <div class="d-flex flex-column flex-md-row justify-content-between mb-5">
                <div class="flex-grow-1">
                    <h3 class="mb-0"><a href="/msg/read?mno=${dto.mno}">${dto.mno}</a> - ${dto.who}</h3>
                    <div class="subheading mb-3">Intelitec Solutions</div>
                    <p>${dto.content}</p>
                </div>
                <div class="flex-shrink-0"><span class="text-primary">${dto.regdate}</span></div>
            </div>
            </c:forEach>
        </div>
    </section>
<hr>
    <section class="resume-section" id="experience">
        <div class="resume-section-content">
            <h2 class="mb-5">Send Message</h2>
            <c:forEach items="${Send}" var="dto">
                <div class="d-flex flex-column flex-md-row justify-content-between mb-5">
                    <div class="flex-grow-1">
                        <h3 class="mb-0">${dto.mno} - ${dto.who}</h3>
                        <div class="subheading mb-3">Intelitec Solutions</div>
                        <p>${dto.content}</p>
                    </div>
                    <div class="flex-shrink-0"><span class="text-primary">${dto.opendate}</span></div> <!-- -->
                </div>
            </c:forEach>
        </div>
    </section>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="/js/scripts.js"></script>

<%@include file="../includes/footer.jsp"%>

