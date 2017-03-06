package com.redweb.jsp.bean;

/**
 * Created by 11407 on 2017/3/6.
 */
public class Person {
    private String name;
    private int age;
    private String sex;
    private boolean secret;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }

    public String getName() {

        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public boolean isSecret() {
        return secret;
    }
}
