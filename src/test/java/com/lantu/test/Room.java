package com.lantu.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {
    //必须有一副牌
    private List<Card> allCards = new ArrayList<>();
    //把牌放进去
    public Room(){
        //数组定义
        //1.54 cards to save to allCards
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //2.花色
        String[] colors = {"♠️","♥️","♦️","菱形"};
        int size = 0;
        for (String number: numbers){
            for(String color: colors){
                Card c = new Card(number,color,size);
                allCards.add(c);
            }
        }
        //单独存入大小王
        Card c1 = new Card("","小王",++size);
        Card c2 = new Card("","大王",++size);
        Collections.addAll(allCards,c1,c2);
        System.out.println(allCards);


    }
    public void run(){
        //洗牌
        Collections.shuffle(allCards);
        System.out.println("洗完了"+allCards);
        //2.玩家，三个玩家，17张牌，18张牌，用arraylist可以排序，且可重复，可支持索引，可以挑中出牌顺序
        List<Card> linghuchong = new ArrayList<>();
        List<Card> jiumozhi = new ArrayList<>();
        List<Card> renyingying = new ArrayList<>();
        //求余然后发牌
        for (int i = 0; i < allCards.size(); i++) {
            Card c = allCards.get(i);
            if(i%3 ==0){
                linghuchong.add(c);
            }else if(i%3 == 1){
                jiumozhi.add(c);
            }else if(i%3 == 2){
                renyingying.add(c);
            }

        }
        System.out.println("令狐冲的牌:"+linghuchong);
        System.out.println("鸠摩智的牌:"+jiumozhi);
        System.out.println("任盈盈的牌:"+renyingying);
        List<Card> lastThreeCards = allCards.subList(allCards.size() -3,allCards.size());
        System.out.println("三张底牌是"+lastThreeCards);


    }
}
