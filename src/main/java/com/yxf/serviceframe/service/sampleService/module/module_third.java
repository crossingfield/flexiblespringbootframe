package com.yxf.serviceframe.service.sampleService.module;

import com.yxf.serviceframe.lib.service.Module;

public class module_third extends Module {

    @Override
    public void prepare() {
        super.prepare();
    }

    @Override
    public void execute() {
        super.execute();
        logger.debug("###  start module third module  ###");
    }
}
