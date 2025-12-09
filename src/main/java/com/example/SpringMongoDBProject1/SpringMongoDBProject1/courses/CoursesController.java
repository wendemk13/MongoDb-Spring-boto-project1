package com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses;

import com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses.dto.CourseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoursesController {
    @Autowired
    CoursesServices coursesServices;
//    Get all
    @GetMapping("/courses")
    public List<Courses> getCourses()
    {
        return coursesServices.getAllCourses();
    }
//    Get by id
    @GetMapping("/courses/{id}")
    public Courses getCoursesById(@PathVariable String id)
    {
        return coursesServices.getCoursesById(id);
    }
//    Add Courses
    @PostMapping("/courses")
    public  Courses addCourses(@RequestBody Courses course)
    {
        Courses addedCourse=coursesServices.saveCourses(course);
        return addedCourse;
    }
//    Delete Course
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        coursesServices.deleteCoursesById(id);
    }
//    Update Course
    @PutMapping("/courses")
public   void updateCourses(@RequestBody Courses course)
{
     coursesServices.updateCourses(course);

}

//get all with out id
    @GetMapping("/coursesdto")
    public List<CourseResponseDTO> getAllWithOutID(){
        return coursesServices.getAllCoursesDTO();

    }
//    getCourseTitleDesc
    @GetMapping("/getCourseTitleDesc/{id}")
    public CourseResponseDTO getCourseTitleDesc(@PathVariable String id){
        return coursesServices.getCourseTitleDesc(id);
    }

}
