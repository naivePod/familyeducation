package com.lgs.controller;

import com.lgs.common.Const;
import com.lgs.common.ServerResponse;
import com.lgs.dao.UserMapper;
import com.lgs.entity.User;
import com.lgs.service.IUserService;
import com.lgs.util.MD5Util;
import com.lgs.util.RoleUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController("/account")
public class AccountController {
    @Autowired
    private IUserService userService;
    @Resource
    UserMapper userMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ServerResponse login(String username, String password, HttpServletRequest request) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();

        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Util.MD5EncodeUtf8(password));
        // 执行认证登陆
        subject.login(token);
        //根据权限，指定返回数据
        String role = RoleUtil.roleidToString(userMapper.selectRoleByUsername(username));
        User user = (User)subject.getPrincipal();
        request.getSession().setAttribute(Const.CURRENT_USER, user);

        if ("user".equals(role)) {
            return ServerResponse.createBySuccess("用户登录成功");
        }
        if ("manage".equals(role)) {
            return ServerResponse.createBySuccess("管理员");
        }
        return ServerResponse.createByError("没有该权限");

    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ServerResponse<String> logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return ServerResponse.createBySuccessMsg("登出成功");
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ServerResponse register(User registerInfo) {
        return userService.register(registerInfo);
    }

    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public ServerResponse<String> notLogin() {

        return ServerResponse.createByError("未登录");
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public ServerResponse<String> notRole() {

        return ServerResponse.createByError("没有权限");
    }
}
