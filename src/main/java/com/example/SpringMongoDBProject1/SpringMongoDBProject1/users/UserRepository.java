package com.example.SpringMongoDBProject1.SpringMongoDBProject1.users;

import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
