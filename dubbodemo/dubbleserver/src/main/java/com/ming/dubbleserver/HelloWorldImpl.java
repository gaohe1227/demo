package com.ming.dubbleserver;

public class HelloWorldImpl  implements HelloWorld {

    public String hello(String name) {
        name = name + "С������";
        return name;

    }
}
