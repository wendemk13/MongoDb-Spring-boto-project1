package com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {
    @Autowired
    CoursesRepository coursesRepository;

//    Get all
    @GetMapping("/courses")
    public List<Courses> getCourses()
    {
        return coursesRepository.findAll();
    }
//    Get by id
    @GetMapping("/courses/{id}")
    public Courses getCoursesById(@PathVariable String id)
    {
        return coursesRepository.findById(id).get();
    }
//    Add Courses
    @PostMapping("/courses")
    public  Courses addCourses(@RequestBody Courses course)
    {
        Courses addedCourse=coursesRepository.save(course);
        return addedCourse;
    }
//    Delete Course
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        coursesRepository.deleteById(id);
    }
//    Update Course
    @PutMapping("/courses")
public   Courses updateCourses(@RequestBody Courses course)
{
    Courses updatedCourse=coursesRepository.save(course);
    return updatedCourse;
}

}
