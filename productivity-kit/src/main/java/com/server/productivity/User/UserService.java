package com.server.productivity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
       return this.userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

//    public void delete(User user) {
//         this.userRepository.delete(user);
//    }
//
//    public void delete(User user) {
//        this.userRepository.(user);
//    }



}
