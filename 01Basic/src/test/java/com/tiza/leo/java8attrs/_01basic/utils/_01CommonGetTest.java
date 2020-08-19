package com.tiza.leo.java8attrs._01basic.utils;

import com.tiza.leo.java8attrs.beans.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: tz_wl
 * Date: 2020/8/16 15:11
 * Content:
 */
public class _01CommonGetTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
    *@Description: 从上面的数据中找出年龄大于30的员工
    *@Param:
    *@return:
    *@date: 2020/8/16
    */
    @Test
    public void getEmployeeAge30() {
        List<Employee> employees = DataUtils.getEmployees();
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee.getAge()>30){
                result.add(employee);
            }
        }
        System.out.println("==========从上面的数据中找出年龄大于30的员工  原始方式=============");
        System.out.println(result);
    }

    /**
    *@Description: 找出年龄大于30且工资大于10000的员工
    *@Param: 
    *@return: 
    *@date: 2020/8/16
    */
    @Test
    public void getEmployeeAge30_Salary1000() {
        List<Employee> employees = DataUtils.getEmployees();
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee.getAge()>30 & employee.getSalary()>10000){
                result.add(employee);
            }
        }
        System.out.println("==========找出年龄大于30且工资大于10000的员工 原始方式 =============");
        System.out.println(result);
    }
}