package com.mft.annotation;

public class Enhancements {
    public static void main(String[] args) {
        Box<String> box = new  @NonEmpty @ReadOnly Box<>(10 ,"container");


        box.new @ReadOnly NestedBox(11, "cylinder");
    }
}
