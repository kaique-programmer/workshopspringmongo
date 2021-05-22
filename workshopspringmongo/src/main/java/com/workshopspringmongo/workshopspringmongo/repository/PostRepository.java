package com.workshopspringmongo.workshopspringmongo.repository;

import com.workshopspringmongo.workshopspringmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
