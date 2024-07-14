package com.yxf.serviceframe.grpcService;

import com.yxf.serviceframe.entity.requestInfo;
import com.yxf.serviceframe.entity.responseInfo;
import com.yxf.serviceframe.lib.service.Resource;
import com.yxf.serviceframe.lib.service.serviceUtils;
import com.yxf.serviceframe.lib.service.moduleBean;
import com.yxf.serviceframe.constant.constant;
import io.grpc.stub.StreamObserver;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.util.Map;

public class ServiceGrpcImpl extends ServceGrpc.ServceImplBase{

    public Logger logger = Logger.getLogger(ServiceGrpcImpl.class);

    private final serviceUtils serviceUtil;
    private final Map<String, Resource> resourceMap;

    public ServiceGrpcImpl(serviceUtils serviceUtil, Map<String, Resource> resourceMap){this.serviceUtil = serviceUtil;this.resourceMap = resourceMap;}

    @Override
    public void method(requestInfo request, StreamObserver<responseInfo> responseObserver) {
        responseInfo response;
        // 获取应用名称
        String appName = this.serviceUtil.getAppName(request.getReType());
        // 初始化module_data
        moduleBean inputData = new moduleBean();
        inputData.request = request;
        inputData.app_env = this.serviceUtil.getAppEnv();

        if (StringUtils.isBlank(appName)) {
            logger.warn("无法获取到应用名称:requestId:" + request.getRequestId() + ",requestType:" + request.getReType());
            response = serviceUtils.getDefault(request, constant.StatusCode.ERROR);
        }else {
            Resource resource = resourceMap.get(appName);
            response = resource.moduleExecute(inputData);
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
