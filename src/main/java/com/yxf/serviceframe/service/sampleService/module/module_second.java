package com.yxf.serviceframe.service.sampleService.module;

import com.yxf.serviceframe.initialize.sample.variable;
import com.yxf.serviceframe.lib.service.Module;

public class module_second extends Module {

    private static variable var;

    @Override
    public void prepare() {super.prepare();var = variable.getInstance();}

    @Override
    public void execute() {
        super.execute();
        logger.debug("###  start module second module  ###");
    }
}
