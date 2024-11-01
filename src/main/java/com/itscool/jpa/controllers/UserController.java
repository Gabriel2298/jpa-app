package com.itscool.jpa.controllers;


import com.itscool.jpa.dtos.CreateUserDto;
import com.itscool.jpa.models.User;
import com.itscool.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/all")
    public ResponseEntity<Iterable<User>> createUsers(@RequestBody List<User> users){
        Iterable<User> createUsers = service.saveAll(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUsers);
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers(){
        Iterable<User> users = service.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable  long id){
        service.deleteUsers(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username ){
        Optional<User> user = service.findUserByUsername(username);
        if (user.isPresent()){
            return ResponseEntity.ok(user.get());
        }else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user ){
    User savedUser = service.addUser(user);
    return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/create-from-dto")
    public ResponseEntity<User> createUserFromDto(@RequestBody CreateUserDto userDto){
        User user = service.createUserFromDto(userDto);
        return ResponseEntity.ok(user);
    }
}
