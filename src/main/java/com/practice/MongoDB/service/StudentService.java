package com.practice.MongoDB.service;

import com.practice.MongoDB.entity.Student;
import com.practice.MongoDB.repository.DepartmentRepository;
import com.practice.MongoDB.repository.StudentRepository;
import com.practice.MongoDB.repository.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class StudentService {

    private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public Student createStudent(Student student) {
        LOG.info("Creating new student: {}",student);
        if (!isNull(student.getDepartment())) {
            departmentRepository.save(student.getDepartment());
        }
        if (!isNull(student.getSubjects()) && !student.getSubjects().isEmpty()) {
            subjectRepository.saveAll(student.getSubjects());
        }
        return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        Boolean studentPresent = studentRepository.findById(id).isPresent();
        if (!studentPresent) {
            LOG.info("No such student present with id: {}",id);
            return null;
        }
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        LOG.info("Updating student with id: {}",student.getId());
        return studentRepository.save(student);
    }

    public String deleteStudent(String id) {
        Boolean studentPresent = studentRepository.findById(id).isPresent();
        if (studentPresent) {
            studentRepository.deleteById(id);
            return "Student has been deleted";
        }
        return "No student present with this id";
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.getByName(name);
    }

    public List<Student> getStudentsByNameAndEmail(String name, String emailId) {
        return studentRepository.findByNameAndEmailId(name,emailId);
    }

    public List<Student> getStudentsByNameOrEmail(String name, String emailId) {
        return studentRepository.findByNameOrEmailId(name,emailId);
    }

    public List<Student> getAllWithPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC,"name","emailId");
        return studentRepository.findAll(sort);
    }

    public List<Student> byDepartmentName(String deptName) {
        return studentRepository.findByDepartmentDepartmentName(deptName);
    }

    public List<Student> bySubjectName(String subjectName) {
        return studentRepository.findBySubjectsSubjectName(subjectName);
    }

    public List<Student> emailIdLike(String emailId) {
        return studentRepository.findByEmailIdIsLike(emailId);
    }

    public List<Student> nameStartsWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> byDepartmentId(String deptId) {
        return studentRepository.findByDepartmentId(deptId);
    }
}
