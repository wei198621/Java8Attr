package com.tiza.leo.java8attrs._03Anonymous;

import com.tiza.leo.java8attrs.beans.Employee;
import com.tiza.leo.java8attrs._01basic.utils.DataUtils;
import com.tiza.leo.java8attrs.QueryEmpEntity;
import com.tiza.leo.java8attrs.predicateBeans.EmployeePredicate;

import java.util.List;

/**
 * Author: tz_wl
 * Date: 2020/8/16 15:41
 * Content:
 */
public class AnonymousClassTest {

    /**
    *@Description:  年龄大于30  
    *@Param: 
    *@return: 
    *@date: 2020/8/16
    */
    public List<Employee> empAge30(){
        List<Employee> emps = DataUtils.getEmployees();
        QueryEmpEntity queryEmpEntity = new QueryEmpEntity();
        List<Employee> empList = queryEmpEntity.queryEmployees(emps, new EmployeePredicate() {
            @Override
            public boolean test888(Employee employee) {
                return employee.getAge() > 30;
            }
        });
        return empList;
    }

    /**
    *@Description: 工资大于10000  年龄大于 30  
    *@Param: 
    *@return: 
    *@date: 2020/8/16
    */
    public List<Employee> empAge30Salary10000(){
        List<Employee> emps = DataUtils.getEmployees();
        QueryEmpEntity queryEmpEntity = new QueryEmpEntity();
        List<Employee> employees = queryEmpEntity.queryEmployees(emps, new EmployeePredicate() {
            @Override
            public boolean test888(Employee employee) {
                return employee.getAge() > 30 && employee.getSalary() > 10000;
            }
        });
        return employees;
    }


}
