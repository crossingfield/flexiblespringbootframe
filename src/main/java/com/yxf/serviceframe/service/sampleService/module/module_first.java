package com.yxf.serviceframe.service.sampleService.module;

import com.yxf.serviceframe.lib.service.Module;
import com.yxf.serviceframe.initialize.sample.init;

public class module_first extends Module {

    private static init ini;

    @Override
    public void prepare() {
        super.prepare();
        // 初始化配置文件
        ini = init.getInstance();
    }

    @Override
    public void execute() {
        super.execute();
        logger.debug("###  start module first module  ###");
    }
}
