package com.example.ioc.context;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AnnotationApplicationContext implements ApplicationContext {
    private final HashMap<String, Object> beansContainer = new HashMap<>();

    public AnnotationApplicationContext(Class... classes) throws IllegalAccessException, InstantiationException {
        for (Class c : classes) {
            if (c.isAnnotationPresent(Component.class)) {
                Component annotation = (Component) c.getAnnotation(Component.class);
                String beanName = annotation.name();

                processBeforeBeanInitialization(beanName);
                processBeanInitialization(c, beanName);
                processAfterBeanInitialization(beanName);
            }
        }

        processInjectionAnnotations();
    }

    private void processBeanInitialization(Class c, String beanName) throws InstantiationException, IllegalAccessException {
        Object bean = c.newInstance();
        beansContainer.put(beanName, bean);
        System.out.println("Bean {" + beanName + "} is initialized");
    }

    public void processBeforeBeanInitialization(String beanName) {
        System.out.println("Bean {" + beanName + "} before initialization");
    }

    public void processAfterBeanInitialization(String beanName) {
        System.out.println("Bean {" + beanName + "} after initialization\n");
    }

    private void processInjectionAnnotations() throws IllegalAccessException {
        for (Object bean : beansContainer.values()) {
            for (Field field : bean.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(InjectBean.class)) {
                    field.setAccessible(true);

                    Object injectedBean = beansContainer.get(field.getName());
                    field.set(bean, injectedBean);
                }
            }
        }
    }

    public Object getBean(String name) {
        return beansContainer.get(name);
    }

    public List<Object> getAllBeans() {
        return beansContainer.entrySet()
                .stream()
                .map(o -> "Container: {" + o.getKey() + "}; Values: " + o.getValue())
                .collect(Collectors.toList());
    }
}
