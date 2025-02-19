package com.learn.example.student;

import jakarta.validation.constraints.NotEmpty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository repository;

    @Mock
    private StudentMapper studentMapper;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_succesfully_save_a_student(){

        StudentDto dto = new StudentDto(
                "john",
                "doe",
                "humpasp@gmail.com",
                1
        );

        Student student = new Student(
                "john",
                "doe",
                "humpasp@gmail.com",
                20
        );
        Student savedStudent = new Student(
                "john",
                "doe",
                "humpasp@gmail.com",
                20
        );
        savedStudent.setId(1);


//        Mock the calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(repository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto(
                        "john",
                        "doe",
                        "humpasp@gmail.com"

                ));

        StudentResponseDto responseDto = studentService.saveStudent(dto);

        assertEquals(dto.firstname(),responseDto.firstname());
        assertEquals(dto.lastname(),responseDto.lastname());
        assertEquals(dto.email(),responseDto.email());

    }

}