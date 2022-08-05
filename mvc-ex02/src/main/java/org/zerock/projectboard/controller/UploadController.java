package org.zerock.projectboard.controller;

import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;
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
@MultipartConfig(fileSizeThreshold = 1024*1024)
@Log4j2
public class UploadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/upload.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("upload controller doPost................");

        request.setCharacterEncoding("UTF-8");

        String uploadFolder = "C:\\upload";
        byte[] buffer = new byte[1024*8];

        Collection<Part> parts = request.getParts();

        parts.forEach(part -> {
            log.info(part);

            String type = part.getContentType();
            if (type == null) {
                log.info("partName : " + part.getName());
                log.info("---------------------------------------");
                return;
            }
            log.info(type);

            String fileName = part.getSubmittedFileName();

            String uploadFileName = System.currentTimeMillis() + "_" + fileName;

            log.info(fileName);

            try (
                InputStream in = part.getInputStream();
                OutputStream fos = new FileOutputStream(uploadFolder + File.separator + uploadFileName);
            ) {
                while(true) {
                    int count = in.read(buffer);
                    if (count == -1) { break; }
                    fos.write(buffer,0,count);
                }

            } catch (Exception e) { }
            if (type.startsWith("image")) {
                try {
                    Thumbnails.of(uploadFolder + File.separator + uploadFileName)
                            .size(160, 160)
                            .toFile(uploadFolder + File.separator + "s_" + uploadFileName);
                } catch (Exception e) {
                }
            }
            log.info("-----------------------------------------");
        });






    }
}
