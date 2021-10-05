package org.zerock.sb01.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.sb01.dto.SampleDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

    @GetMapping("/ex1")
    public void ex1() {
        log.info("ex1..................");
    }

    @GetMapping("/ex2")
    public void ex2(Model model) {
        log.info("ex2..................");

        List<SampleDTO> dtoList =
                IntStream.rangeClosed(1, 100)
                        .mapToObj(i -> SampleDTO.builder()
                                .sno((long) i)
                                .title("title" + i)
                                .regdate(LocalDateTime.now())
                                .build()
                        )
                        .collect(Collectors.toList());

        model.addAttribute("list", dtoList);



    }
}
