package com.example.ioc;

import com.example.ioc.context.Component;
import com.example.ioc.context.InjectBean;

@Component(name = "person")
public class Person {
    private String name;
    private Integer age;

    @InjectBean
    private Address address;

    @InjectBean
    private Job job;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", job=" + job +
                '}';
    }
}
