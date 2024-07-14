package com.yxf.serviceframe;

import com.yxf.serviceframe.external.util.SpringUtil;
import com.yxf.serviceframe.grpcService.ServiceGrpcImpl;
import com.yxf.serviceframe.lib.service.Resource;
import com.yxf.serviceframe.lib.service.serviceUtils;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Map;

@EnableAsync
@SpringBootApplication
public class Application {

	private static final int serverPort = 9000;

	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		SpringUtil.set(context);
		// 服务配置载入
		serviceUtils serviceUtil = serviceUtils.getInstance();
		System.out.println("serviceUtil conf init...");
		// 服务模块载入
		Map<String, Resource> resourceMap = Resource.getResourceMap(serviceUtil);
		System.out.println("all service module init...");

		Server server = ServerBuilder.forPort(serverPort)
				.addService(new ServiceGrpcImpl(serviceUtil, resourceMap))
				.build();
		System.out.println("Staring Grpc Server...");
		server.start();
		System.out.println("Grpc Service started");
		server.awaitTermination();

	}
}
