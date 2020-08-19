package com.tiza.leo.java8attrs._04Lambda;

import com.tiza.leo.java8attrs.beans.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Author: tz_wl
 * Date: 2020/8/16 16:08
 * Content:
 */
public class LambdaTestTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void empAge30() {
        LambdaTest lambdaTest = new LambdaTest();
        List<Employee> employees = lambdaTest.empAge30();
        System.out.println("=============年龄大于30    lambda方式 ============");
        System.out.println("employees = " + employees);
    }

    /**
    *@Description: 年龄大于30  工资大于10000
    *@Param:
    *@return:
    *@date: 2020/8/16
    */
    @Test
    public void empAge30Salary10000() {
        LambdaTest lambdaTest = new LambdaTest();
        List<Employee> employees = lambdaTest.empAge30Salary10000();
        System.out.println("=============年龄大于30  工资大于10000  lambda方式 ============");
        System.out.println("employees = " + employees);
    }


}