package com.learn.example;



public class MyFirstClass {

    private String  myVar;

    public MyFirstClass(String myVar){
        this.myVar = myVar;
    }

    public String sayHello(){
        return "Hello from the firstClass ==> myVar="+myVar;
    }
}
