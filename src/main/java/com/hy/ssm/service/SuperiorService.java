package com.hy.ssm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ssm.mapper.SuperiorMapper;
import com.hy.ssm.pojo.Superior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.service
 * @ClassName: SuperiorService
 * @Author: Xiaobai
 * @Description: 职位service
 * @Date: 2020/7/22 15:38
 * @Version: 1.0
 */
@Service
@Transactional
public class SuperiorService extends ServiceImpl<SuperiorMapper, Superior> implements SuperiorIservice {
    @Autowired
    private SuperiorMapper superiorMapper;
    @Override
    public List<Superior> superiorList(){
        return superiorMapper.selectList(null);
    }
}
