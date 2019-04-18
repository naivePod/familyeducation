package com.lgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @RequestMapping("/t")
    public String index() {
        return "view/side";
    }
    @RequestMapping("/publish")
    public String pubilsh() {
        return "view/public_teachinfo";
    }
    @RequestMapping("/teachinfolist")
    public String teachinfolist() {
        return "view/teachinfolist";
    }

    @RequestMapping("/json")
    public void json() {
        int a = 1/0;

    }
}
