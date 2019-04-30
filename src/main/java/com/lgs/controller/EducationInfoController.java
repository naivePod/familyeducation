package com.lgs.controller;

import com.github.pagehelper.PageInfo;
import com.lgs.common.ServerResponse;
import com.lgs.service.ITeachInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/educationinfo")
public class EducationInfoController {
    @Resource
    ITeachInfoService iTeachInfoService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(name="pageNum", defaultValue = "1")Integer pageNum,
                       @RequestParam(name="pageSize", defaultValue = "20")Integer pageSize) {
        PageInfo<List> pageInfo = iTeachInfoService.getTeachInfo(null, null, pageNum, pageSize).getData();
        model.addAttribute("pageInfo", pageInfo);
        return "/educationinfo/ordercenter.html";
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(value = "grade",required = false) String city,
                         @RequestParam(value = "categoryId",required = false) String subject,
                         @RequestParam(name="pageNum", defaultValue = "1")Integer pageNum,
                         @RequestParam(name="pageSize", defaultValue = "20")Integer pageSize) {
        PageInfo<List> pageInfo = iTeachInfoService.getTeachInfo(city, subject, pageNum, pageSize).getData();
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("cur_city", city);
        model.addAttribute("cur_subject", subject);
        //todo 查询city跟subject
        return "/educationinfo/ordercenter.html";
    }
}
