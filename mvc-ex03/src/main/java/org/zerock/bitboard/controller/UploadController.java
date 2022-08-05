package org.zerock.bitboard.controller;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;

@WebServlet(name = "upload", value = "/upload")
@Log4j2
@MultipartConfig(fileSizeThreshold = 1024 * 1024)
public class UploadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/upload.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uploadFolder = "C:\\upload";
        byte[] buffer = new byte[1024*8];

        Collection<Part> parts = request.getParts();

        parts.forEach(part -> { //form에서 받은 multiple file을 part 콜렉션을 이용하여 DB로 보내기위한 밑작업
            log.info(part);

            String type = part.getContentType();
            if(type == null) {
                log.info("partName : " + part.getName());
                log.info("--------------------------------");
                return;
            }
            log.info(type);

            String fileName =  part.getSubmittedFileName();

            String uploadFileName = System.currentTimeMillis() + "_" + fileName;

            log.info(fileName);

            //try.catch에 넣는 이유는 inputStream이 열렸다가 자동으로 닫히기fdf를 원해서이다
            //원본 파일 저장
            try (InputStream in = part.getInputStream();
                 OutputStream fos = new FileOutputStream(uploadFolder + File.separator + uploadFileName);
                 //실시간을 주기때문에 파일 명이 같아도 겹치지 않고 따로 생성됨
            ) {
                while(true) {
                    int count = in.read(buffer); //read는 1바이트씩 읽어서 리턴하는 메서드
                    if (count == -1) { break; }
                    fos.write(buffer,0,count); //0부터 count까지 작성
                }

            } catch (Exception e) {

            }//원본 파일 저장 끝

            //이미지에 대새서만 섬네일 제작
            if (type.startsWith("image")) {
                try {
                    Thumbnails.of(uploadFolder + File.separator + uploadFileName)
                            .size(100, 100)
                            .toFile(uploadFolder + File.separator + "s_" + uploadFileName);
                } catch (Exception e) {

                }
            }

            log.info("-----------------------------");
        });

    }
}
