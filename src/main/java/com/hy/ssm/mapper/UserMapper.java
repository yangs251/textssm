package com.hy.ssm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.ssm.pojo.Employee;
import com.hy.ssm.pojo.User;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.mapper
 * @ClassName: UserMapper
 * @Author: Xiaobai
 * @Description: 用户mappper
 * @Date: 2020/8/5 15:13
 * @Version: 1.0
 */
public interface UserMapper extends BaseMapper<User>{
    User username(String uname);
}
