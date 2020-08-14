package com.hy.ssm.bo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.bo
 * @ClassName: layuiemp
 * @Author: Xiaobai
 * @Description:
 * @Date: 2020/7/29 11:38
 * @Version: 1.0
 */
public class layuiemp implements Serializable {
    private Integer code;
    private String msg;
    private Integer count;
    private List   data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

}
