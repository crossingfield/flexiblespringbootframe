package com.yxf.serviceframe.interphase.conf.module;

import com.yxf.serviceframe.constant.constant;
import lombok.Getter;
import org.ini4j.Profile.Section;
import org.ini4j.Wini;

import java.util.HashMap;
import java.util.Map;

public class moduleConf {

    @Getter
    private final String app_name;
    private final String topology_name;
    @Getter
    private final Map<String, String> config_manager = new HashMap<>();

    private final String path;

    public moduleConf(String app_name, String topology_name)throws Exception{
        this.app_name = app_name;
        this.topology_name = topology_name;
        this.path = this.app_name + constant.Symbol.SLASH + constant.ServiceConf.MODULECONF;
        load_conf();
    }

    private void load_conf()throws Exception{
        Wini ini = new Wini(this.getClass().getClassLoader().getResourceAsStream(this.path));
        if (!ini.containsKey(this.topology_name))throw new Exception(this.path + "配置错误!!!");
        else {
            Section section = ini.get(this.topology_name);
            for (String name : section.keySet())
                    this.config_manager.put(name.trim(), section.get(name.trim()).trim());
        }
    }

    public String getTopology_name() {
        return topology_name;
    }

}
