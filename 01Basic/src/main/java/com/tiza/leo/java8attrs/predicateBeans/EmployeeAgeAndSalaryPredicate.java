package com.tiza.leo.java8attrs.predicateBeans;

import com.tiza.leo.java8attrs.beans.Employee;

/**
 * Author: tz_wl
 * Date: 2020/8/16 15:23
 * Content:
 */
public class EmployeeAgeAndSalaryPredicate implements EmployeePredicate {
    @Override
    public boolean test888(Employee employee) {
        return employee.getAge()>30 && employee.getSalary()>10000;
    }
}
