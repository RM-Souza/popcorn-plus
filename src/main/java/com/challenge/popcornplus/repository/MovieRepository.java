package com.challenge.popcornplus.repository;

import com.challenge.popcornplus.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
