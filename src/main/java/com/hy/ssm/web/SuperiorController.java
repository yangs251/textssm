package com.hy.ssm.web;

import com.alibaba.fastjson.JSONArray;
import com.hy.ssm.pojo.Superior;
import com.hy.ssm.service.SuperiorIservice;
import com.hy.ssm.service.SuperiorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.web
 * @ClassName: SuperiorController
 * @Author: Xiaobai
 * @Description: 职位服务
 * @Date: 2020/7/22 15:34
 * @Version: 1.0
 */
@Controller
@RequestMapping("/superior")
public class SuperiorController {
    @Autowired
    private SuperiorIservice superiorIservice;
    @PostMapping("/listsuperior.do")
    @ResponseBody
  public List<Superior>   listSuperior(HttpServletResponse response) throws IOException {
      return superiorIservice.superiorList();
  }
}
