package com.tiza.leo.defaultAndStatic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Author: tz_wl
 * Date: 2020/8/16 17:50
 * Content:
 */
public class ConsumerTestTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void test06() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("hello world !");
    }

    @Test
    public void test07() {

        Consumer<String> consumer = x -> System.out.println(x + "^_^");
        Consumer<String> andThen = consumer.andThen(x -> System.out.println(x.toUpperCase()));
        andThen.accept("hello world!");
    }
// 所以打印结果会是：
/**
 *	hello world!^_^
 * HELLO WORLD!
 **/


}