package com.lgs.shiro.realm;

import com.lgs.dao.UserMapper;
import com.lgs.entity.User;
import com.lgs.service.IUserService;
import com.lgs.util.RoleUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {
    private UserMapper userMapper;
    @Resource
    private IUserService iUserService;

    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String username = user.getUsername();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        int roleId = userMapper.selectRole(username);
        String role = RoleUtil.roleidToString(roleId);
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;


    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 从数据库获取对应用户名密码的用户
        String password = userMapper.getPassword(token.getUsername());
        if (null == password) {
            throw new AccountException("用户名不正确");
        } else if (!password.equals(new String((char[]) token.getCredentials()))) {
            throw new AccountException("密码不正确");
        }
        User user = iUserService.login(token.getUsername(),password).getData();
        return new SimpleAuthenticationInfo(user, password, getName());

    }
}
