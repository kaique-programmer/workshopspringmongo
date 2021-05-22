package com.workshopspringmongo.workshopspringmongo.services;

import com.workshopspringmongo.workshopspringmongo.domain.User;
import com.workshopspringmongo.workshopspringmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
