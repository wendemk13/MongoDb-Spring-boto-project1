package com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses;

import com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses.dto.CourseResponseDTO;

import java.util.List;

public interface CoursesServices {
    List<Courses> getAllCourses();
    void deleteCoursesById(String id);
    Courses saveCourses(Courses courses);
    Courses getCoursesById(String id);
    void updateCourses(Courses courses);
    List<CourseResponseDTO> getAllCoursesDTO();
    CourseResponseDTO getCourseTitleDesc(String courseId);

}
