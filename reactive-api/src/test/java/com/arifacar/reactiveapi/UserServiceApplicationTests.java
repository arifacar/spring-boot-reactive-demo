package com.arifacar.reactiveapi;

import com.arifacar.reactivedomain.domain.User;
import com.arifacar.reactivedomain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = ReactiveApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"job.autorun.enabled=false"})
class UserServiceApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void api_v1_user_list_test() {
        List<User> userList = Arrays.asList(
                new User("Arif", "Acar", "arifacar@test.com", 44),
                new User("Birol", "Bilgili", "birolbilgili2@test.com", 52),
                new User("Mesut", "Yıldız", "mesutyildiz@test.com", 52)
        );

        Flux<User> flux = Flux.fromIterable(userList);
        when(userRepository.findAll()).thenReturn(flux);

        webTestClient.get().uri("api/v1/users")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(User.class)
                .isEqualTo(userList);
    }

    @Test
    public void step_verifier_test(){
        StepVerifier
                .withVirtualTime(() -> Flux.interval(Duration.ofSeconds(1)).take(2))
                .expectSubscription()
                .expectNoEvent(Duration.ofSeconds(1))
                .expectNext(0L)
                .thenAwait(Duration.ofSeconds(1))
                .expectNext(1L)
                .verifyComplete();
    }

}
