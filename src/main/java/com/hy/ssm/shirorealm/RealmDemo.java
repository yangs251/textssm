package com.hy.ssm.shirorealm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.ssm.pojo.User;
import com.hy.ssm.service.UserIservice;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.krb5.internal.ccache.CredentialsCache;

import java.util.List;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.shirorealm
 * @ClassName: RealmDemo
 * @Author: Xiaobai
 * @Description:
 * @Date: 2020/8/4 10:05
 * @Version: 1.0
 */
public class RealmDemo extends AuthorizingRealm {
      @Autowired
      private UserIservice userIservice;
    /*认证*/

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /*获取用户名*/
        UsernamePasswordToken usernamePasswordToken =(UsernamePasswordToken) authenticationToken;
        String username=usernamePasswordToken.getUsername();
        /*根据用户名查询数据库*/
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("uname",username);
        User user=(User)userIservice.getOne(queryWrapper);
        if (user==null){
            throw new UnknownAccountException("用户不存在");
        }
        if (user.getUname() == null || user.getUname().equals(1)) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        if (!user.getPasswrod().equals(new String(usernamePasswordToken.getPassword()))) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        SimpleAuthenticationInfo simp=new  SimpleAuthenticationInfo(user,user.getPasswrod(),getName());

        return simp;

    }
    /*授权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;

    }
}

