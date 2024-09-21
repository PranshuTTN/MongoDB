package com.practice.MongoDB.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "subject")
public class Subject {

    @Id
    private String id;

    @Field(name = "subject_name")
    private String subjectName;

    @Field(name = "marks_obtained")
    private Long marksObtained;

    public String getId() {
        return id;
    }

    public Subject setId(String id) {
        this.id = id;
        return this;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Subject setSubjectName(String subjectName) {
        this.subjectName = subjectName;
        return this;
    }

    public Long getMarksObtained() {
        return marksObtained;
    }

    public Subject setMarksObtained(Long marksObtained) {
        this.marksObtained = marksObtained;
        return this;
    }
}
