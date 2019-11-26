package com.example.ioc;

import com.example.ioc.context.AnnotationApplicationContext;

import java.util.List;

public class IocApplication {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        AnnotationApplicationContext context
                = new AnnotationApplicationContext(Person.class, Address.class, Job.class);

        Person person = (Person) context.getBean("person");
        person.setName("Nick");
        person.setAge(18);

        Address address = (Address) context.getBean("address");
        address.setCity("New York");
        address.setAddress("Street 55");

        Job job = (Job) context.getBean("job");
        job.setName("Engineer");
        job.setSalary(100500);

        List<Object> beanList = context.getAllBeans();
        for (Object o : beanList) {
            System.out.println(o);
        }
    }
}
