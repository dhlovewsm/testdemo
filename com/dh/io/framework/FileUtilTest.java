package com.dh.io.framework;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 测试IO框架
 * commons-io
 */
public class FileUtilTest {

    public static void main(String[] args) throws IOException {

        FileUtils.copyFile(new File("a.txt"), new File("aa.txt"));
        FileUtils.copyDirectory(new File("resource"), new File("resource1"));

        FileUtils.deleteDirectory(new File("resource1"));


        /**
         * Java原生的
         */
        Files.copy(Path.of("b.txt"), Path.of("bb1.txt"));
        Files.delete(Path.of("bb1.txt"));

        System.out.println(Files.readString(Path.of("a.txt")));

    }

}
