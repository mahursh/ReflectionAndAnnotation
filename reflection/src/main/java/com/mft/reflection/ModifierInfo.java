package com.mft.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ModifierInfo {
    public static void main(String[] args) throws Exception{
        Entity entity = new Entity(10,"s");



        Class<? extends  Entity> cls = entity.getClass();
        int modifiersInt = cls.getModifiers();
        System.out.println(Modifier.toString(modifiersInt));



//        int i = modifiersInt & Modifier.PUBLIC;
//        System.out.println(i);

        //Second way
       boolean isPublicClass = Modifier.isPublic(modifiersInt);
       System.out.println(isPublicClass);


//--------------------------------------------------------------------------------------------------------------


       Method method = cls.getMethod("getVal" );
       int methodModifiers = method.getModifiers();
        System.out.println(Modifier.toString(methodModifiers));

//       int j = methodModifiers & Modifier.PRIVATE;
//       System.out.println(j);


        //Second way
        boolean isPub = Modifier.isPublic(methodModifiers);
        System.out.println(isPub);


    }
}
