package com.mft.reflection;

import javax.naming.Name;
import java.lang.reflect.Method;

public class MethodInfo {
    public static void main(String[] args) throws Exception {
        Entity entity = new Entity(10 , "id");
        Class<? extends Entity> cls = entity.getClass() ;

        Method[] methods= cls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("------------------------------------------");

        Method[] declaredMethods= cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }



        //when the method that you want to invoke is public
        Method method =  cls.getMethod("setVal" , int.class);
        method.invoke(entity,15);

        Method method2 =  cls.getMethod("getVal" , null);
        System.out.println(method2.invoke(entity, null));


        //when the method that you want to invoke is private

//        Method method3 =  cls.getDeclaredMethod("setType" , String.class);
//        method3.setAccessible(true);
//        method3.invoke(entity,"hello");
//
//        Method method4 =  cls.getDeclaredMethod("getType" , null);
//        method4.setAccessible(true);
//        System.out.println(method4.invoke(entity, null));

    }

}
