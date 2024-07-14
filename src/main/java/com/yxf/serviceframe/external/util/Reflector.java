package com.yxf.serviceframe.external.util;

import com.yxf.serviceframe.constant.constant;
import com.yxf.serviceframe.lib.service.Module;

import java.lang.reflect.Constructor;

public class Reflector {

    public Module serviceModule;

    public Reflector(String serviceName, String modulePath) throws Exception{
        Class<?> aClass = Class.forName(constant.ServiceConf.SERVICEDIRPATH + "." + serviceName + "." + modulePath);
        Constructor<?> con =  aClass.getConstructor() ;
        this.serviceModule = (Module) con.newInstance();
    }
}
