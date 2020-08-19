package com.tiza.leo.defaultAndStatic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Author: tz_wl
 * Date: 2020/8/16 18:08
 * Content:
 */
public class FunctionTestTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void test08() {

       /*
        Consumer;           void accept(T var1);
        Predicate;          boolean test(T var1);
        Function<T, R>  ;   R apply(T var1);
        */

        Function<Integer, Long> integerToLongFunction = i -> i.longValue();
        Long apply = integerToLongFunction.apply(10);
        System.out.println("apply = " + apply);
    }

    @Test
    public void test09() {
        Function<Integer, Integer> function1 = i -> i * 2;
        Function<Integer, Integer> function2 = function1.compose(x -> x - 1);
        Integer apply = function2.apply(10); // 结果为18  = (10 - 1) * 2
        System.out.println("apply = " + apply);
    }


    @Test
    public void test10() {
        Function<Integer, Integer> function1 = i -> i * 2;
        Function<Integer, Integer> function2 = function1.andThen(x -> x - 1);
        Integer result = function2.apply(10); // 结果为19   =  10 * 2 - 1
        System.out.println("result = " + result);
    }

    @Test
    public void test11() {
        // 创建一个Function，接收和返回值都是Integer
        Function<Integer, Integer> identity = Function.identity();
        Integer apply = identity.apply(10); // 接收10，将返回10
        System.out.println("apply = " + apply);
    }



}