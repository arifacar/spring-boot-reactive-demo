package com.arifacar.reactiveservice.conf;

import com.arifacar.reactivedomain.domain.User;
import com.arifacar.reactivedomain.repository.UserRepository;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Flux;

import java.util.concurrent.ThreadLocalRandom;

@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractReactiveMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "users";
    }

    @Override
    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create("mongodb://root:mongopw@localhost:27017");
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }

    @Bean
    @ConditionalOnProperty(prefix = "job.autorun", name = "enabled", havingValue = "true", matchIfMissing = true)
    public CommandLineRunner loadData(UserRepository repository) {
        return (args) -> {
            var users = Flux.just(
                    new User("Arif", "Acar", "arifacar@test.com", 44),
                    new User("Birol", "Bilgili", "birolbilgili2@test.com", 52),
                    new User("Mesut", "Yıldız", "mesutyildiz@test.com", 52)
            );
            repository.saveAll(users).subscribe();
        };
    }
}