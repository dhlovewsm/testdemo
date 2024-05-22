package com.dh.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MapTest {


    public static void main(String[] args) {

        Map<String, Double> map = new HashMap<>();
        map.put("蜘蛛精", 162.9);
        map.put("蜘蛛精", 169.9);
        map.put("紫霞", 165.8);
        map.put("至尊宝", 169.9);
        map.put("牛魔王", 183.6);
        System.out.println(map);


        //通过键遍历
        System.out.println("----------------------------------------------");
        for (String key: map.keySet()){
            System.out.println(key + "--->" + map.get(key));
        }

        //通过键值对来遍历
        System.out.println("----------------------------------------------");
        Set<Map.Entry<String, Double>> entries = map.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

        //通过lambda遍历
        System.out.println("----------------------------------------------");
        map.forEach((k, v) -> System.out.println(k + "--->" + v));

    }

}
