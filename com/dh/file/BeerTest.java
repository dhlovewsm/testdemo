package com.dh.file;

public class BeerTest {

    public static int totalNUm;
    public static int lastBottleNum;
    public static int lastCoverNum;

    public static void main(String[] args) {
        buyBeer(10);
        System.out.println("总瓶数：" + totalNUm);
        System.out.println("剩余瓶子数：" + lastBottleNum);
        System.out.println("剩余盖子数：" + lastCoverNum);
    }


    /**
     * 啤酒问题，啤酒2元一瓶，4个瓶盖可以换一瓶，2个空瓶可以换1瓶
     * @param money 金额
     */


    public static void buyBeer(int money){

        int buyNum = money / 2;
        totalNUm += buyNum;

        int allBottleNum = buyNum + lastBottleNum;
        int allCoverNum = buyNum + lastCoverNum;

        int allMoney = 0;

        if (allBottleNum >= 2){
            allMoney += (allBottleNum / 2) *   2;
        }
        lastBottleNum = allBottleNum % 2;

        if(allCoverNum >= 4){
            allMoney += (allCoverNum / 4) * 2;
        }

        lastCoverNum = allCoverNum % 4;

        if (allMoney >= 2){
            buyBeer(allMoney);
        }

    }
}
