package com.hy.ssm.web;

import com.hy.ssm.bo.EmpDepSup;
import com.hy.ssm.bo.layuiemp;
import com.hy.ssm.pojo.Employee;
import com.hy.ssm.service.EmployeeIservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.web
 * @ClassName: EmployeeController
 * @Author: Xiaobai
 * @Description: 员工controller
 * @Date: 2020/7/22 11:25
 * @Version: 1.0
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeIservice employeeIservice;
    @RequestMapping("/addemp.do")
    @ResponseBody
    public  String addEmp(@RequestParam(value = "eidt",required = false)MultipartFile MultipartFile1, @RequestParam(value = "edity",required = false)MultipartFile MultipartFile2, Employee employee, HttpServletRequest request) throws IOException {
        System.out.println(employee.getEname());
        System.out.println(employee.getEsex());
        System.out.println(employee.getSid());
        System.out.println(employee.getDid());
        String path = request.getSession().getServletContext().getRealPath("");
        File fi = new File(path);
        path=fi.getParent();
        String  newpath=path+"/uploads";
        //判断该路径是否存在
        File fil=new File(newpath);
        if (!fil.exists()) {
            fil.mkdirs();
        }
        System.out.println(MultipartFile1+"======="+MultipartFile2);
        String newfile=MultipartFile1.getOriginalFilename();
        System.out.println(newfile);
        String newfiley=MultipartFile2.getOriginalFilename();
        System.out.println(newfiley);
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String filename = uuid + "_" + newfile.substring(newfile.lastIndexOf(File.separator) + 1);
        String uuid1 = UUID.randomUUID().toString().replace("-", "");
        String filenamey = uuid1 + "_" + newfiley.substring(newfiley.lastIndexOf(File.separator) + 2);
        MultipartFile1.transferTo(new File(newpath, filename));
        MultipartFile2.transferTo(new File(newpath,filenamey));
        employee.setEidentity("/uploads/"+filename);
        employee.setEidentityy("/uploads/"+filenamey);
        /*employeeIservice(employee);*/
        return  "redirect:/employee/emplist.do";
    }

    @RequestMapping("add.do")
    public  String add(Employee employee){
        employeeIservice.save(employee);
        return  "laylist.html";
    }


    @RequestMapping("/emplist.do")
    @ResponseBody
    public  layuiemp empList(Integer page,Integer limit,Employee employee){
        ArrayList<EmpDepSup> list= employeeIservice.empList(page,limit,employee);
        layuiemp lay=new layuiemp();
        lay.setCode(0);
        lay.setMsg("fa");
        lay.setCount(list.size());
        lay.setData(list);
        return lay;
    }


    @RequestMapping("/empdelete.do")
    @ResponseBody
    public int empDelete(@RequestParam("isStr") String  id){
        System.out.println(id);
        if (id!=null &&!id.equals("")) {
            String[] ids = id.split(",");
            int a= employeeIservice.employeedelete(ids);
            return a;
        }
        return  0;
    }
    @RequestMapping("/upload.do")
    @ResponseBody
    public layuiemp pictureUpload(@RequestParam("file") MultipartFile filename, HttpServletResponse response, HttpServletRequest request)throws IOException{
        //设置图片名称 不能重复
        String picName = UUID.randomUUID().toString();
        //获取文件名
        String oriName = filename.getOriginalFilename();
        //获取文件后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));
        //获取到的是当前项目的绝对路径
        String filePath = request.getServletContext().getRealPath("/");
        System.out.println(filePath+"================");
        File file=new File(filePath);
        //开始上传
        filePath=file.getParentFile().toString();

        File parentfile=new File(filePath+"\\upload\\" + picName + extName);
        System.out.println(parentfile);
        filename.transferTo(parentfile);
        layuiemp utisMsg=new layuiemp();
        utisMsg.setCode(0);
        utisMsg.setMsg("");
        utisMsg.setData(Collections.singletonList(("\\upload\\" + picName + extName)));
        return utisMsg;
    }
}
