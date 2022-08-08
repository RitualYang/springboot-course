package com.wty.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 重定向，请求转发
 * @date 2022/8/8 10:48
 */
@RestController
@RequestMapping("http")
public class HttpController {


    @GetMapping("redirect")
    public String redirect(HttpServletResponse response) throws IOException {
        String url = "https://github.com/ritualyang";
        response.sendRedirect(url);
        return "OK";
    }

}
