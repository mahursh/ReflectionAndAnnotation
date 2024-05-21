package com.mft.reflection;

import java.lang.reflect.Constructor;

public class ConstructorInfo {
    public static void main(String[] args) throws Exception{


       //only public constructors
        Class<?> cls = Class.forName("com.mft.reflection.Entity");
        Constructor<?>[] constructors = cls.getConstructors();
        for(Constructor<?> constructor: constructors){
            System.out.println(constructor);
        }

        System.out.println("-----------------------------------------");

        //private and public constructors
        Class<?> cls2 = Class.forName("com.mft.reflection.Entity");
        Constructor<?>[] constructors2 = cls.getDeclaredConstructors();
        for(Constructor<?> constructor: constructors2){
            System.out.println(constructor);
        }


        Constructor<?> publicConstructor = cls2.getConstructor(int.class,String.class);
        Entity e = (Entity)publicConstructor.newInstance(10,"sss");
        System.out.println(e.getVal() + " "+e.getType());



        Constructor<?> privateConstructor = cls2.getDeclaredConstructor();
        privateConstructor.setAccessible(true);
        Entity e2 = (Entity)privateConstructor.newInstance();

        System.out.println(e2.getVal() + " "+e2.getType());


    }
}
