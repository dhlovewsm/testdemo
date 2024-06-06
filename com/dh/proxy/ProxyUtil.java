package com.dh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static Star createProxy(BigStar bigStar){
        Star starProxy = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        //代理对象要做的事情
                        if (method.getName().equals("sing")){
                            System.out.println("准备话筒，收钱20万");
                        }else if (method.getName().equals("dance")) {
                            System.out.println("准备场地，收钱100万");
                        }
                        return method.invoke(bigStar, args);
                    }
                });

        return starProxy;
    }


}
