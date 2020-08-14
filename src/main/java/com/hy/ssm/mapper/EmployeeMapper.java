package com.hy.ssm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper extends BaseMapper<Employee> {
    int empdelete(String[] eid);
    IPage<Employee> selectPageVo(@Param("page") Page page, @Param("emp") Employee emp);
}