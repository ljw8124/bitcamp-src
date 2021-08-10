package com.example.ex22.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HelloController", value = "/hello")
@Log4j2
public class HelloController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("doGet ready...............하이루.........");

        String msg = "생성된 데이터";

        String[] arr = {"가가가", "나나나", "다다다", "라라라", "마마마", "바바바"};

        request.setAttribute("data", msg); //jsp의 역할이 화면 출력만을 의마하게 됨. 일종의 배달부
        request.setAttribute("arr", arr);

        //Dispatcher를 이용하여 WEB-INF에 있는 hello.jsp로 리소스를 보내라.
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/hello.jsp");

        dispatcher.forward(request, response);
        //request와 response를 dispatcher에게 보내라
    }

}
