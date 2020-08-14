package com.hy.ssm.web;

import com.alibaba.fastjson.JSONArray;
import com.hy.ssm.pojo.Department;
import com.hy.ssm.pojo.Superior;
import com.hy.ssm.service.DepartmentIservice;
import com.hy.ssm.service.SuperiorIservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.web
 * @ClassName: DepartmentController
 * @Author: Xiaobai
 * @Description:
 * @Date: 2020/7/31 16:29
 * @Version: 1.0
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentIservice departmentIservice;
    @PostMapping("/listdepartment.do")
    @ResponseBody
    public List<Department>   listDepartment(HttpServletResponse response) throws IOException {
        return departmentIservice.departmentList();

    }

}
