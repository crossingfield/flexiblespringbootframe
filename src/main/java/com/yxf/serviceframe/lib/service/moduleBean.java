package com.yxf.serviceframe.lib.service;

import com.google.gson.JsonObject;
import com.yxf.serviceframe.entity.requestInfo;
import com.yxf.serviceframe.entity.responseInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 模块数据传递定义
 */
public class moduleBean<T> {

    public Map<String, Object> dict_manager;

    public requestInfo request;
    public responseInfo response;

    public String app_env;

    public JsonObject reserveInfo = new JsonObject();

    // 业务模块私有,方法获取
    @Getter
    @Setter
    private T data;

    public moduleBean(){}

}
