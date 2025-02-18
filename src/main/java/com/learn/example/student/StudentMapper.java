package com.learn.example.student;

import com.learn.example.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto){

        if (dto == null){
            throw new NullPointerException("The studentDto should not be null");
        }

        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;
    }
    public StudentResponseDto toStudentResponseDto(Student student){
        return  new StudentResponseDto(student.getFirstname(),
                student.getLastname(),
                student.getEmail());

    }
}
