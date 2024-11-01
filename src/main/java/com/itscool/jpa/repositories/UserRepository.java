package com.itscool.jpa.repositories;

import com.itscool.jpa.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>  {

}
