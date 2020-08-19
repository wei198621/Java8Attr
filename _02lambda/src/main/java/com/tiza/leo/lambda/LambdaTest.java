package com.tiza.leo.lambda;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Author: tz_wl
 * Date: 2020/8/16 16:33
 * Content:
 */
public class LambdaTest {
    public static void main(String[] args) {

        Comparator<Integer> comparator=(Integer a, Integer b)->{
            return a-b;
        };
        int compare = comparator.compare(2, 3);
        System.out.println("====compare result is :"+ compare);


        Comparator<Integer> comparator2 = (a, b) -> {
            return a - b;
        };
        int compare2 = comparator2.compare(3, 0);
        System.out.println("======comparator2 is :"+ compare2);


        Predicate<Integer> predicate = a->{
            return a>3;
        };
        Predicate<Integer> predicate2= predicate.or(a->{ return a< 18;});
        boolean test = predicate2.test(22);
        System.out.println("predicate a>3 a<18  " + test);
        System.out.println("predicate a>3 a<18  " + test);

        Runnable r=()->{
            System.out.println("lambda exp");
        };
        r.run();

        Runnable r2=()-> System.out.println(" r2 is running ");
        r2.run();

        Predicate<Integer> predicate3=a->a>3;
        boolean test3 = predicate3.test(3);
        System.out.println("a>3 = " + test3);


         String msg="外部引用变量1";
        Runnable r4=()->{
           // msg="sss";  //不可以有上面的操作 所以在Lambda中有引用到外部变量，该外部变量是不允许被改变的
            System.out.println(" ===="+ msg);
        };
        r4.run();


       /* Predicate<Integer> ;  boolean
        Consumer<Integer>;   void
        Function<Integer,String>;   R
        Supplier<Integer>;   T*/





    }




}
