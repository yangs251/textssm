package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.ssm.pojo.Employee;
import com.hy.ssm.pojo.Superior;

import java.util.List;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.service
 * @ClassName: SuperiorIservice
 * @Author: Xiaobai
 * @Description:
 * @Date: 2020/7/31 16:31
 * @Version: 1.0
 */
public interface SuperiorIservice extends IService<Superior> {
    List<Superior> superiorList();
}
