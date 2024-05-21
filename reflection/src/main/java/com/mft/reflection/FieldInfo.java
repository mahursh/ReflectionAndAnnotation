package com.mft.reflection;

import java.lang.reflect.Field;

public class FieldInfo {
    public static void main(String[] args) throws Exception {
        Entity entity = new Entity(10 ,"test");
        Class<? extends Entity> cls = entity.getClass();

        //only shows public fields
        Field[] fields = cls.getFields();
        for (Field field:fields) {
            System.out.println(field.getName());
        }

        //shows every field in a class rather it is public or private
        Field[] declaredFields =cls.getDeclaredFields();
        for (Field field: declaredFields) {
            System.out.println(field.getName());
        }

        //non-declared : all the public elements in that class and in its super class
        //declared     : all the elements present in that class

//-----------------------------------------------------------------------------

        //changing a public field value at runtime
        Field field = cls.getField("type");
        field.set(entity,"rollNo");

        System.out.println(entity.getType());


        //changing a private field value at runtime
        Field field2 = cls.getDeclaredField("val");
        //to have access to private field setter
        field2.setAccessible(true);
        field2.set(entity,19);

        System.out.println(entity.getType() +" "+entity.getVal());

    }
}
