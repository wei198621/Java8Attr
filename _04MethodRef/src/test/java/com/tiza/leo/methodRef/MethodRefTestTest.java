package com.tiza.leo.methodRef;

import com.tiza.leo.methodRef.Beans.MethodReferenceBean;
import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.Assert.*;

/**
 * Author: tz_wl
 * Date: 2020/8/16 18:30
 * Content:
 */
public class MethodRefTestTest {


    //4.1 构造器引用
    @Test
    public void test20() {
        // 普通写法
        Supplier<MethodReferenceBean> referenceBeanSupplier = () -> new MethodReferenceBean();
        // 构造器引用，要注意没有()和->了
        Supplier<MethodReferenceBean> methodReferenceBeanSupplier = MethodReferenceBean::new;
    }


    @Test
    public void test21() {
        // 普通写法
        Function<String, MethodReferenceBean> referenceBeanFunction = x -> new MethodReferenceBean(x);
        // 构造器引用
        Function<String, MethodReferenceBean> referenceBeanFunction1 = MethodReferenceBean::new;
        MethodReferenceBean apply = referenceBeanFunction1.apply("constructor ...");
    }


    //4.2 静态方法引用
    @Test
    public void test22() {
        // 普通写法
        BiConsumer<String, String> consumer = (x, y) -> MethodReferenceBean.print(x, y);
        // 静态方法引用写法
        BiConsumer<String, String> consumer1 = MethodReferenceBean::print;
        consumer1.accept("hello", "world");
    }


    //4.3 实例方法引用
    @Test
    public void test23() {
        // 实例化
        MethodReferenceBean methodReferenceBean = new MethodReferenceBean();
        // 普通写法
        Consumer<String> consumer = x -> methodReferenceBean.print(x);
        // 方法引用
        Consumer<String> consumer1 = methodReferenceBean::print;
        consumer.accept("hello world!");
    }



}