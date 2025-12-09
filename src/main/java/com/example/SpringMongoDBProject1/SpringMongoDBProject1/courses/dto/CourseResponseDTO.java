package com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseResponseDTO {

    private String title;
    private String description;
    private String category;

    //    couse response with title and description
    public CourseResponseDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }
//    course response with out id
    public CourseResponseDTO(String title, String description, String category) {
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
