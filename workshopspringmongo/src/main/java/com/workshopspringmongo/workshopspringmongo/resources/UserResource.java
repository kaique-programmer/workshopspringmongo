package com.workshopspringmongo.workshopspringmongo.resources;

import com.workshopspringmongo.workshopspringmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User kaique = new User("1", "Kaique oliveira", "kaique@gmail.com");
        User alex = new User("2", "Alex oliveira", "alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(kaique, alex));
        return ResponseEntity.ok().body(list);
    }
}
