package com.yxf.serviceframe.apiCore;

import com.yxf.serviceframe.apiCore.apiImpl.SampleApiImpl;
import com.yxf.serviceframe.constant.conf.serviceConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiFactory {

    private final SampleApiImpl sampleApi;

    @Autowired
    public ApiFactory(SampleApiImpl sampleApi){
        this.sampleApi = sampleApi;
    }

    public ApiAdapter getApiFromFactory(serviceConf.apiCoreType.apiType apiType){
        if (serviceConf.apiCoreType.apiType.sample.equals(apiType))
            return sampleApi;
        return null;
    }
}
