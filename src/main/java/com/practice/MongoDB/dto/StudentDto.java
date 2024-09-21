package com.practice.MongoDB.dto;

import com.practice.MongoDB.entity.Department;
import com.practice.MongoDB.entity.Subject;

import java.util.List;

public class StudentDto {

    private String name;
    private String emailId;
    private Department department;
    private List<Subject> subjects;

    public String getName() {
        return name;
    }

    public StudentDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public StudentDto setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public StudentDto setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public StudentDto setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
        return this;
    }
}
