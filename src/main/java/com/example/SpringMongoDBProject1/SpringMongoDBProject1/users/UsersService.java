package com.example.SpringMongoDBProject1.SpringMongoDBProject1.users;

import org.apache.catalina.User;

import java.util.List;

public interface UsersService {

//    get by id
    public User getUserByID(String id);
//    get all
    public List<User> getAll();
//    delete by id
    public void deleteByID(String id);
//    add new user
    public User addUser(User user);
//    update user by id
    public User updateUser(User user);

}
