package com.rashed.datajpahrproject.repository;

import com.rashed.datajpahrproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByUsernameContaining(String name);

}
