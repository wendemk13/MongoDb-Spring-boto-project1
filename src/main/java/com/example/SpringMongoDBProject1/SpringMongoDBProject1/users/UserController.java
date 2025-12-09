package com.example.SpringMongoDBProject1.SpringMongoDBProject1.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController{
    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAll()
    {
        return new ResponseEntity<>(usersService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserByID(@PathVariable String id){
        return new  ResponseEntity<>(usersService.getUserByID(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Users> createUser(@RequestBody Users user){
        Users useradded=usersService.addUser(user);
        return new ResponseEntity<>(useradded,HttpStatus.CREATED);
    }

    @PutMapping("/users")
    public ResponseEntity<Users> updateUser(@RequestBody Users user){
        usersService.updateUser(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        usersService.deleteByID(id);
        return new ResponseEntity<>("User Deleted with id : "+id,HttpStatus.OK);
    }
}
