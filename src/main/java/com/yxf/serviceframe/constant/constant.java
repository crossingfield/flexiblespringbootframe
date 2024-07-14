package com.yxf.serviceframe.constant;

public class constant {

    // 服务配置
    public static class ConfigPath{
        public static final String ONLINE_SERVICE_PATH = "online_service.conf";
        public static final String ONLINE_SERVICE = "online_service";
        public static final String SERVICE_LIST = "service_list";
        public static final String APP_ENV = "APP_ENV";
        public static final String CONFIGPATH = "service_conf";
    }

    // 模块路径配置
    public static class ServiceConf {
        public static final String SERVICEDIRPATH = "com.yxf.serviceframe.service";
        public static final String SERVICECONF = "service.conf";
        public static final String MODULECONF = "module.conf";
        public static final String DICTMANAGERCONF = "dict_manager.conf";
    }

    // 配置文件内容分隔符
    public static class Symbol {
        public static final String VERTICAL_LINE = "\\|";
        public static final String COMMA = ",";
        public static final String UNDERLINE = "_";
        public static final String SLASH = "/";
        public static final String SEMICOLON = ";";
        public static final String WHITESPACE = " ";
        public static final String POUND = "#";
        public static final String COLON = ":";
    }

    // 应用名
    public static class AppName{
        public static final String sampleService = "sampleService";
    }

    // 状态码
    public static class StatusCode{
        public static final String SUCCESS = "200";
        public static final String EMPTYDATA = "300";
        public static final String ERROR = "404";
    }

    public static final String DATAFIELD = "data_field";
}
