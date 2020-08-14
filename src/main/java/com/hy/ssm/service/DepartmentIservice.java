package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.ssm.pojo.Department;

import java.util.List;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.service
 * @ClassName: DepertmentIservice
 * @Author: Xiaobai
 * @Description:
 * @Date: 2020/7/31 16:35
 * @Version: 1.0
 */
public interface DepartmentIservice extends IService<Department> {
    List<Department> departmentList();
}
