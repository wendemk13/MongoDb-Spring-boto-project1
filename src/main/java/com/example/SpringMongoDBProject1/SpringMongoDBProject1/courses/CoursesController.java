package com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses;

import com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses.dto.CourseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
public ResponseEntity<Courses> getCoursesById(@PathVariable String id) {
    Courses course = coursesServices.getCoursesById(id);

    if (course == null) {
        return ResponseEntity.notFound().build(); // 404 if not found
    }

    return ResponseEntity.ok(course);
}

    @GetMapping("/courseshate/{id}")
    public CourseResource getCourseHateById(@PathVariable String id) {
        // Fetch course from service
        Courses course = coursesServices.getCoursesById(id);

        // Handle not found
        if (course == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Course not found with id " + id
            );
        }

        // Map to HATEOAS resource
        CourseResource resource = new CourseResource(
                course.getTitle(),
                course.getDescription(),
                course.getCategory()
        );
//        additional datas
        resource.additional_data="Additional data added...";

        // Add HATEOAS links
        resource.add(linkTo(methodOn(CoursesController.class).getCoursesById(id)).withSelfRel());
        resource.add(linkTo(methodOn(CoursesController.class).getCourses()).withRel("allCourses"));
        resource.add(linkTo(methodOn(CoursesController.class).deleteCourse(id)).withRel("delete course"));
        resource.add(linkTo(methodOn(CoursesController.class).updateCourses(course)).withRel("updateCourses"));

        return resource;
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
    public ResponseEntity<Void> deleteCourse(@PathVariable String id){
        coursesServices.deleteCoursesById(id);
        return ResponseEntity.noContent().build();
    }
//    Update Course
    @PutMapping("/courses")
public   ResponseEntity<Void> updateCourses(@RequestBody Courses course)
{coursesServices.updateCourses(course);
     return  ResponseEntity.noContent().build();

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
