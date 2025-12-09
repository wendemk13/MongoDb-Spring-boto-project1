package com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses;

import java.util.List;

public interface CoursesServices {
    List<Courses> getAllCourses();
    void deleteCoursesById(String id);
    Courses saveCourses(Courses courses);
    Courses findCoursesById(String id);
    void updateCourses(Courses courses);

}
