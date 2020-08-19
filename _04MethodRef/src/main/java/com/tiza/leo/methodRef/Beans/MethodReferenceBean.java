package com.tiza.leo.methodRef.Beans;

/**
 * Author: tz_wl
 * Date: 2020/8/16 18:31
 * Content:
 */
public class MethodReferenceBean {
    private String flag;

    // 无参构造器
    public MethodReferenceBean() {
    }

    // 有参构造器
    public MethodReferenceBean(String flag) {
        this.flag = flag;
    }

    // 实例方法
    public void print(String word) {
        System.out.println(word);
    }

    // 静态方法
    public static void print(String s1, String s2) {
        System.out.println("【" + s1 + "】" + s2);
    }
}
