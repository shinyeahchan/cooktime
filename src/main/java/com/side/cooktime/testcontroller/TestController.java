package com.side.cooktime.testcontroller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Log4j2
@Controller
public class TestController {
    @GetMapping("/ready")
    @ResponseBody
    public String ready(){
        log.info("Server Status Check");
        return "Server is ready. Time is "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일, HH시 mm분 ss초"));
    }
}
