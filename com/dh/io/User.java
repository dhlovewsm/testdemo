package com.dh.io;

import java.io.Serializable;

public class User implements Serializable {

    private String loginName;
    private String username;

    //该成员变量不参与序列化
    private transient String password;

    private int age;


    public User() {
    }

    public User(String loginName, String username, String password, int age) {
        this.loginName = loginName;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginName='" + loginName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
