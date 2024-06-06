package com.dh.annotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationTest {

    @Test
    public void testAnnotation() throws Exception {

        Class<Demo> c = Demo.class;

//        Annotation[] annotations = c.getDeclaredAnnotations();

        //判断类上是否有该注解
        if (c.isAnnotationPresent(MyAnno.class)){
            MyAnno anno = (MyAnno) c.getDeclaredAnnotation(MyAnno.class);
            System.out.println(anno.value());
            System.out.println(anno.aaa());
            System.out.println(Arrays.toString(anno.bbb()));
        }

        System.out.println("=====================================");

        //判断方法上是否有该注解
        Method method = c.getDeclaredMethod("test");
        if (method.isAnnotationPresent(MyAnno.class)){
            MyAnno anno = (MyAnno) method.getDeclaredAnnotation(MyAnno.class);
            System.out.println(anno.value());
            System.out.println(anno.aaa());
            System.out.println(Arrays.toString(anno.bbb()));
        }


    }

}
