package com.learn.example.student;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
