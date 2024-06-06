package com.dh.annotation;

@MyAnno(value = "Jack", aaa = 50, bbb = {"Java", "HTML"})
public class Demo {

    @MyAnno(value = "Tom", aaa = 20, bbb = {"JS", "C"})
    public void test(){
        System.out.println("=========test===========");
    }

}
