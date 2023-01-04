package com.arifacar.reactivedomain.domain;

public record User(int id, String name, int age) {
    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
