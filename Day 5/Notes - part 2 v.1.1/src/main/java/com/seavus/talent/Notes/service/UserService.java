package com.seavus.talent.Notes.service;

import com.seavus.talent.Notes.model.User;
import com.seavus.talent.Notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String username) {
        userRepository.save(new User(username));
    }

    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public void updateUser(Long id, String username, String password) {
        userRepository.updateById(id, username, password);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
