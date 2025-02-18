package com.learn.example;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {



    private final StudentRepository repository;
    private final StudentMapper studentMapper;


    public StudentController(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    @PostMapping("/students")
    public StudentResponseDto post(
            @RequestBody StudentDto dto
    ){
        var student = studentMapper.toStudent(dto);
       var savedStudent =  repository.save(student);
       return  studentMapper.toStudentResponseDto(savedStudent);
    }


    @GetMapping("/students-all")
    public List<Student> findAllStudent(){
        return  repository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(
            @PathVariable("student-id") Integer id
    ){
        return  repository.findById(id).orElse(null);
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentsByName(
            @PathVariable("student-name") String name
    ){
        return  repository.findAllByFirstnameContaining(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public  void delete(
            @PathVariable("student-id") Integer id

    )
    {
        repository.deleteById(id);

    }

}
