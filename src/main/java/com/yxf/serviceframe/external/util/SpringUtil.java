package com.yxf.serviceframe.external.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import javax.annotation.Nonnull;

public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(@Nonnull ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static void set(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static <T> T getEntity(Class<T> entityClass) {
        return context.getBean(entityClass);
    }

    public static <T> T getEntity(String name, Class<T> entityClass) {
        return context.getBean(name, entityClass);
    }
}
