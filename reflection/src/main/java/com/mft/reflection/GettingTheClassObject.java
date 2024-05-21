package com.mft.reflection;

import java.util.Arrays;

public class GettingTheClassObject {
    public static void main(String[] args) throws Exception{
        //forName()
        Class<?> cls1 = Class.forName("java.lang.String");
        Class<?> cls2 = Class.forName("java.lang.String");

//        System.out.println(cls1 == cls2);



        //className.class

        Class<?> cls3 = int.class;
        Class<?> cls4 = String.class;

        //obj.getClass()
        MyClass myClass = new MyClass();
        Class<? extends MyClass> myClassClass= myClass.getClass();

        //super class
        Class<?> superClass = myClassClass.getSuperclass();

        //interfaces
        Class<?>[] interfaces = myClassClass.getInterfaces();

        //getName()
        System.out.println(myClassClass.getName());
        System.out.println(Arrays.toString(interfaces));
        System.out.println(superClass);



    }
}
