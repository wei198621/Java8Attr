package com.tiza.leo.Optional;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Author: tz_wl
 * Date: 2020/8/17 22:52
 * Content:
 */
public class TestOptionalTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1() {
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
    }

    @Test
    public void test2() {
        Optional<String> opt = Optional.of("optional not null");
        System.out.println(opt);
    }

    @Test
    public void test3() {
        Optional<String> beNull = Optional.ofNullable("null");
        System.out.println("beNull = " + beNull);
        Optional<String> beNull2 = Optional.ofNullable(null);
        System.out.println("beNull2 = " + beNull2);
      /*  beNull = Optional[null]
        beNull2 = Optional.empty
        */
    }

    @Test
    public void test4() {
        Optional<Integer> optVal = Optional.of(100);
        Integer integer = optVal.get();
        System.out.println("integer = " + integer);

    }

    @Test
    public void test5() {
        Optional<Integer> integer = Optional.of(100);
        boolean present = integer.isPresent();
        System.out.println("present = " + present);
    }

    @Test
    public void test6() {
        Optional<Integer> integer = Optional.of(100);
        integer.ifPresent(System.out::println);


    }

    @Test
    public void test7() {
        Optional<Integer> integer = Optional.of(100);
        Optional<Integer> integer1 = integer.filter(x -> x > 30);
        System.out.println("integer1 = " + integer1);

    }


    @Test
    public void test08() {
        Optional<Integer> integer = Optional.ofNullable(100);
        // 将`Optional`中的值 100 + 20 返回 生成新的`Optional`返回
        Optional<Integer> integer1 = integer.map(x -> x + 20);
        System.out.println("integer1 = " + integer1);
        //integer1 = Optional[120]
    }

    @Test
    public void teset09() {
        Optional<Integer> integer = Optional.of(100);
        Function<Integer, Optional<Object>> integerOptionalFunction = x -> Optional.ofNullable(x.longValue());
        Optional<Object> o = integer.flatMap(integerOptionalFunction);

        System.out.println("o = " + o);
    }


    @Test
    public void test10() {
        Optional<Integer> integer = Optional.ofNullable(null);
        // 因为 Optional 中的值为 null ，所以会生成一个值为20的新的
        Integer integer1 = integer.orElse(22);
        System.out.println("integer1 = " + integer1);
    }


    @Test
    public void test11() {
        Optional<Integer> integer = Optional.ofNullable(null);
        // 因为 Optional 中的值为 null ，所以会生成一个值为20的新的
        Integer integer1 = integer.orElseGet(() -> 22);
        System.out.println("integer1 = " + integer1);
    }


    @Test
    public void test12() {
        Optional<Integer> integer = Optional.ofNullable(null);
        // 因为 Optional 中的值为 null ，所以会生成一个值为20的新的
        integer.orElseThrow(RuntimeException::new);
    }
}



