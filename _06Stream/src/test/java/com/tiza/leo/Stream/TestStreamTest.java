package com.tiza.leo.Stream;

import com.sun.xml.internal.fastinfoset.util.ValueArray;
import com.tiza.leo.Stream.beans.Employee;
import com.tiza.leo.Stream.beans.EmployeeExt;
import com.tiza.leo.Stream.utils.DataUtils;
import com.tiza.leo.Stream.utils.DataUtilsExt;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Author: tz_wl
 * Date: 2020/8/18 22:16
 * Content:
 */
public class TestStreamTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void Test(){
        List<Employee> employees = DataUtils.getEmployees();
        List<Employee> collect = employees.stream().filter(x -> x.getAge() > 30).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }
    @Test
    public void Test2(){
        List<Employee> employeeList = DataUtils.getEmployees();
        Stream<Employee> employeeStream = employeeList.stream();
       /* Set<Employee> collect = employeeStream.collect(Collectors.toSet());
        System.out.println("collect = " + collect);*/
        TreeSet<Employee> collect1 = employeeStream
                .filter(x -> x.getAge() > 23)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("collect1 = " + collect1);
    }

    /**
    *@Description: 惰性求值
    *@Param: 
    *@return: 
    *@date: 2020/8/18
    */
    @Test
    public void Test3(){
        List<Employee> employeeList = DataUtils.getEmployees();
        Stream<Employee> employeeStream = employeeList.stream().filter(x -> {
            System.out.println(x.getAge());   //不会打印这个值的
            return x.getAge() > 30;
        });
        System.out.println("employeeStream = " + employeeStream);
        System.out.println("ssss");
    }

    /**
    *@Description: 及早求值
    *@Param: 
    *@return: 
    *@date: 2020/8/18
    */
    @Test
    public void Test4(){
        List<Employee> employeeList = DataUtils.getEmployees();
        long count = employeeList.stream().filter(x -> {
            System.out.println(x.getAge());   //会打印这个值的
            return x.getAge() > 30;
        }).count();
        System.out.println("count = " + count);
        System.out.println("ssss");
    }

    /**
    *@Description: 获取流的方式
    *@Param:
    *@return:
    *@date: 2020/8/18
    */
    @Test
    public void Test5(){
        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9);
        System.out.println("intList = " + intList);
        Stream<Integer> intStream = intList.stream();
        System.out.println("intStream = " + intStream.collect(Collectors.toList()));
        Stream<List<Integer>> intList1 = Stream.of(intList);
        System.out.println("intList1 = " + intList1.collect(Collectors.toList()));


        Stream<? extends Serializable> a = Stream.of(1, 3, 5, 7, 9, "a");
        System.out.println("a.collect(Collectors.toList()) = " + a.collect(Collectors.toList()));

        System.out.println("=======================================================");
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2).limit(8);
        System.out.println("iterate = " + iterate.collect(Collectors.toList()));

       int[] ints= {1,3,5,7,99};
        IntStream stream = Arrays.stream(ints);
        System.out.println("stream = " + stream.count());


        Stream<Double> generate = Stream.generate(Math::random).limit(3);
        System.out.println("generate = " + generate.collect(Collectors.toList()));
    }

    @Test
    public void Test6(){
        List<Employee> employeeList = DataUtils.getEmployees();
        Stream<Employee> employeeStream = employeeList.stream().filter(x -> x.getAge() > 50).distinct();
        System.out.println("employeeStream = " + employeeStream.count());
        Stream<Employee> distinct = employeeList.stream().distinct();
        System.out.println("distinct = " + distinct.count());

        List<Employee> collect = employeeList.stream().limit(3).collect(Collectors.toList());
        System.out.println("collect = " + collect);
        List<Employee> collect1 = employeeList.stream().skip(3).collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);

        System.out.println("===================");
        Stream<String> stringStream = employeeList.stream().map(Employee::getName);
        System.out.println("stringStream = " + stringStream.collect(Collectors.toList()));

    }

    @Test
    public void Test7(){

        List<Employee> employees = DataUtils.getEmployees();
        // 准备数据
        List<List<Employee>> emp = new ArrayList<>();
        emp.add(employees.subList(1, 3));
        emp.add(employees.subList(3, 6));
        emp.add(employees.subList(6, 9));
        emp.add(employees.subList(9, 12));

        List<Employee> collect = emp.stream().flatMap(x -> x.stream().limit(1)).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    @Test
    public void Test8(){
        List<EmployeeExt> empList = DataUtilsExt.getEmployees();
        List<EmployeeExt> collect = empList.stream().sorted().collect(Collectors.toList());
        System.out.println("collect = " + collect);

        System.out.println("================================================");
        List<Employee> empList2 = DataUtils.getEmployees();
        List<Employee> collect2 = empList2
                .stream()
                .sorted((x, y) -> x.getAge() - y.getAge()
        ).collect(Collectors.toList());
        System.out.println("collect2 = " + collect2);

        System.out.println("================================================");
        List<Employee> collect1 = empList2
                .stream()
                .sorted(Comparator.comparing(employee -> employee.getAge()))
                .collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);

        System.out.println("================================================");
        List<Employee> collect3 = empList2
                .stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());
        System.out.println("collect3 = " + collect3);

    }

    @Test
    public void Test9(){
        List<Employee> employees = DataUtils.getEmployees();
        boolean b = employees.stream().anyMatch(x -> x.getAge() > 30);
        boolean b1 = employees.stream().allMatch(x -> x.getAge() > 30);
        boolean b2 = employees.stream().noneMatch(x -> x.getAge() > 30);
        System.out.println("b = " + b);
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);

        System.out.println("===================================================");
        Optional<Employee> first = employees.stream().findFirst();
        Optional<Employee> any = employees.stream().findAny();
        System.out.println("first = " + first);
        System.out.println("any = " + any);

        System.out.println("===================================================");
        Optional<Integer> reduce = employees.stream().map(Employee::getAge).reduce(Integer::sum);
        Integer reduce1 = employees.stream().map(Employee::getAge).reduce(10, Integer::sum);
        System.out.println("reduce = " + reduce);
        System.out.println("reduce1 = " + reduce1);

        System.out.println("===================================================");

        Optional<Employee> max = employees.stream().max(Comparator.comparingDouble(Employee::getAge));
        Optional<Employee> max1 = employees.stream().limit(10).max(Comparator.comparingDouble(employee -> {
            return employee.getAge();
        }));
        System.out.println("max = " + max);
        System.out.println("max1 = " + max1);

        long count = employees.stream().count();
        System.out.println("count = " + count);
        System.out.println("======================");

        employees.stream().forEach(System.out::println);
        System.out.println("******");
        employees.stream().forEach(x->System.out.println(x));
    }



    //6.8 collect收集
    @Test
    public void Test10() {
        List<Employee> employeeList = DataUtils.getEmployees();
        List<Employee> collect = employeeList.stream().filter(x -> x.getAge() > 40).collect(Collectors.toList());
        System.out.println("collect = " + collect);

        Set<Employee> collect1 = employeeList.stream().filter(x -> x.getAge() > 35).collect(Collectors.toSet());
        System.out.println("collect1 = " + collect1);

        //Map<String, Employee> collect2 = employeeList.stream().filter(x -> x.getAge() > 20 && x.getAge()<50).collect(Collectors.toMap(Employee::getName, x -> x));
        Map<String, Employee> collect2 = employeeList.stream().filter(x -> x.getAge() > 20 && x.getAge()<50).collect(Collectors.toMap(x->x.getName(), x -> x));
        System.out.println("collect2 = " + collect2);

        //ArrayList<Employee> collect3 = employeeList.stream().filter(x -> x.getAge() < 50).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Employee> collect3 = employeeList.stream().filter(x -> x.getAge() < 50).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("collect3 = " + collect3);

        System.out.println("=======================================================================================");

        Long collect4 = employeeList.stream().collect(Collectors.counting());
        System.out.println("collect4 = " + collect4);
        //Double collect5 = employeeList.stream().collect(Collectors.averagingDouble(x->x.getAge())); // Employee::getAge
        Double collect5 = employeeList.stream().collect(Collectors.summingDouble(x->x.getAge())); // Employee::getAge
        System.out.println("collect5 = " + collect5);
        Optional<Employee> collect6 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
        //                                       maxBy (Comparator)  comparingInt(Function)
        System.out.println("collect6 = " + collect6);
        Optional<Employee> collect7 = employeeList.stream().collect(Collectors.minBy(Comparator.comparingLong(x -> x.getAge())));
        System.out.println("collect7 = " + collect7);
        //Optional<Employee> collect8 = employeeList.stream().collect(Collectors.minBy(Comparator.comparingLong(Employee::getAge)));
        //Optional<Employee> collect8 = employeeList.stream().collect(Collectors.minBy((x,y)->x.getAge()-y.getAge()));
        Optional<Employee> collect8 = employeeList.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getAge)));
        Optional<Employee> collect9 = employeeList.stream().collect(Collectors.minBy(Comparator.comparing(x->x.getAge())));
        Optional<Employee> collect10 = employeeList.stream().collect(Collectors.minBy(Comparator.comparingLong(x->x.getAge())));


        System.out.println("collect8 = " + collect8);
        System.out.println("collect9 = " + collect9);
        System.out.println("collect10 = " + collect10);

        Double collect11 = employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("collect11 = " + collect11);
        Double collect12 = employeeList.stream().collect(Collectors.summingDouble(x -> x.getSalary()));
        System.out.println("collect12 = " + collect12);

        Map<Boolean, List<Employee>> collect13 = employeeList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 7000));
        System.out.println("collect13 = " + collect13);

        Map<Integer, List<Employee>> collect14 = employeeList.stream().collect(Collectors.groupingBy(x -> x.getAge()));
        Map<Integer, List<Employee>> collect15 = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println("collect14 = " + collect14);
        System.out.println("collect15 = " + collect15);


        Map<String, Map<String, List<Employee>>> collect16 = employeeList
                .stream()
                .collect(Collectors.groupingBy(e -> e.getAge() > 30L ? "old" : "young", Collectors.groupingBy(e -> e.getSalary() > 1000 ? "high" : "common")));
        System.out.println("collect16 = " + collect16);
        System.out.println("=====================================================");//"、", "【", "】"));
        String collect17 = employeeList.stream().map(x -> x.getName()).collect(Collectors.joining(","));
        String collect18 = employeeList.stream().map(x -> x.getName()).collect(Collectors.joining("、", "【", "】"));
        System.out.println("collect17 = " + collect17);
        System.out.println("collect18 = " + collect18);

        Set<Integer> collect19 = employeeList.stream().collect(Collectors.mapping(Employee::getAge, Collectors.toSet()));
        System.out.println("collect19 = " + collect19);

        System.out.println("=====================================================");
        // 返回工资最多的员工
        Optional<Employee> collect20 = employeeList.stream().collect(Collectors.reducing((e1, e2) -> e1.getSalary() >= e2.getSalary() ? e1 : e2));
        System.out.println("collect20 = " + collect20);
        Employee employee = new Employee(33L, "Tom", 29, 20000.0);
        Employee collect21 = employeeList.stream().collect(Collectors.reducing(employee, (x, y) -> x.getSalary() > y.getSalary() ? x : y));
        System.out.println("collect21 = " + collect21);
        Double collect22 = employeeList.stream().collect(Collectors.reducing(0.0, Employee::getSalary, Double::sum));
        System.out.println("collect22 = " + collect22);



    }


    @Test
    public void Test11(){

        List<Employee> employeeList = DataUtils.getEmployees();

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        System.out.println("integerStream = " + integerStream.collect(Collectors.toList()));

        IntStream intStream = IntStream.of(1, 2, 3, 4);
       // System.out.println("intStream = " + intStream.collect(Collectors.toList()));
        IntStream range = IntStream.range(1, 20);
        System.out.println("range = " + range.toArray());
        IntStream intStream1 = IntStream.rangeClosed(1, 20);
        System.out.println("intStream1 = " + intStream1.toArray());


        List<Integer> integers = Arrays.asList(1, 3, 5, 7, 9);
        OptionalInt min = integers.stream().mapToInt(x -> x).min();
        System.out.println("min = " + min);


    }


    @Test
    public void Test12(){
        List<Employee> employees = DataUtils.getEmployees();
        List<Employee> collect = employees.stream().parallel().filter(x -> x.getAge() > 30).collect(Collectors.toList());
        System.out.println("collect = " + collect);
        List<Employee> collect1 = employees.parallelStream().filter(x -> x.getAge() > 30).collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);

    }













































}