package com.dh.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamTest {

    public static void main(String[] args) throws IOException {

        OutputStream out = new FileOutputStream("resource/aaa.txt", true);

        out.write("abc".getBytes());
        out.write("我爱你".getBytes());

        out.write("\r\n".getBytes());

        out.write("我爱你abc".getBytes(), 0, 9);

        out.close();

    }

}
