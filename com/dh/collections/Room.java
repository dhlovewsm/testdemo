package com.dh.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Room {

    private List<Card> allCards = new ArrayList<>();

    public Room(){
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] colors = {"♥", "♦", "♣", "♠"};

        int size = 0;
        for (String number : numbers) {
            size ++;
            for (String color : colors) {
                Card card = new Card(number, color, size);
                allCards.add(card);
            }
        }

        allCards.add(new Card("", "小王", ++size));
        allCards.add(new Card("", "大王", ++size));
        System.out.println("新牌：" + allCards);
    }


    /**
     * 洗牌
     */
    public void washCards(){
        Collections.shuffle(allCards);
    }

    /**
     * 排序
     */
    public void sortCards(List<Card> cards){
        Collections.sort(cards, Comparator.comparingInt(Card::getSize));
    }


    /**
     * 游戏启动
     */
    public void start(){
        washCards();
        System.out.println("洗牌后：" + allCards);

        //发牌
        List<Card> player1 = new ArrayList<>();
        List<Card> player2 = new ArrayList<>();
        List<Card> player3 = new ArrayList<>();

        for (int i = 0; i < allCards.size() - 3; i++) {
            Card card = allCards.get(i);
            if (i % 3 == 0){
                player1.add(card);
            } else if (i % 3 == 1) {
                player2.add(card);
            } else {
                player3.add(card);
            }
        }

        //排序
//        Collections.sort(player1, (o1, o2) -> o1.getSize() - o2.getSize());
//        Collections.sort(player2, (o1, o2) -> o1.getSize() - o2.getSize());
//        Collections.sort(player3, (o1, o2) -> o1.getSize() - o2.getSize());
        sortCards(player1);
        sortCards(player2);
        sortCards(player3);
        System.out.println("---------------------1号玩家------------------------------");
        System.out.println(player1);
        System.out.println("---------------------2号玩家---------------------------------");
        System.out.println(player2);
        System.out.println("---------------------3号玩家-----------------------------------");
        System.out.println(player3);

        List<Card> lastThreeCards = allCards.subList(allCards.size() - 3, allCards.size());
        System.out.println("底牌：" + lastThreeCards);
        player2.addAll(lastThreeCards);
        sortCards(player2);
        System.out.println("2号玩家抢到地主后:" + player2);


    }

}
