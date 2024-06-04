package com.dh.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象序列化流与反序列化
 */
public class ObjectInputStreamTest {

    public static void main(String[] args) {

        write();

        read();

    }

    /**
     * 序列化
     */
    private static void write(){

        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d.txt"));
        ){

            User user = new User("admin", "admin", "123456", 20);
            oos.writeObject(user);
            System.out.println("序列化对象成功！");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }


    /**
     * 反序列化
     */
    private static void read(){

        try (
                ObjectInputStream ois =
                        new ObjectInputStream(new FileInputStream("d.txt"));
        ){


            User user = (User) ois.readObject();
            System.out.println(user);
            System.out.println("反序列话对象成功");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
