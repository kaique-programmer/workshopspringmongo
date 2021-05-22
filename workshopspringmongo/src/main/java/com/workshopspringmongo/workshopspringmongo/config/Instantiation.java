package com.workshopspringmongo.workshopspringmongo.config;

import com.workshopspringmongo.workshopspringmongo.domain.User;
import com.workshopspringmongo.workshopspringmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User user1 = new User(null, "Kaique Oliveira", "kaique@gmail.com");
        User user2 = new User(null, "Cristina Oliveira", "cristina@gmail.com");
        User user3 = new User(null, "Paola Oliveira", "paola@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
