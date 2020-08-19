package com.tiza.leo.java8attrs._04Lambda;

import com.tiza.leo.java8attrs.QueryEmpEntity;
import com.tiza.leo.java8attrs._01basic.utils.DataUtils;
import com.tiza.leo.java8attrs.beans.Employee;

import java.util.List;

/**
 * Author: tz_wl
 * Date: 2020/8/16 15:55
 * Content:
 */
public class LambdaTest {
    public List<Employee>  empAge30(){
        List<Employee> emps = DataUtils.getEmployees();
        QueryEmpEntity queryEmpEntity = new QueryEmpEntity();
        List<Employee> employees = queryEmpEntity.queryEmployees(emps, emp -> emp.getAge() > 30);
        return employees;
    }


    public List<Employee>  empAge30Salary10000(){
        List<Employee> emps = DataUtils.getEmployees();
        QueryEmpEntity queryEmpEntity = new QueryEmpEntity();
        List<Employee> employees = queryEmpEntity.queryEmployees(emps, emp -> emp.getAge() > 30 && emp.getSalary()>10000);
        return employees;
    }





}
