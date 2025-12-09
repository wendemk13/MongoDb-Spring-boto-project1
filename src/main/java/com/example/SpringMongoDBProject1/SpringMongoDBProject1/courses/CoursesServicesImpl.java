package com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServicesImpl implements CoursesServices {

    @Autowired
    private CoursesRepository coursesRepository;
    @Override
    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public void deleteCoursesById(String id) {
        coursesRepository.deleteById(id);

    }

    @Override
    public Courses saveCourses(Courses courses) {
        coursesRepository.save(courses);
        return null;
    }

    @Override
    public Courses findCoursesById(String id) {
        coursesRepository.findById(id);
        return null;
    }

    @Override
    public void updateCourses(Courses courses) {
        coursesRepository.save(courses);
    }
}
