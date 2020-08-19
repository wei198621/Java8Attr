package com.tiza.leo.defaultAndStatic;

import com.tiza.leo.defaultAndStatic.beans.Employee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Author: tz_wl
 * Date: 2020/8/16 17:34
 * Content:
 */
public class PreidcateTestTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test01(){
        Predicate<Employee> employeePredicate=employee -> employee.getAge()>30;
        Employee emp = new Employee(1L, "zhangsan", 31, 10000.0);
        boolean test = employeePredicate.test(emp);
        System.out.println("test = " + test);
    }

    @Test
    public void test02(){
        Predicate<Employee> empPredicate1=employee -> employee.getAge()>30;
        Predicate<Employee> empPredicateAnd =empPredicate1.and(employee -> employee.getSalary()>10000);

        Employee emp = new Employee(1L, "zhangsan", 31, 10000.0);
        boolean test = empPredicateAnd.test(emp);
        System.out.println("test = " + test);
    }

    @Test
    public void test03() {
        // 接收Lambda表达式
        Predicate<Employee> empPredicate = employee -> employee.getAge() > 31;
        // negate取反
        Employee emp = new Employee(1L, "张三", 30, 10000.0);
        boolean test1 = empPredicate.test(emp);
        boolean test2 = empPredicate.negate().test(emp);
        System.out.println(test1);
        System.out.println(test2);
        Assert.assertTrue(test1);
    }


    @Test
    public void test04() {
        // 接收Lambda表达式
        Predicate<Employee> employeePredicate = employee -> employee.getAge() > 30;
        Predicate<Employee> employeePredicate1 = employee -> employee.getSalary() == 10000;
        Predicate<Employee> predicate = employeePredicate.or(employeePredicate1);
        Assert.assertTrue(predicate.test(new Employee(1L, "张三", 30, 10000.0)));
    }

    @Test
    public void test05() {
        // 接收Lambda表达式
        Employee employee = new Employee(1L, "张三", 30, 10000.0);
        Employee employee2 = new Employee(1L, "张三22", 30, 10000.0);
        // isEqual接收一个对象，该对象是一个被比较的目标对象
        Predicate<Employee> predicate = Predicate.isEqual(employee);
        // test接收一个对象，该对象是要比较的对象，与目标对象比较
        boolean test = predicate.test(employee);
        System.out.println("test = " + test);
        boolean test2 = predicate.test(employee2);
        System.out.println("test = " + test2);
        Assert.assertTrue(test);
    }





}