package com.example.ioc;

import com.example.ioc.context.Component;

@Component(name = "job")
public class Job {
    private String name;
    private int salary;

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
