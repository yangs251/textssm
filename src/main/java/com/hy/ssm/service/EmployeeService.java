package com.hy.ssm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ssm.bo.EmpDepSup;
import com.hy.ssm.mapper.DepartmentMapper;
import com.hy.ssm.mapper.EmployeeMapper;
import com.hy.ssm.mapper.SuperiorMapper;
import com.hy.ssm.pojo.Department;
import com.hy.ssm.pojo.Employee;
import com.hy.ssm.pojo.Superior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.service
 * @ClassName: employee
 * @Author: Xiaobai
 * @Description:
 * @Date: 2020/7/22 10:34
 * @Version: 1.0
 */
@Service
@Transactional
public class EmployeeService extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeIservice {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private SuperiorMapper superiorMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public ArrayList<EmpDepSup> empList(Integer page, Integer limit, Employee emp) {
        if (page==null || page.equals("")){
            page=1;
        }
        if (limit==null || limit.equals("")){
            limit=5;
        }
         Page page1=new Page(page,limit);
        //查询出所有的员工
        ArrayList<EmpDepSup> list = new ArrayList();

        //分页加模糊查询
        IPage<Employee> listemp = employeeMapper.selectPageVo(page1,emp);

        //获取对应的部门和职位
        for (Employee employee : listemp.getRecords()) {
            Department department = departmentMapper.depselect(employee.getDid());
            List<Superior> listsup = superiorMapper.supselect(employee.getSid());
            StringBuffer idbuffer = new StringBuffer();
            StringBuffer namebuffer = new StringBuffer();

            //将职位进行处理，并封装
            for (Superior superior : listsup) {
                idbuffer = idbuffer.append(superior.getSid() + ",");
                namebuffer = namebuffer.append(superior.getSname() + ",");
            }
            String ids = idbuffer.toString().substring(0, idbuffer.toString().length() - 1);
            String names = namebuffer.toString().substring(0, namebuffer.toString().length() - 1);
            Map<String, String> hashMap = new HashMap<>();
            hashMap.put(ids,names);//1，2，3
            //封装全部数据
            EmpDepSup eds=new EmpDepSup(employee,department,hashMap);
            list.add(eds);
        }
        return  list;
    }
    @Override
    public  int employeedelete(String[] eid){
       return employeeMapper.empdelete(eid);
    }

}



