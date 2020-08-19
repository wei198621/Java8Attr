package com.tiza.leo.defaultAndStatic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * Author: tz_wl
 * Date: 2020/8/16 18:16
 * Content:
 */
public class ComparatorTestTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void test12() {
        Comparator<Integer> integerComparator = (x, y) -> x - y;
        int compare = integerComparator.compare(2, 3); // -1
        System.out.println("compare = " + compare);
    }

    @Test
    public void test13() {
        Comparator<Integer> integerComparator = (x, y) -> x - y;
        Comparator<Integer> reversed = integerComparator.reversed();
        int compare = reversed.compare(2, 3);  // 1
        System.out.println("compare = " + compare);
    }

    @Test
    public void test14() {
        Comparator<Integer> integerComparator = (x, y) -> x - y;
        Comparator<Integer> comparator = integerComparator.thenComparing((x, y) -> x + 4 - y);
        // 2和2相比 相等 ，所以再次比较 比较的规则是 x + 4 - y
        int compare = comparator.compare(2, 2);
        System.out.println("compare = " + compare);
    }

    @Test
    public void test15() {
        Comparator<Integer> reverseOrder = Comparator.reverseOrder();
        int compare = reverseOrder.compare(1, 2);
        System.out.println(compare);
    }

    @Test
    public void test16() {
        //Comparator<Character> comparator = Comparator.naturalOrder();
        Comparator<Character> comparator = Comparator.reverseOrder();
        int compare = comparator.compare('s', 'a');
        System.out.println(compare);
    }

    @Test
    public void test17() {
        /**
         * null值小于任何非null值，
         * 如果nullsFirst的参数不为null时，如果比较的值都不为null，就使用传入的Comparator来比较
         * 如果nullsFirst的参数为null时，如果比较的值都不为null，则认为两个值是相等的
         */
        // 参数为null的情况
        Comparator<Integer> nullsFirst = Comparator.nullsFirst(null);
        int compare = nullsFirst.compare(1, 2); // 相等 为0
        compare = nullsFirst.compare(null, 2); // null 小于 2， 为-1
        compare = nullsFirst.compare(3, null); // 3 大于 null， 为1
        // 参数不为null的情况
        Comparator<Integer> nullsFirstNotNull = Comparator.nullsFirst((x, y) -> x * 2 - y);
        compare = nullsFirstNotNull.compare(6, 10); // 6 * 2 大于 10， 为2
        compare = nullsFirstNotNull.compare(null, 6); // null 小于 6， 为-1
        compare = nullsFirstNotNull.compare(6, null); // 6 大于 null， 为1
    }

    @Test
    public void test18() {
        /**
         * null值大于任何非null值，
         * 如果nullsFirst的参数不为null时，如果比较的值都不为null，就使用传入的Comparator来比较
         * 如果nullsFirst的参数为null时，如果比较的值都不为null，则认为两个值是相等的
         */
        // 参数为null的情况
        Comparator<Integer> nullsFirst = Comparator.nullsLast(null);
        int compare = nullsFirst.compare(1, 2); // 相等 为0
        compare = nullsFirst.compare(null, 2); // null 大于 2， 为1
        compare = nullsFirst.compare(3, null); // 3 小于 null， 为-1
        // 参数不为null的情况
        Comparator<Integer> nullsFirstNotNull = Comparator.nullsLast((x, y) -> x * 2 - y);
        compare = nullsFirstNotNull.compare(6, 10); // 6 * 2 大于 10， 为2
        compare = nullsFirstNotNull.compare(null, 6); // null 大于 6， 为 1
        compare = nullsFirstNotNull.compare(6, null); // 6 小于 null， 为 -1
    }

    @Test
    public void test19() {
        Comparator<Integer> comparator = Comparator.comparing(x -> {
            if (x > 0) {
                x -= 2;
            } else {
                x /= 2;
            }
            return x;
        });
        int compare = comparator.compare(1, 0);
        System.out.println("compare = " + compare);
    }






}