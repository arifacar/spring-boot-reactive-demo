package com.arifacar.reactiveservice.service;

import com.arifacar.reactivedomain.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public sealed interface UserService  permits UserServiceImpl {
    Mono<User> getUserById(String id);

    Flux<User> getUsers();

    Mono<User> saveUser(User userDtoMono);

    Mono<User> updateUser(String id, User userMono);

    Mono<Void> deleteUser(String id);
}