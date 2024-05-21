package com.mft.annotation;

public class Utility {
    @MostUsed
    void doStuff(){
        System.out.println("doing some stuff");
    }

    @MostUsed("Python")
    void doStuff(String arg){
        System.out.println("operating on :"+ arg);
    }

    void doStuff(int i){
        System.out.println("operating on :"+ i);
    }
}


class SubUtility extends Utility{

    //because of the @Inherited annotation , @MostUser annotation is by default inherited in SubUtility Class

}