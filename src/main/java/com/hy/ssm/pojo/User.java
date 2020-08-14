package com.hy.ssm.pojo;


import java.io.Serializable;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.pojo
 * @ClassName: user
 * @Author: Xiaobai
 * @Description:
 * @Date: 2020/8/4 11:39
 * @Version: 1.0
 */
public class User implements Serializable {
    private  int id;
    private  String uname;
    private  String passwrod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }
}
