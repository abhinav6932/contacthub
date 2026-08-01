package com.scm.contacthub.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.contacthub.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

    // extra method db related operation
    //custom query method
   // custom finder method

   Optional<User> findByEmail(String email);
} 