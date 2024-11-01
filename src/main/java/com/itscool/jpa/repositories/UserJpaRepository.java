package com.itscool.jpa.repositories;

import com.itscool.jpa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);


    List<User> findByActive(boolean active);

    // ia tori useri ordonati dupa user name ascedent
    List<User> findAllByOrderByUserNameAsc();

    // ia dupa activitatea userilor descedenti
    List<User> findByActiveOrderByUsernameDesc(boolean active);

    List<User> findByRegistrationDateBetween(LocalDate start, LocalDate end);

    List<User> findByNameIgnoreCase(String name);

    List<User> findByAgeGreaterThanEqual(int age);

    List<User> findByUsernameContaining(String text);

    List<User> findByUsernameStartingWith(String text);

    @Query("SELECT u FROM User u where u.age > 30")
    List<User> findUsersOver30();

    @Query(value = "select u from users u where u.age > 30 ", nativeQuery = true)
    List<User> findUserOver30NativeQuery();
}
