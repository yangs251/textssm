package com.hy.ssm.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("employee")
public class Employee {
    @TableId("eid")
    private Integer eid;

    private String ename;

    private String esex;

    private Integer eage;

    private String eidentity;

    private String eidentityy;

    private String sid;

    private String did;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex == null ? null : esex.trim();
    }

    public Integer getEage() {
        return eage;
    }

    public void setEage(Integer eage) {
        this.eage = eage;
    }

    public String getEidentity() {
        return eidentity;
    }

    public void setEidentity(String eidentity) {
        this.eidentity = eidentity == null ? null : eidentity.trim();
    }

    public String getEidentityy() {
        return eidentityy;
    }

    public void setEidentityy(String eidentityy) {
        this.eidentityy = eidentityy == null ? null : eidentityy.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

}