package com.lgs.controller;

import com.lgs.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.Queue;

@RestController
public class UserController {
    @RequestMapping("getUser")
    public User getUser() {
        User user = new User();
        user.setName("Tom");
        Queue que = new LinkedList();
        return user;
    }
}
