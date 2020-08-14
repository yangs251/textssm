package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ssm.mapper.UserMapper;
import com.hy.ssm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.service
 * @ClassName: UserService
 * @Author: Xiaobai
 * @Description: 用户service
 * @Date: 2020/8/5 15:09
 * @Version: 1.0
 */
@Service
@Transactional
public class UserService extends ServiceImpl<UserMapper,User> implements UserIservice{
    @Autowired
    private  UserMapper userMapper;
    @Override
    public User useruname(String uname){
      return   userMapper.username(uname);
    }
}
