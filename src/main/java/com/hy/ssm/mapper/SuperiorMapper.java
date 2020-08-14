package com.hy.ssm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.ssm.pojo.Superior;
import com.hy.ssm.pojo.SuperiorExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


public interface SuperiorMapper extends BaseMapper<Superior> {
    List<Superior> supselect(String sup);

}