package com.workshopspringmongo.workshopspringmongo.resources;

import com.workshopspringmongo.workshopspringmongo.domain.Post;
import com.workshopspringmongo.workshopspringmongo.domain.User;
import com.workshopspringmongo.workshopspringmongo.dto.UserDTO;
import com.workshopspringmongo.workshopspringmongo.services.PostService;
import com.workshopspringmongo.workshopspringmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    // these methods make it possible to do crud operations via routes

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

}
