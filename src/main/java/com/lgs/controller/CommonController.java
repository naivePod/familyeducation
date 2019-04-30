package com.lgs.controller;

import com.github.pagehelper.PageInfo;
import com.lgs.common.Const;
import com.lgs.common.ServerResponse;
import com.lgs.entity.EducationInformation;
import com.lgs.entity.User;
import com.lgs.service.ITeachInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CommonController {
    @Resource
    ITeachInfoService iTeachInfoService;

    Logger logger = LoggerFactory.getLogger(CommonController.class);

    @RequestMapping("/index")
    public String index(Model model) {
//        Subject subject = SecurityUtils.getSubject();
//        if(subject.getPrincipal() != null) {
//            User user = (User)subject.getPrincipal();
//            model.addAttribute(Const.CURRENT_USER,user);
//        }
        return "index";
    }

    @RequestMapping("/login.html")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/user/person.html")
    public String person(Model model) {
        return "user/person.html";
    }



    @RequestMapping("/user/sinformation.html")
    public String sinforrmation(Model model) {
        return "redirect:/student/detail";
    }
    @RequestMapping("/user/register.html")
    public String registerTeacher(Model model) {
        return "redirect:/student/detail";
    }
    @RequestMapping("/user/notice.html")
    public String notice(Model model) {
        return "/user/notice.html";
    }
    @RequestMapping("/user/orderinfo.html")
    public String orderinfo(Model model) {
        return "/user/orderinfo.html";
    }
    @RequestMapping("/detail.html")
    public String detail(Model model) {
        return "/teacher/detail.html";
    }
    @RequestMapping("/ordercenter.html")
    public String ordercenter(Model model) {
        return "/educationinfo/ordercenter.html";
    }

    @GetMapping("/list")
    @ResponseBody
    public ServerResponse<List<EducationInformation>> list() {
        return iTeachInfoService.getExcellentTeachers();
    }

    @GetMapping("/orderlist")
    @ResponseBody
    public ServerResponse<PageInfo<List>> list(Model model,
                                               @RequestParam(name = "city", required = false)String city,
                                               @RequestParam(name="subject", required = false)String _subject,
                                               @RequestParam(name="pageNum", defaultValue = "1")Integer pageNum,
                                               @RequestParam(name="pageSize", defaultValue = "20")Integer pageSize) {
        Subject subject = SecurityUtils.getSubject();
        if(subject.getPrincipal() != null) {
            User user = (User)subject.getPrincipal();
            model.addAttribute(Const.CURRENT_USER,user);
        }

        return iTeachInfoService.getTeachInfo(city,_subject,pageNum,pageSize);
    }

    @GetMapping("/search")
    @ResponseBody
    public ServerResponse<PageInfo<List>> search(Model model,
                                               @RequestParam(name = "name", defaultValue = "")String name,

                                               @RequestParam(name="pageNum", defaultValue = "1")Integer pageNum,
                                               @RequestParam(name="pageSize", defaultValue = "20")Integer pageSize) {
        Subject subject = SecurityUtils.getSubject();
        if(subject.getPrincipal() != null) {
            User user = (User)subject.getPrincipal();
            logger.info("user", user);
            model.addAttribute(Const.CURRENT_USER,user);
        }

        return iTeachInfoService.getTeachInfoByName(name, pageNum, pageSize);
    }

}
