package com.yxf.serviceframe.lib.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.yxf.serviceframe.constant.constant;
import com.yxf.serviceframe.interphase.conf.module.moduleConf;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Module {

    public moduleBean moduleBean;
    public moduleConf module_conf;
    public Logger logger;
    public Map<String, Object> module_data;

    public void init() {
    }

    public void init(moduleConf module_conf, Module module_obj) {
        this.module_conf = module_conf;
        this.logger = Logger.getLogger(module_obj.getClass());
    }

    public void prepare(){}

    public void execute() {
        this.module_data = new HashMap<>();
    }

    public void reset(moduleBean moduleBean) {
        this.moduleBean = moduleBean;
    }

    public String getModuleConfFilePath(String conf_name) {
        return this.module_conf.getApp_name() + constant.Symbol.SLASH + this.module_conf.getConfig_manager().get(conf_name);
    }

    public String getModuleConfValue(String conf_name) {
        return this.module_conf.getConfig_manager().get(conf_name).trim();
    }

    public void standReserveInfo() {
        if (this.module_conf.getConfig_manager().containsKey(constant.DATAFIELD)) {
            String dataField = this.module_conf.getConfig_manager().get(constant.DATAFIELD).trim();
            for (String key_type : dataField.split(constant.Symbol.SEMICOLON)){
                String key = key_type.split(constant.Symbol.VERTICAL_LINE)[0];
                String type = key_type.split(constant.Symbol.VERTICAL_LINE)[1];
                if (this.module_data.containsKey(key)){
                    Object o = this.module_data.get(key);
                    switch (type){
                        case "json":
                            this.moduleBean.reserveInfo.add(key, (JsonObject)o);
                            break;
                        case "int":
                            this.moduleBean.reserveInfo.addProperty(key, (int)o);
                            break;
                        case "float":
                            this.moduleBean.reserveInfo.addProperty(key, (float)o);
                            break;
                        case "double":
                            this.moduleBean.reserveInfo.addProperty(key, (double)o);
                            break;
                        case "jsonarray":
                            this.moduleBean.reserveInfo.add(key, (JsonArray)o);
                            break;
                        case "string":
                        default:
                            this.moduleBean.reserveInfo.addProperty(key, (String)o);
                            break;
                    }
                }
            }
        }
    }
}
