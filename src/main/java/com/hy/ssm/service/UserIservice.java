package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.ssm.pojo.Superior;
import com.hy.ssm.pojo.User;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.service
 * @ClassName: UserIservice
 * @Author: Xiaobai
 * @Description: 用户service接口
 * @Date: 2020/8/5 15:04
 * @Version: 1.0
 */
public interface UserIservice extends IService<User> {
    User useruname(String uname);
}

