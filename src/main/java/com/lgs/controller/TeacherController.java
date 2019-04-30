package com.lgs.controller;



import com.lgs.common.Const;
import com.lgs.common.ResponseCode;
import com.lgs.common.ServerResponse;
import com.lgs.common.TokenCache;
import com.lgs.entity.Audit;
import com.lgs.entity.EducationInformation;
import com.lgs.entity.Teacher;
import com.lgs.entity.User;
import com.lgs.service.IAuditService;
import com.lgs.service.IFileService;
import com.lgs.service.ITeachInfoService;
import com.lgs.service.ITeacherService;
import com.lgs.util.PropertyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/teacher")
public class TeacherController {
    Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    IFileService iFileService;

    @Autowired
    IAuditService iAuditService;

    @Autowired
    ITeacherService iTeacherService;

    @Autowired
    ITeachInfoService iTeachInfoService;

    /**
    * @description: 修改教员信息
    * @author: lgs
    * @date:  2019/4/21
     **/
    @PutMapping("/update")
    public ServerResponse<Teacher> updateInformation(Teacher teacher) {
        User currentUser = this.getCurrentUser();
        if(currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录,无法修改");
        }
//        teacher.setId(currentUser.getId());
//        user.setUsername(currentUser.getUsername());
        ServerResponse<Teacher> updateResponse = iTeacherService.updateTeacher(teacher);

        return updateResponse;
    }


    /**
    * @description: 家教信息发布
    * @author: lgs
    * @date:  2019/4/21
     **/
    @PostMapping("/publish")
    public ServerResponse publish(HttpServletRequest request, EducationInformation educationInformation) {
        User currentUser = this.getCurrentUser();
        educationInformation.setUserId(currentUser.getId());
        educationInformation.setNick(educationInformation.getNick());
        educationInformation.setStatus(Const.TeachInformationStatus.ON_ORDER.getStatus());
        return iTeachInfoService.addTeachInfo(educationInformation);
    }

    private User getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        if(subject.getPrincipal() == null) return null;
        User user = (User)subject.getPrincipal();
        return user;
    }
}
