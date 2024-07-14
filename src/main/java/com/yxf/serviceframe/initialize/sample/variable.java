package com.yxf.serviceframe.initialize.sample;

public class variable {

    private volatile static variable instance;

    private variable(){}

    public static variable getInstance(){
        if (instance == null){
            synchronized (variable.class){
                if (instance == null) {
                    instance = new variable();
                }
            }
        }
        return instance;
    }
}
