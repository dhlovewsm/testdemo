package com.dh.proxy;

public class BigStar implements Star{

    private String name;

    public BigStar(String name){
        this.name = name;
    }

    @Override
    public String sing(String name){
        System.out.println(this.name + "唱歌：" + name);
        return "thanks";
    }

    @Override
    public void dance(){
        System.out.println(this.name + "跳舞");
    }


}
