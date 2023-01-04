package com.arifacar.reactivedomain.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class UserTest {
    public UserTest() {
    }
    @Test
    public void isRecord_GetterAndSetter_CanApply() {
        String name = "Arif Acar";
        int age = 30;
        User user = new User(1, name, age);
        assertEquals(name, user.name());
    }

}
