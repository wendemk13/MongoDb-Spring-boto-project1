package com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses;

import com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses.dto.CourseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Courses getCoursesById(String id) {
        coursesRepository.findById(id);
        return null;
    }

    @Override
    public void updateCourses(Courses courses) {
        coursesRepository.save(courses);
    }
@Override
    public List<CourseResponseDTO> getAllCoursesDTO() {
        List<Courses> courses=coursesRepository.findAll();
    return courses.stream()
            .map(course -> new CourseResponseDTO(
                    course.getTitle(),
                    course.getDescription(),
                    course.getCategory()
            ))
            .collect(Collectors.toList());

}

    @Override
    public CourseResponseDTO getCourseTitleDesc(String courseId) {
//        Optional<Courses> coursesOptional=coursesRepository.findById(courseId);
//        if(coursesOptional.isPresent()){
//           Courses courses=coursesOptional.get();
//           return new CourseResponseDTO(courses.getTitle(),courses.getDescription());
//        }
//        else {
//            // You can throw an exception, or return null
//            throw new RuntimeException("Course not found with id: " + courseId);
//        }
        return coursesRepository.findById(courseId)
                .map(course -> new CourseResponseDTO(course.getTitle(), course.getDescription()))
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));

    }

}
