package com.practice.MongoDB.repository;

import com.practice.MongoDB.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends MongoRepository<Student,String> {

    List<Student> findByName(String name);

    List<Student> findByNameAndEmailId(String name, String emailId);

    List<Student> findByNameOrEmailId(String name, String emailId);

    List<Student> findByDepartmentDepartmentName(String departmentName);

    List<Student> findBySubjectsSubjectName(String subjectName);

    List<Student> findByEmailIdIsLike(String emailId);

    List<Student> findByNameStartsWith(String name);

    List<Student> findByDepartmentId(String deptId);

    @Query("{ \"name\" : \"?0\" }")
    List<Student> getByName(String name);
}
