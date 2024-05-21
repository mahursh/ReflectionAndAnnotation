package com.mft;

import com.mft.annotation.MostUsed;
import com.mft.annotation.Utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReadingAnnotation {
    public static void main(String[] args) throws  Exception{
            Class<?> cls = Class.forName("com.mft.annotation.Utility");
            Constructor<?> constructor = cls.getConstructor();
            Utility u = (Utility) constructor.newInstance();

            Method[] methods = cls.getDeclaredMethods();

        for (Method method: methods) {
            if(method.isAnnotationPresent(MostUsed.class)){
               method.setAccessible(true);
              MostUsed annotation = method.getAnnotation(MostUsed.class);
              String value = annotation.value();
               method.invoke(u ,value);
            }

        }
    }
}
