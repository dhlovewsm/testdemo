package com.dh.io;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 数据输入输出流读写文件
 */
public class DataInputStreamTest {

    public static void main(String[] args) {

        write();

        read();

    }

    /**
     * 写文件
     */
    private static void write(){

        try(
                DataOutputStream dos =
                        new DataOutputStream(new FileOutputStream("c.txt"));
        ){

            dos.writeInt(5);
            dos.writeDouble(1.0);
            dos.writeBoolean(true);
            dos.writeChar('c');
            dos.writeUTF("中国China");


        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }


    /**
     * 读文件
     */
    private static void read(){

        try(
                DataInputStream dis =
                        new DataInputStream(new FileInputStream("c.txt"));

        ){


            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readChar());
            System.out.println(dis.readUTF());

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

}
