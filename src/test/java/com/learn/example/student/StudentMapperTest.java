package com.learn.example.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    @BeforeEach
    void setUp() {
        System.out.println("Before the first test method");

    }

    @AfterEach
    void tearDown() {
        System.out.println("Inside the after each method");

    }

    @Test
    public void testMethod1(){
        System.out.println("My first test");
    }

}