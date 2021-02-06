package com.zain.jo.webtoken;

import com.zain.jo.webtoken.domain.User;
import com.zain.jo.webtoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@SpringBootApplication
public class WebtokenApplication {

    private final UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101L, "javatechie", "password", "javatechie@gmail.com"),
                new User(102L, "user1", "pwd1", "user1@gmail.com"),
                new User(103L, "user2", "pwd2", "user2@gmail.com"),
                new User(104L, "user3", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebtokenApplication.class, args);
    }

}
