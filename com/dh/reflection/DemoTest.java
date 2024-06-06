package com.dh.reflection;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

/**
 * 基于反射，对于任意一个对象，可以把他的字段名和对应的值保存到文件中
 */
public class DemoTest {


    public static void saveObject(Object ojb) throws Exception {

        PrintStream ps = new PrintStream(new FileOutputStream("resource/data.txt", true));
        Class c = ojb.getClass();
        ps.println("-------------" + c.getSimpleName() + "---------------------");
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            field.setAccessible(true);
            Object o = field.get(ojb);
            ps.println(name + "=" + o);
        }
        ps.close();

    }

    @Test
    public void test() throws Exception {

        Cat cat = new Cat("Tom", 1);
        saveObject(cat);


    }



}
