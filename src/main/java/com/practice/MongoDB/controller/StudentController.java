package com.practice.MongoDB.controller;

import com.practice.MongoDB.entity.Student;
import com.practice.MongoDB.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/studentsByName/{name}")
    public List<Student> studentsByName(@PathVariable String name) {
        return studentService.getStudentsByName(name);
    }

    @GetMapping("/studentsByNameAndEmail")
    public List<Student> studentsByNameAndEmail(@RequestParam String name, @RequestParam String emailId) {
        return studentService.getStudentsByNameAndEmail(name,emailId);
    }

    @GetMapping("/studentsByNameOrEmail")
    public List<Student> studentsByNameOrEmail(@RequestParam String name, @RequestParam String emailId) {
        return studentService.getStudentsByNameOrEmail(name,emailId);
    }

    @GetMapping("/allWithPagination")
    public List<Student> getAllWithPagination(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return studentService.getAllWithPagination(pageNumber,pageSize);
    }

    @GetMapping("/allWithSorting")
    public List<Student> getAllWithSorting() {
        return studentService.getAllWithSorting();
    }

    @GetMapping("/byDepartmentName")
    public List<Student> byDepartmentName(@RequestParam String deptName) {
        return studentService.byDepartmentName(deptName);
    }

    @GetMapping("/bySubjectName")
    public List<Student> bySubjectName(@RequestParam String subName) {
        return studentService.bySubjectName(subName);
    }

    @GetMapping("/emailIdLike")
    public List<Student> emailIdLike(@RequestParam String emailId) {
        return studentService.emailIdLike(emailId);
    }

    @GetMapping("/nameStartsWith")
    public List<Student> nameStartsWith(@RequestParam String name) {
        return studentService.nameStartsWith(name);
    }

    @GetMapping("/byDepartmentId")
    public List<Student> byDepartmentId(@RequestParam String deptId) {
        return studentService.byDepartmentId(deptId);
    }
}
