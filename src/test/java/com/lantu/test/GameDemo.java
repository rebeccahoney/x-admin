package com.lantu.test;

import org.junit.jupiter.api.BeforeEach;

import java.util.*;
import java.util.function.BiConsumer;

public class GameDemo {

    public static void main(String[] args) {
        //牌
        //fangjian
        Room room = new Room();
        room.run();
        Map<String,Integer> testmap = new HashMap<>();
        testmap.put("ceshi",100);
        testmap.put("ceshi2",101);
        testmap.put("ceshi3",102);
        System.out.println(testmap);
        testmap.get("ceshi");
        System.out.println(testmap.get("ceshi"));
        System.out.println(testmap.remove("ceshi"));
        System.out.println(testmap);
        Map<String,Double> mappeple = new HashMap<>();
        mappeple.put("zhizhujing",165.5);
        mappeple.put("zixiaxianzi",168.9);
        mappeple.put("zhizunbao",165.8);
        mappeple.put("niumowang",183.8);
        System.out.println(mappeple);
        Set<String > keys = mappeple.keySet();
        System.out.println(keys);
        for(String key: keys){
            mappeple.get(key);
            double values = mappeple.get(key);

            System.out.println(values);
        }

        //method2:
        Set<Map.Entry<String,Double>> entries = mappeple.entrySet();
        System.out.println(entries);
        for (Map.Entry<String, Double> entry : entries) {

        }
        //method3:
        mappeple.forEach(new BiConsumer<String, Double>() {
            @Override
            public void accept(String s, Double aDouble) {

            }
        });
        mappeple.forEach((key, value) ->{
            System.out.println(key+value);
        });



        //将80个学生选择的数据加到程序中去，
        List<String> data = new ArrayList<>();
        String[] selects = {"a","b","c","d"};
        Random r = new Random();


    }
}
