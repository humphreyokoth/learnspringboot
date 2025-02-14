package com.learn.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    @Autowired
    @Qualifier("mySecondBean")
    private  MyFirstClass myFirstClass;

//
//    public MyFirstService(MyFirstClass myFirstClass){
//        this.myFirstClass = myFirstClass;
//    }



    public String tellAStory(){
      return  "the dependency is saying:"+ myFirstClass.sayHello();
    }



}
