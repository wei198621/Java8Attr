package com.tiza.leo.java8attrs._03Anonymous;

import com.tiza.leo.java8attrs.beans.Employee;
import org.junit.Test;

import java.util.List;

/**
 * Author: tz_wl
 * Date: 2020/8/16 15:42
 * Content:
 */
public class AnonymousClassTestTest {


    @Test
    public void empAge30() {
        AnonymousClassTest anonymousClassTest = new AnonymousClassTest();
        List<Employee> employees = anonymousClassTest.empAge30();
        System.out.println("==================年龄大于30的雇员 anonymous方式 =======================");
        System.out.println("employees = " + employees);
    }


    @Test
    public void empAge30Salary10000() {
        AnonymousClassTest anonymousClassTest = new AnonymousClassTest();
        List<Employee> employees = anonymousClassTest.empAge30Salary10000();
        System.out.println("===============年龄大于30 工资大于 10000 的雇员  anonymous方式 ==========================");
        System.out.println("employees = " + employees);
    }


}