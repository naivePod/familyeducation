package com.lgs.controller.foreground;

import com.lgs.common.Const;
import com.lgs.common.ResponseCode;
import com.lgs.common.ServerResponse;
import com.lgs.entity.User;
import com.lgs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse<User> response = userService.login(username, password);
        if(response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());

        }
        return response;
    }

    @RequestMapping(value = "logout.do", method = RequestMethod.POST)
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);

        return ServerResponse.createBySuccessMsg("登出成功");
    }

    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    public ServerResponse register(User registerInfo) {
        return userService.register(registerInfo);
    }

    @RequestMapping(value = "check_valid.do", method = RequestMethod.POST)
     
    public ServerResponse<String> checkValid(String str, String type) {
        return userService.valicate(str, type);
    }

    @RequestMapping(value = "get_user_info.do", method = RequestMethod.POST)
     
    public ServerResponse<User> getUserInfo(HttpSession session) {
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null) {
            return ServerResponse.createByErrorMsg("用户未登录,无法获取当前用户信息");
        }
        return ServerResponse.createBySuccess(user);
    }

    @RequestMapping(value = "reset_password.do", method = RequestMethod.POST)
     
    public ServerResponse<String> resetPassword(String oldPassword, String newPassword, HttpSession session) {
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null) {
            return ServerResponse.createByErrorMsg("用户未登录,无法修改密码");
        }
        return userService.resetPassword(oldPassword, newPassword, user.getUsername());
    }

    @RequestMapping(value = "forget_get_question.do", method = RequestMethod.POST)
     
    public ServerResponse<String> forgetGetQuestion(String username) {
        ServerResponse<String> forgetResponse = userService.forgetGetQuestion(username);

        return forgetResponse;
    }

    @RequestMapping(value = "forget_check_answer.do", method = RequestMethod.POST)
     
    public ServerResponse<String> queryAnswer(String username, String question, String answer, HttpSession session) {

        //todo 重定向
        return userService.checkAnswer(username, question, answer);
    }

    @RequestMapping(value = "forget_reset_password.do", method = RequestMethod.POST)
     
    public ServerResponse<String> forgetResetPassword(String username, String passwordNew, String token) {
        return userService.forgetResetPassword(username, passwordNew, token);
    }

    @RequestMapping(value = "update_information.do", method = RequestMethod.POST)
     
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
    @RequestMapping(value = "get_information.do", method = RequestMethod.POST)
     
    public ServerResponse<User> getInformation(HttpSession session) {
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录,无法修改");
        }

        return userService.getInformation(currentUser.getId());
    }
}