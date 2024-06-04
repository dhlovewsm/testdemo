package com.dh.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 使用FileWriter按照字符写文件
 */
public class WriterTest {

    public static void main(String[] args) {

        try (Writer writer = new FileWriter("aaa.txt", true)){

            writer.write("\r\nabsdsfslkdjf我爱你");
            writer.write("97");
            writer.write(97);

        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
