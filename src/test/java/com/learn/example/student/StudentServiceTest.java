package com.learn.example.student;

import jakarta.validation.constraints.NotEmpty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    public void should_successfully_save_a_student(){

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

        verify(studentMapper,times(1)).toStudent(dto);
        verify(repository,times(1)).save(student);
        verify(studentMapper,times(1)).toStudentResponseDto(savedStudent);

    }

    @Test
    public void should_return_all_students(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "john",
                "doe",
                "humpasp@gmail.com",
                20
        ));

        when(repository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "john",
                        "doe",
                        "humpasp@gmail.com"
                ));


        List<StudentResponseDto> responseDtos = studentService.findAllStudent();

        assertEquals(students.size(),responseDtos.size());
        verify(repository,times(1)).findAll();
    }

    @Test
    public  void should_return_student_by_id(){
        Integer studentId = 1;
        Student student = new Student(
                "john",
                "doe",
                "humpasp@gmail.com",
                20
        );
        when(repository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "john",
                        "doe",
                        "humpasp@gmail.com"
                ));

        StudentResponseDto dto = studentService.findStudentById(studentId);

        assertEquals(dto.firstname(),student.getFirstname());
        assertEquals(dto.lastname(),student.getLastname());
        assertEquals(dto.email(),student.getEmail());

        verify(repository,times(1)).findById(studentId);




    }
    @Test
    public  void should_return_student_by_name(){
        String studentName = "john";
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "john",
                "doe",
                "humpasp@gmail.com",
                20
        ));

        when(repository.findAllByFirstnameContaining(studentName)).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "john",
                        "doe",
                        "humpasp@gmail.com"
                ));


        var  responseDto  = studentService.findStudentsByName(studentName);

        assertEquals(students.size(),responseDto.size());
        verify(repository,times(1)).findAllByFirstnameContaining(studentName);

    }

}