package com.hy.ssm.bo;

import com.hy.ssm.pojo.Department;
import com.hy.ssm.pojo.Employee;

import java.util.Map;

/**
 * @ProjectName: spring_mybatis
 * @Package: com.hy.ssm.bo
 * @ClassName: EmpDepSup
 * @Author: Xiaobai
 * @Description: 查询所有值
 * @Date: 2020/7/28 9:51
 * @Version: 1.0
 */
public class EmpDepSup {
    private Employee employee;
    private Department department;
    private Map<String,String> superior;

    public EmpDepSup(Employee employee, Department department, Map<String, String> superior) {
        this.employee = employee;
        this.department = department;
        this.superior = superior;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Map<String, String> getSuperior() {
        return superior;
    }

    public void setSuperior(Map<String, String> superior) {
        this.superior = superior;
    }


    @Override
    public String toString() {
        return "EmpDepSup{" +
                "employee=" + employee +
                ", department=" + department +
                ", superior=" + superior +
                '}';
    }
}
