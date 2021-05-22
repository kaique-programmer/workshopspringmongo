package com.workshopspringmongo.workshopspringmongo.resources;

import com.workshopspringmongo.workshopspringmongo.domain.User;
import com.workshopspringmongo.workshopspringmongo.dto.UserDTO;
import com.workshopspringmongo.workshopspringmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    // these methods make it possible to do crud operations via routes

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
       User user = userService.fromDTO(userDTO);
       user = userService.insert(user);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
       return ResponseEntity.created(uri).build();
    }
}
