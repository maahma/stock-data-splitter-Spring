package com.example;
import java.nio.file.Paths;
import org.springframework.context.annotation.*;
import com.example.services.*;
import com.example.config.*;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        
        FileProcessor service = context.getBean(FileProcessor.class);
        service.processCsvFile(Paths.get("ecom-inventory.csv"));
    }
}
