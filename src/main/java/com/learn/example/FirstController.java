package com.learn.example;


import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {



    private final StudentRepository repository;

    public FirstController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public Student post(
            @RequestBody Student student
    ){
       return  repository.save(student);
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
