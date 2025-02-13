package com.learn.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private  MyFirstClass myFirstClass;

    public String tellAStory(){
    return  "the dependency is saying:"+ myFirstClass.sayHello();
    }

    public  function getJavaVersion(){
        return environment.getProperty("java.version");
    }

    @Autowired
    public function setEnvironment(Environment environment){
        this.environment = environment;
    }
}
