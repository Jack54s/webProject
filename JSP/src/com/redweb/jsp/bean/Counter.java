package com.redweb.jsp.bean;

/**
 * Created by 11407 on 2017/3/6.
 */
public class Counter {

    private int count;

    public int getCount() {
        return ++count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
