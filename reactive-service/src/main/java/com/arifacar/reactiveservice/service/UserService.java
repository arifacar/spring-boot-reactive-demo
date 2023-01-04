package com.arifacar.reactiveservice.service;

import com.arifacar.reactivedomain.domain.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Random;

@Service
public class UserService {

    public Mono<User> getUserById(int id) {
        return Mono.just(new User(id, "Arif Acar", new Random().nextInt(20) + 20));
    }

}
