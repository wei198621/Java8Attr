package com.tiza.leo.java8attrs.predicateBeans;

import com.tiza.leo.java8attrs.beans.Employee;

/**
 * Author: tz_wl
 * Date: 2020/8/16 15:21
 * Content:
 * 该接口只有一个抽象方法（并没有@FunctionalInterface注解），它是一个函数式接口，所以最后才能使用Lambda表达式来改进代码。
 */
public interface EmployeePredicate {
    boolean test888(Employee employee);
}
