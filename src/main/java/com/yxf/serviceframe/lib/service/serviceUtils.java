package com.yxf.serviceframe.lib.service;

import com.yxf.serviceframe.constant.constant;
import com.yxf.serviceframe.entity.RequestType;
import com.yxf.serviceframe.entity.requestInfo;
import com.yxf.serviceframe.entity.responseInfo;
import org.apache.log4j.Logger;
import org.ini4j.Wini;

import java.io.IOException;
import java.util.*;

public class serviceUtils {

    public Logger logger = Logger.getLogger(serviceUtils.class);

    private final Map<String, String> appConf = new HashMap<>();
    private final Map<String, Set<RequestType>> appNames = new HashMap<>();

    private static serviceUtils instance;

    private serviceUtils()throws Exception{
        String fileName = constant.ConfigPath.CONFIGPATH + constant.Symbol.SLASH + constant.ConfigPath.ONLINE_SERVICE_PATH;
        Wini ini = null;
        try {
            ini = new Wini(this.getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            logger.error("导入配置文件错误:" + fileName);
            System.exit(-1);
        }
        // 初始化配置
        if (ini.isEmpty()) {
            logger.warn("配置文件为空:" + fileName);
            System.exit(-1);
        }
        else {
            appConf.put(constant.ConfigPath.SERVICE_LIST, ini.get(constant.ConfigPath.ONLINE_SERVICE, constant.ConfigPath.SERVICE_LIST));
            appConf.put(constant.ConfigPath.APP_ENV, ini.get(constant.ConfigPath.APP_ENV, constant.ConfigPath.APP_ENV));
        }

        // 一个简单的例子
        Set<RequestType> sampleService = new HashSet<>();
        Collections.addAll(sampleService,
                RequestType.SAMPLE);
        Map<String, Set<RequestType>> app = new HashMap<>();
        app.put(constant.AppName.sampleService, sampleService);
        // 全部应用初始化
        for (String name : this.appConf.get(constant.ConfigPath.SERVICE_LIST).trim().split(constant.Symbol.VERTICAL_LINE))
            if (app.containsKey(name))
                this.appNames.put(name, app.get(name));
            else {
                String msg = constant.ConfigPath.CONFIGPATH + constant.Symbol.SLASH + constant.ConfigPath.ONLINE_SERVICE_PATH + "配置错误,应配置为:" + app.keySet();
                logger.error(msg);
                throw new Exception(msg);
            }

        // 配置合法性检查
        isLegal();

        logger.info("serviceUtils init success.");
    }

    // 默认值的返回
    public static responseInfo getDefault(requestInfo request, String code){
        return responseInfo.newBuilder()
                .setReponseCode(code)
                .setReType(request.getReType())
                .setSessionId(request.getRequestId())
                .setUserId(request.getUserId())
                .build();
    }

    public String getAppName(RequestType searchType){
        for (String name : this.appNames.keySet())
            if (this.appNames.get(name).contains(searchType))
                return name;
        return "";
    }

    public String getAppEnv(){return appConf.getOrDefault(constant.ConfigPath.APP_ENV, "");}

    public Map<String, Set<RequestType>> getAppNames() {
        return appNames;
    }

    public static synchronized serviceUtils getInstance() throws Exception{
        if(instance==null){
            instance=new serviceUtils();
        }
        return instance;
    }

    private void isLegal()throws Exception{
        List<String> service_list = Arrays.asList(this.appConf.get(constant.ConfigPath.SERVICE_LIST).trim().split(constant.Symbol.VERTICAL_LINE));
        List<String> appNames = new ArrayList<>(getAppNames().keySet());
        if (service_list.isEmpty() || appNames.isEmpty() || service_list.size() != appNames.size()) logger.error("服务配置错误！！！");
        for (String name : service_list)
            if (!appNames.contains(name)) {
                logger.error("服务配置错误！！！");
                throw new Exception("服务配置错误！！！");
            }
    }

}
