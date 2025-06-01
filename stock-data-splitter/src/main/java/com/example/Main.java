package com.example;
import org.springframework.context.annotation.*;
import com.example.services.*;
import com.example.config.*;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    
        
    }
}