package com.workshopspringmongo.workshopspringmongo.repository;

import com.workshopspringmongo.workshopspringmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
