package com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.RepresentationModel;

public class CourseResource extends RepresentationModel<CourseResource> {

    private String title;
    private String description;
    private String category;
//    extra informaion
    public String additional_data;

    private CourseResource(){};
    public CourseResource( String title, String description, String category) {
        this.title = title;
        this.description = description;
        this.category = category;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
