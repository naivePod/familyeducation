package com.lgs.controller;

import com.lgs.common.Const;
import com.lgs.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {
    @RequestMapping("/index")
    public String index(Model model) {
        Subject subject = SecurityUtils.getSubject();
        if(subject.getPrincipal() != null) {
            User user = (User)subject.getPrincipal();
            model.addAttribute(Const.CURRENT_USER,user);
        }
        return "index";
    }

    @RequestMapping("/login.html")
    public String login(Model model) {

        return "login";
    }
}
