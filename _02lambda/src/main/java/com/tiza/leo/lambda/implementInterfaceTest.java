package com.tiza.leo.lambda;

/**
 * Author: tz_wl
 * Date: 2020/8/16 17:19
 * Content:
 */
public class implementInterfaceTest {

    public interface A{
        default void show(){
            System.out.println("A...");
        }
        static  void staticMethod(){
            System.out.println("static method ");
        }
    }

    public interface B{
        default void show(){
            System.out.println("B...");
        }
    }

    public static class C implements A,B {

        @Override
        public void show() {
            A.super.show();
        }
    }
}






