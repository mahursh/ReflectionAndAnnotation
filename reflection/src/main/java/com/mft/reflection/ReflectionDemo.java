package com.mft.reflection;

import java.lang.reflect.Constructor;


class MyClass {
//    private MyClass() {
     MyClass() {
        System.out.println("MyClass Object Created !");
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
//        MyClass myClass = new MyClass();

        Class<?> cls = Class.forName("com.mft.reflection.MyClass");
        Constructor<?> cons = cls.getDeclaredConstructor();
        cons.setAccessible(true);
//        Object object = cons.newInstance();
        MyClass object = (MyClass)cons.newInstance();


    }
}
