package com.dh.test;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = Integer.parseInt(in.nextLine());
        int sort = Integer.parseInt(in.nextLine());

        Map<String, Integer> map = new TreeMap<>();

        for(int i = 0; i < num; i ++){
            String[] input = in.nextLine().split(" ");
            map.put(input[0], Integer.parseInt(input[1]));
        }



        for(String key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }


    }
}
