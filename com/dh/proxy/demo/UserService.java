package com.dh.proxy.demo;

public interface UserService {


    void login(String username, String password) throws InterruptedException;

    void delete(String username) throws InterruptedException;


    void add(String username, String password) throws InterruptedException;

}
