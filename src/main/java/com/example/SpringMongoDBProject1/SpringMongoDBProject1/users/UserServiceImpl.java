package com.example.SpringMongoDBProject1.SpringMongoDBProject1.users;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UsersService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User getUserByID(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();

    }

    @Override
    public void deleteByID(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        userRepository.save(user);
        return user;
    }
}
