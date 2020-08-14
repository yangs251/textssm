package com.hy.ssm.web;

import com.hy.ssm.pojo.User;
import com.hy.ssm.service.UserIservice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Wrapper;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.web
 * @ClassName: UserController
 * @Author: Xiaobai
 * @Description: 用户管理
 * @Date: 2020/8/4 17:10
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController  {
    @Autowired
    private UserIservice userIservice;

    @RequestMapping("login.do")
    public String login(User user){
       UsernamePasswordToken token=new UsernamePasswordToken(user.getUname(),user.getPasswrod());
        Subject subject =SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
           System.out.println(e.getMessage());
        }
        return "/layui/laylist.html";
    }
}
