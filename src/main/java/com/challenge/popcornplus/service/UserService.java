package com.challenge.popcornplus.service;

import com.challenge.popcornplus.entities.User;
import com.challenge.popcornplus.repository.UserRepository;
import com.challenge.popcornplus.service.exceptions.DataBaseException;
import com.challenge.popcornplus.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }

    public void delete(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }

    }

    public User insert(User u) {
        return userRepository.save(u);
    }
}
