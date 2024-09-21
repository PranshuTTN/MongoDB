package com.practice.MongoDB.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static java.util.Objects.isNull;

@Document(collection = "student")
public class Student {

    @Id
    private String id;

    private String name;

    @Field(name = "email")
    private String emailId;

    @DBRef
    private Department department;

    @DBRef
    private List<Subject> subjects;

    @Transient
    private Double  percentage;

    public String getId() {
        return id;
    }

    public Student setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public Student setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public Student setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Student setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
        return this;
    }

    public Double getPercentage() {
        if (!isNull(subjects) && !subjects.isEmpty()) {
            Double total = 0.0;
            for (Subject subject : subjects) {
                total += subject.getMarksObtained();
            }
            return total/subjects.size();
        }
        return 0.0;
    }

    public Student setPercentage(Double percentage) {
        this.percentage = percentage;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", department=" + department +
                ", subjects=" + subjects +
                '}';
    }
}
