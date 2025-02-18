package com.learn.example;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {



    public final StudentRepository repository;
    public final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(
            StudentDto dto
    ){
        var student = studentMapper.toStudent(dto);
        var savedStudent =  repository.save(student);
        return  studentMapper.toStudentResponseDto(savedStudent);
    }
    
    public List<Student> findAllStudent(){

        return  repository.findAll();
    }
    
    public Student findStudentById(
            @PathVariable("student-id") Integer id  
    ){
        return  repository.findById(id).orElse(null);
    }

    public List<Student> findStudentsByName(
            @PathVariable("student-name") String name
    ){
        return  repository.findAllByFirstnameContaining(name);
    }

    public  void delete(
            @PathVariable("student-id") Integer id

    )
    {
        repository.deleteById(id);

    }


}
