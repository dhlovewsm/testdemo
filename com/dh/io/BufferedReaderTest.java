package com.dh.io;

import java.io.*;

public class BufferedReaderTest {

    public static void main(String[] args) {

        try(
                Reader reader = new FileReader("aaa.txt");
                BufferedReader br = new BufferedReader(reader);

                Writer writer = new FileWriter("bbb.txt");
                BufferedWriter bw = new BufferedWriter(writer);
                ){

//            char[] buffer = new char[1024];
//            int len;
//            while((len = br.read(buffer)) != -1){
//                System.out.println(new String(buffer, 0, len));
//                bw.write(buffer, 0, len);
//            }
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
                bw.write(line);
                bw.newLine();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
