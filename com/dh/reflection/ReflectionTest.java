package com.dh.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {


    @Test
    public void testConstructor() throws Exception {

        Class<Cat> c = Cat.class;

        Constructor<Cat> cs = c.getDeclaredConstructor();
        System.out.println(cs.getName() + "--->" + cs.getParameterCount());

        cs.setAccessible(true);
        Cat cat = cs.newInstance();
        System.out.println(cat);

        Constructor<Cat> cs1 = c.getDeclaredConstructor(String.class, int.class);
        System.out.println(cs1.getName() + "-" + cs1.getParameterCount());
        cs1.setAccessible(true);
        Cat cat1 = cs1.newInstance("Tom", 1);
        System.out.println(cat1);

    }

    @Test
    public void testFields() throws Exception {

        Class<Cat> c = Cat.class;
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName() + "--->" +f.getType());
        }
        Field name = c.getDeclaredField("name");
        System.out.println(name.getName() + "--->" + name.getType());

        Cat cat = new Cat();
        name.setAccessible(true);
        name.set(cat, "Jack");  //赋值
        System.out.println(cat);

        System.out.println(name.get(cat));  //取值

    }

    @Test
    public void testMethod() throws Exception {

        Class<Cat> c = Cat.class;
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m.getName() + "--->" + m.getParameterCount());
        }

        Method m = c.getDeclaredMethod("setName", String.class);
        System.out.println(m.getName() + "--->" + m.getParameterCount() +"--->" + m.getReturnType());

        Cat cat = new Cat();
        m.setAccessible(true);
        m.invoke(cat, "Tom");
        System.out.println(cat);
    }

}
