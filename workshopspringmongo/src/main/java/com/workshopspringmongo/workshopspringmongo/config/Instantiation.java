package com.workshopspringmongo.workshopspringmongo.config;

import com.workshopspringmongo.workshopspringmongo.domain.Post;
import com.workshopspringmongo.workshopspringmongo.domain.User;
import com.workshopspringmongo.workshopspringmongo.repository.PostRepository;
import com.workshopspringmongo.workshopspringmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "Kaique Oliveira", "kaique@gmail.com");
        User user2 = new User(null, "Cristina Oliveira", "cristina@gmail.com");
        User user3 = new User(null, "Paola Oliveira", "paola@gmail.com");

        Post post1 = new Post(null, "Vou jogar forza horizon no Xbox One Series S!", "Partiu game", simpleDateFormat.parse("22/05/2021"), user1);
        Post post2 = new Post(null, "Vamos comer picanha?", "Partiu !!", simpleDateFormat.parse("22/05/2021"), user2);

        postRepository.saveAll(Arrays.asList(post1, post2));
        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
