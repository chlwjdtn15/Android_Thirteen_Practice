package com.example.week11;

public class User {


    String name = "";
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", age=" + age;

    }
}
