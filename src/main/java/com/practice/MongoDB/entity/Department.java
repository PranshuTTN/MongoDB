package com.practice.MongoDB.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "department")
public class Department {

    @Id
    private String id;

    @Field(name = "department_name")
    private String departmentName;

    private String location;

    public String getId() {
        return id;
    }

    public Department setId(String id) {
        this.id = id;
        return this;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Department setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Department setLocation(String location) {
        this.location = location;
        return this;
    }
}
