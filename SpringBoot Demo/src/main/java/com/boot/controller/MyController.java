package com.boot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Liuqi
 * Date: 2017/5/16.
 */
@Controller
public class MyController {
    @RequestMapping(value = "/*")
    @ResponseBody
    public String home() {
        return "hello world home ";
    }

    public static void main(String[] args) {
        SpringApplication.run(MyController.class, args);
    }
}
