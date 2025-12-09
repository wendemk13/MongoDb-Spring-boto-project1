package com.example.SpringMongoDBProject1.SpringMongoDBProject1.courses;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;

@Collation
public class Courses {
    @Id
    private String id;
    private String title;
    private String description;
    private String category;

    private Courses(){};
    public Courses( String title, String description, String category) {
        this.title = title;
        this.description = description;
        this.category = category;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
