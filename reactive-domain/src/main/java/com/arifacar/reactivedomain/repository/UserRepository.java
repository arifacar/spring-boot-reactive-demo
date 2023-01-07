package com.arifacar.reactivedomain.repository;

import com.arifacar.reactivedomain.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}