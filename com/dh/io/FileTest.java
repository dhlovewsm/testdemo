package com.dh.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * 恢复文件文本顺序并复制文件
 */
public class FileTest {

    public static void main(String[] args) {

        List<String> data = new ArrayList<>();
        try (
                BufferedReader br = new BufferedReader(new FileReader("resource/a.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("resource/b.txt"));
                ){

            String line;
            while((line = br.readLine()) != null){
                data.add(line);
            }

            Collections.sort(data);

            for (String s : data) {
                bw.write(s);
                bw.newLine();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
