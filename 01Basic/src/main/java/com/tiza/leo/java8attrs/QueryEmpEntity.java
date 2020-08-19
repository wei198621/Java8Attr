package com.tiza.leo.java8attrs;

import com.tiza.leo.java8attrs.beans.Employee;
import com.tiza.leo.java8attrs.predicateBeans.EmployeePredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: tz_wl
 * Date: 2020/8/16 15:30
 * Content:
 */
public class QueryEmpEntity {
    public List<Employee> queryEmployees(List<Employee> emps, EmployeePredicate empPredicate){
        List<Employee> result = new ArrayList<>();
        for (Employee emp : emps) {
            if(empPredicate.test888(emp)){
                result.add(emp);
            }
        }
        return result;
    }
}
