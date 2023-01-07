package com.arifacar.reactivedomain.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Locale;
@Document
public record User(@Id String id, String name, String surname, String email, Integer cityId) {
    public User(String name, String surname, String email, Integer cityId) {
        this(null, name, surname, email, cityId);
    }
}