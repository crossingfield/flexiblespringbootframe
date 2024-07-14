package com.yxf.serviceframe.lib.service;

import com.yxf.serviceframe.entity.responseInfo;
import com.yxf.serviceframe.constant.conf.serviceConf;
import com.yxf.serviceframe.constant.constant;
import com.yxf.serviceframe.external.util.Reflector;
import com.yxf.serviceframe.interphase.conf.module.moduleConf;
import org.apache.log4j.Logger;
import org.ini4j.Wini;

import java.io.IOException;
import java.util.*;

public class Resource {

    public Logger logger = Logger.getLogger(Resource.class);

    private Wini ini = null;
    private final String appName;

    private final List<String> topology_name_list;

    private Map<String, Object> dict_manager;

    public Resource(String appName){

        this.appName = appName;

        this.topology_name_list = new ArrayList<>();

        // 配置与模块导入
        load_conf();
        initDictManager();
        logger.info("Build all " + this.appName + " module success!");
    }

    public responseInfo moduleExecute(moduleBean inputData){
        inputData.dict_manager = this.dict_manager;
        // 模块执行
        try {
            return all_module_execute(inputData);
        }catch (Exception e){
            e.printStackTrace();
            logger.warn(this.appName +  "模块执行失败!!!");
            // 出错兜底返回默认数据
            logger.warn("requestId:" + inputData.request.getRequestId());
            return serviceUtils.getDefault(inputData.request, constant.StatusCode.ERROR);
        }
    }

    private void load_conf(){
        String filePath = this.appName + constant.Symbol.SLASH + constant.ServiceConf.SERVICECONF;
        try {
            ini = new Wini(this.getClass().getClassLoader().getResourceAsStream(filePath));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            logger.error("导入配置文件错误:" + filePath);
            System.exit(-1);
        }
        this.topology_name_list.addAll(Arrays.asList(ini.get(this.appName, serviceConf.TOPOLOGY).split(constant.Symbol.VERTICAL_LINE)));
        // 模块载入
        build_topology();
    }

    private responseInfo all_module_execute(moduleBean inputData){
        List<Module> topology_module_list = build_topology();
        for (Module module : topology_module_list) {
            // 模块间传输数据
            module.reset(inputData);
            module.execute();
            module.standReserveInfo();
            inputData = module.moduleBean;
        }
        return inputData.response;
    }

    private List<Module> build_topology(){
        List<Module> topology_module_list = new ArrayList<>();
        for (String topology_name : this.topology_name_list)
            topology_module_list.add(generate_module(topology_name));
        return topology_module_list;
    }

    private Module generate_module(String topology_name){
        Module module_obj = null;
        try {
            moduleConf module_conf = new moduleConf(this.appName, topology_name);
            module_obj = new Reflector(this.appName, module_conf.getConfig_manager().get(serviceConf.MODULEPATH)).serviceModule;
            module_obj.init(module_conf, module_obj);
            module_obj.prepare();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("执行类:" + topology_name + "初始化错误!");
            System.exit(-1);
        }
        return module_obj;
    }

    public static Map<String, Resource> getResourceMap(serviceUtils serviceUtil){
        Map<String, Resource> resourceMap = new HashMap<>();
        for (String name : serviceUtil.getAppNames().keySet())
            resourceMap.put(name, new Resource(name));
        return resourceMap;
    }

    private void initDictManager(){
        Map<String, Object> map = new HashMap<>();
        // 模块配置读取
        String filePath = this.appName + constant.Symbol.SLASH + constant.ServiceConf.DICTMANAGERCONF;
        try {
            ini = new Wini(this.getClass().getClassLoader().getResourceAsStream(filePath));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            logger.error("导入配置文件错误:" + filePath);
            System.exit(-1);
        }
        if (!ini.isEmpty()) {
            Map<String, Map<String, String>> m = parseInit(ini);
            }
        this.dict_manager = map;
    }

    private Map<String, Map<String, String>> parseInit(Wini ini){
        Map<String, Map<String, String>> map = new HashMap<>();
        for (String key : ini.keySet()) {
            if (!key.contains(constant.Symbol.UNDERLINE)){
                logger.error("服务字典配置未按照格式定义！！！");
                System.exit(-1);
            }
            // 处理服务配置信息
        }
        return map;
    }

    private void isInMap(Map<String, Map<String, String>> map, String val1, String val2, String key){
        if (map.containsKey(key)){
            if (map.get(key).containsKey(val1)){
                logger.error("服务字典初始化存在重复key！！！");
                System.exit(-1);
            }else {
                Map<String, String> m = map.get(key);
                m.put(val1, val2);
                map.put(key, new HashMap<>(m));
            }
        }else
            map.put(key, new HashMap<String, String>() {{put(val1, val2);}});
    }
}
