package com.hy.ssm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.ssm.bo.EmpDepSup;
import com.hy.ssm.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.service
 * @ClassName: EmployeeIservice
 * @Author: Xiaobai
 * @Description:
 * @Date: 2020/7/24 16:42
 * @Version: 1.0
 */
public interface EmployeeIservice extends IService<Employee> {
     ArrayList empList(Integer page, Integer limit,Employee employee);
     int employeedelete(String[] eid);

}
