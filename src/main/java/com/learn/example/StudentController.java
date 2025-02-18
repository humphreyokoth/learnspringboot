package com.learn.example;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {



    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/students")
    public StudentResponseDto saveStudent(
            @RequestBody StudentDto dto
    ){
          return  this.studentService.saveStudent(dto);
    }


    @GetMapping("/students-all")
    public List<Student> findAllStudent(){
        return  this.studentService.findAllStudent();
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(
            @PathVariable("student-id") Integer id
    ){
        return  this.studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentsByName(
            @PathVariable("student-name") String name
    ){
        return  this.studentService.findStudentsByName(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public  void delete(
            @PathVariable("student-id") Integer id

    )
    {
          this.studentService.delete(id);

    }

}
