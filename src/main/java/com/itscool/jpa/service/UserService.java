package com.itscool.jpa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itscool.jpa.dtos.CreateUserDto;
import com.itscool.jpa.models.User;
import com.itscool.jpa.repositories.UserJpaRepository;
import com.itscool.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserJpaRepository jpaRepository;
    @Autowired
    private ObjectMapper mapper;


    public Iterable<User> saveAll(List<User> users){
        return repository.saveAll(users);
    }

    public Iterable<User> findAllUsers(){
        return repository.findAll();
    }

    public void deleteUsers(Long id ){
        repository.deleteById(id);
    }
    public Optional<User> findUserByUsername(String username) {
        return jpaRepository.findByUsername(username);
    }

    public User addUser(User user){
//        user.getOrders().fromEach(o-> o.setUser(savedUser));
//        Save user
        return jpaRepository.save(user);
    }
    public User createUserFromDto(CreateUserDto userDto){
//        User u = new User();
//        u.setName(userDto.getName());
        User user = mapper.convertValue(userDto, User.class);
        return jpaRepository.save(user);
    }

}
