package com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoursesRepository extends MongoRepository<Courses, String> {
}
