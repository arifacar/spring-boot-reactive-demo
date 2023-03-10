package com.arifacar.reactiveservice.service;

import com.arifacar.reactivedomain.domain.User;
import com.arifacar.reactivedomain.repository.UserRepository;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public final class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ReactiveMongoTemplate template;

    public UserServiceImpl(UserRepository userRepository, ReactiveMongoTemplate template) {
        this.userRepository = userRepository;
        this.template = template;
    }

    @Override
    public Mono<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Flux<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> saveUser(User userDTO) {
        return userRepository.save(userDTO);
    }

    @Override
    public Mono<User> updateUser(String id, User userDTO) {
        return userRepository.findById(id).flatMap(user -> userRepository.save(userDTO));
    }

    @Override
    public Mono<Void> deleteUser(String id) {
        return userRepository.deleteById(id);
    }
}