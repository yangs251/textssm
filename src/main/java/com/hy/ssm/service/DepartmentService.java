package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ssm.mapper.DepartmentMapper;
import com.hy.ssm.mapper.EmployeeMapper;
import com.hy.ssm.mapper.SuperiorMapper;
import com.hy.ssm.pojo.Department;
import com.hy.ssm.pojo.Employee;
import com.hy.ssm.pojo.Superior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.service
 * @ClassName: DepartmentService
 * @Author: Xiaobai
 * @Description:
 * @Date: 2020/7/31 16:36
 * @Version: 1.0
 */
@Service
@Transactional
public class DepartmentService extends ServiceImpl<DepartmentMapper, Department> implements DepartmentIservice {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> departmentList(){
        return departmentMapper.selectList(null);
    }
}
