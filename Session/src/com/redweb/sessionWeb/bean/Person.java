package com.redweb.sessionWeb.bean;

import java.util.Date;

/**
 * Created by 11407 on 2017/3/7.
 */
public class Person {

    private static final long serialVersionUID = -827111150707830908L;

    private String name;

    private String password;

    private int age;

    private Date birthday;

    public Person(String name, String password, int age, Date birthday) {
        super();
        this.name = name;
        this.password = password;
        this.age = age;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public static long getSerialVersionUID() {

        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }
}
