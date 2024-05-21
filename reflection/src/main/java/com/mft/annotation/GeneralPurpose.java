package com.mft.annotation;

import java.lang.annotation.Documented;
import java.util.ArrayList;

//@SuppressWarnings("all")
public class GeneralPurpose extends Parent {
    @Override
    public void m1(){
        System.out.println("m1 child implementation");
    }

    public static void main(String[] args) {

//        @SuppressWarnings("unused")
        int a = 10;

//        @SuppressWarnings("all")
        @SuppressWarnings({"rawtypes" , "unused"})

        ArrayList arrayList= new ArrayList<>();

        GeneralPurpose generalPurpose = new GeneralPurpose();
        generalPurpose.m2(a);


        //implementing the functional interface method
        MyFunctionalInterface imp = () -> System.out.println("Method Invoked");
        imp.method();






    }

}
