package com.yxf.serviceframe.apiCore.apiImpl;

import com.yxf.serviceframe.apiCore.ApiAdapter;
import com.yxf.serviceframe.constant.conf.serviceConf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@PropertySource(value = "classpath:"+ serviceConf.PropertySource)
public class SampleApiImpl implements ApiAdapter {

    @Override
    public void invoke() {}

}
