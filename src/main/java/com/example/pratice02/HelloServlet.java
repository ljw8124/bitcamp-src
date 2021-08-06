package com.example.pratice02;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private String message;
    private int count;

    public void init() {
        message = "Hello World!";
        count = 0;
        System.out.println("HelloServlet init...."); //log라고 함
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ++count;

        String str = count % 2 == 0 ? "짝수" : "홀수";

        response.setContentType("text/html;charset=UTF-8");

        // Hello
        PrintWriter out = response.getWriter(); //writer는 char단위로 받음
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + count + "</h1>");
        out.println("<h1>" + str + "</h1>");
        out.println("</body></html>");

        out.close();
    }

    public void destroy() {
    }
}