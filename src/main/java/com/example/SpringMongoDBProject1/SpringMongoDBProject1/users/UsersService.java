package com.example.SpringMongoDBProject1.SpringMongoDBProject1.users;



import java.util.List;

public interface UsersService {

//    get by id
    public Users getUserByID(String id);
//    get all
    public List<Users> getAll();
//    delete by id
    public void deleteByID(String id);
//    add new user
    public Users addUser(Users user);
//    update user by id
    public Users updateUser(Users user);




}
