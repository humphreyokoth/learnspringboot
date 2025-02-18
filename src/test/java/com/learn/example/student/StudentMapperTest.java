package com.learn.example.student;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentMapperTest {

   private  StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();

    }

    @Test
   public void shouldMapStudentDtoToStudent(){
    StudentDto dto = new StudentDto(
            "john",
        "doe",
        "humpasp@gmail.com",
        1);
    Student student = mapper.toStudent(dto);

        assertEquals(dto.firstname(),student.getFirstname());
        assertEquals(dto.lastname(),student.getLastname());
        assertEquals(dto.email(),student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(),student.getSchool().getId());




    }


}