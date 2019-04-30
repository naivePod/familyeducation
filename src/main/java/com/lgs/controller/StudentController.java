package com.lgs.controller;

import com.lgs.common.Const;
import com.lgs.common.ServerResponse;
import com.lgs.entity.Student;
import com.lgs.entity.User;
import com.lgs.service.IStudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RequestMapping("/student")
@Controller
public class StudentController {
    Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    IStudentService iStudentService;
    @PostMapping("/register")
    @ResponseBody
    public ServerResponse register(Student student) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        student.setUserId(user.getId());
        student.setEmail(user.getEmail());
        student.setPhone(user.getPhone());
        student.setSnick(user.getUsername());
        student.setState(Const.StudentState.DEFAULT);
        return iStudentService.addStudent(student);
    }

    @GetMapping("/detail")

    public String getInformation(Model model,HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute(Const.CURRENT_USER);

        ServerResponse serverResponse = iStudentService.getStudentInfo(user.getId());
        Student student = (Student)serverResponse.getData();
        logger.debug("a",student);
        model.addAttribute("student", student);
        return "student/information";
    }

    @PutMapping("/update")
    @ResponseBody
    public ServerResponse updateInformation(Student student) {
        return iStudentService.updateStudentInfo(student);
    }

}
