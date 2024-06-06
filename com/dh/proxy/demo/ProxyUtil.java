package com.dh.proxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static UserService createProxy(UserService userService){
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{UserService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        if (method.getName().equals("login") ||
                        method.getName().equals("delete") ||
                        method.getName().equals("add")){
                            long start = System.currentTimeMillis();
                            Object o =  method.invoke(userService, args);
                            long time = System.currentTimeMillis() - start;
                            System.out.println(method.getName() + "方法执行花费了" + time / 1000.0 + "s");
                            return o;

                        }
                        return method.invoke(userService, args);
                    }
                }
        );
        return userServiceProxy;
    }

}
