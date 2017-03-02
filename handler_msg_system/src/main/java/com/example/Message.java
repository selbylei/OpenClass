package com.example;

public class Message {

    Handler target;

    public int what;
    public Object object;


    @Override
    public String toString() {
        return object.toString();
    }
}
