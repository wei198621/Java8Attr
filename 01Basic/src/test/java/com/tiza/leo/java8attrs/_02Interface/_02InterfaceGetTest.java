package com.tiza.leo.java8attrs._02Interface;

import com.tiza.leo.java8attrs._01basic.utils.DataUtils;
import com.tiza.leo.java8attrs.beans.Employee;
import com.tiza.leo.java8attrs.QueryEmpEntity;
import com.tiza.leo.java8attrs.predicateBeans.EmployeeAgeAndSalaryPredicate;
import com.tiza.leo.java8attrs.predicateBeans.EmployeeAgePredicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Author: tz_wl
 * Date: 2020/8/16 15:11
 * Content:
 */
public class _02InterfaceGetTest {

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
        QueryEmpEntity queryEmpEntity = new QueryEmpEntity();
        List<Employee> result = queryEmpEntity.queryEmployees(employees,new EmployeeAgePredicate());
        System.out.println("==========从上面的数据中找出年龄大于30的员工  interface 方式 =============");
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
        QueryEmpEntity queryEmpEntity = new QueryEmpEntity();
        List<Employee> result = queryEmpEntity.queryEmployees(employees,new EmployeeAgeAndSalaryPredicate());
        System.out.println("==========找出年龄大于30且工资大于10000的员工    interface 方式 =============");
        System.out.println(result);
    }
}