package com.example.ioc;

import com.example.ioc.context.Component;

@Component(name = "address")
public class Address {
    private String city;
    private String address;

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
