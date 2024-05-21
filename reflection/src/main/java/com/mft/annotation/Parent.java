package com.mft.annotation;

public class Parent {

//    @Deprecated(since = "2")
    public void m1(){
        System.out.println("m1 parent implementation");
    }
    public void m2(int a){
        System.out.println("m2 parent implementation - a is :" + a);
    }
}
