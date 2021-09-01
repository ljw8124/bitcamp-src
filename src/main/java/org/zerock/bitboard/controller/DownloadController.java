package org.zerock.bitboard.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(name = "DownloadController", value = "/down")
@Log4j2
public class DownloadController extends HttpServlet {

    //다운로드의 원리
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Download........... doGet..........");

        String path = "C:\\upload";
        String fileName = request.getParameter("fname");

        //file이 없는 경우를 생각해보면 try/catch와 같이 예외처리가 필요
        File targetFile = new File(path, fileName);
        OutputStream out = null;

        try {
            out = response.getOutputStream();
            Path targetPath = targetFile.toPath();
            //mime type 지정
            String contentType = Files.probeContentType(targetPath);
            log.info(contentType);

            response.setContentType(contentType);
            Files.copy(targetPath, out);

        } catch (Exception e) {
             e.printStackTrace();
        } finally {
            try { out.close(); } catch (Exception e) { }//outputStream을 쓰고 닫아줘야함
        }





    }

}
