package com.yxf.serviceframe.initialize.sample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class init {

    private volatile static init instance;
    private static final String SEQ = " ";
    //对应模块配置初始化
    private init(){}

    public static init getInstance(){
        if (instance == null){
            synchronized (init.class){
                if (instance == null) {
                    instance = new init();
                }
            }
        }
        return instance;
    }
}
