package com.dh.annotation.test;

import java.lang.reflect.Method;

public class AnnotationTest {

    @MyTest
    public void test1(){
        System.out.println("=======test1============");
    }

    @MyTest
    public void test2(){
        System.out.println("=======test2============");
    }

//    @MyTest
    public void test3(){
        System.out.println("=======test3============");
    }

    @MyTest
    public void test4(){
        System.out.println("=======test4============");
    }

    /**
     * 实现加了MyTest注解的方法才能执行
     * @param args
     */
    public static void main(String[] args) throws Exception {

        AnnotationTest annotationTest = new AnnotationTest();

        Class<AnnotationTest> c = AnnotationTest.class;
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)){
                method.invoke(annotationTest);
            }
        }

    }


}
