package com.jv.test.ClassLoaderTest;

public class User {
    private String myDefaultName = "test";

    private String phone = "myPhone";

    public User() {
        super();
    }

    public void printUserName(String name){
        System.out.println("userName1 = " + name);
        System.out.println("defaultName = " + myDefaultName + phone);

    }

    public void say(){
        System.out.println("Hello MyClassLoader5");
        System.out.println("Hello MyClassLoader232");

    }
}
