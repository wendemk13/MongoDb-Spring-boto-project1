//package com.example.SpringMongoDBProject1.SpringMongoDBProject1.users;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UsersService{
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public Users getUserByID(String id) {
//        userRepository.findById(id);
//        return null;
//    }
//
//    @Override
//    public List<Users> getAll() {
//        List<Users> all = userRepository.findAll();
//        return all;
//
//
//    }
//
//    @Override
//    public void deleteByID(String id) {
//        userRepository.deleteById(id);
//    }
//
//    @Override
//    public Users addUser(Users user) {
//        Users userAdded=userRepository.save(user);
//        return userAdded;
//    }
//
//    @Override
//    public Users updateUser(Users user) {
//        userRepository.save(user);
//        return user;
//    }
//
//}


package com.example.SpringMongoDBProject1.SpringMongoDBProject1.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users getUserByID(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteByID(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user); // save() acts as update if id exists
    }
}
