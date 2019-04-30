package com.lgs.controller;

import com.lgs.common.Const;
import com.lgs.common.ResponseCode;
import com.lgs.common.ServerResponse;
import com.lgs.dao.UserMapper;
import com.lgs.entity.User;
import com.lgs.service.IAuditService;
import com.lgs.service.IFileService;
import com.lgs.service.ITeacherService;
import com.lgs.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService userService;

    @Resource
    private UserMapper userMapper;

    @Autowired
    IFileService iFileService;

    @Autowired
    IAuditService iAuditService;

    @Autowired
    ITeacherService iTeacherService;


    @RequestMapping(value = "check_valid.do", method = RequestMethod.POST)
     @ResponseBody
    public ServerResponse<String> checkValid(String str, String type) {
        return userService.valicate(str, type);
    }

    @RequestMapping(value = "get_user_info.do", method = RequestMethod.POST)
    public ServerResponse<User> getUserInfo(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();

        return ServerResponse.createBySuccess(user);
    }

    @RequestMapping(value = "reset_password.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> resetPassword(String oldPassword, String newPassword, HttpSession session) {
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null) {
            return ServerResponse.createByErrorMsg("用户未登录,无法修改密码");
        }
        return userService.resetPassword(oldPassword, newPassword, user.getUsername());
    }

    @RequestMapping(value = "forget_get_question.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String username) {
        ServerResponse<String> forgetResponse = userService.forgetGetQuestion(username);

        return forgetResponse;
    }

    @RequestMapping(value = "forget_check_answer.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> queryAnswer(String username, String question, String answer, HttpSession session) {

        //todo 重定向
        return userService.checkAnswer(username, question, answer);
    }

    @RequestMapping(value = "forget_reset_password.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetResetPassword(String username, String passwordNew, String token) {
        return userService.forgetResetPassword(username, passwordNew, token);
    }

    @RequestMapping(value = "update_information.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> updateInformation(User user, HttpSession session) {
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录,无法修改");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> updateResponse = userService.updateInformation(user);
        if(updateResponse.isSuccess()) {
            User updateUser = updateResponse.getData();
            updateUser.setUsername(currentUser.getUsername());
            session.setAttribute(Const.CURRENT_USER, updateUser);
        }
        return updateResponse;
    }
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public ServerResponse<User> getInformation(HttpSession session) {
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录,无法修改");
        }

        return userService.getInformation(currentUser.getId());
    }
}
