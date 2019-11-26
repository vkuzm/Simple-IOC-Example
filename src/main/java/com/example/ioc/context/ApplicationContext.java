package com.example.ioc.context;

import java.util.List;

public interface ApplicationContext {
    Object getBean(String name);

    List<Object> getAllBeans();

    void processBeforeBeanInitialization(String beanName);

    void processAfterBeanInitialization(String beanName);
}
