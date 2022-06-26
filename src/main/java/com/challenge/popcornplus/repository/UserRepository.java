package com.challenge.popcornplus.repository;

import com.challenge.popcornplus.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
