package com.dh.map;

import java.util.*;

public class SubmitDemo {

    public static void main(String[] args) {

        List<String> data = new ArrayList<>();
        String[] selects = {"A", "B", "C", "D"};

        new HashSet<>();

        Random random = new Random();
        for (int i = 0; i < 80; i++) {

            int index = random.nextInt(4);
            data.add(selects[index]);
        }

        System.out.println(data);

        Map<String, Integer> map = new HashMap<>();
        for (String d : data) {
            if (map.containsKey(d)){
                map.put(d, map.get(d) + 1);
            }else {
                map.put(d, 1);
            }
        }

        map.forEach((k, v) -> System.out.println(k + "--->" + v));


    }

}
