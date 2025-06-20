package com.example;
import java.nio.file.Paths;
import org.springframework.context.annotation.*;
import com.example.services.*;
import com.example.config.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        
        FileProcessor fileProcessor = context.getBean(FileProcessor.class);
        fileProcessor.processCsvFile(Paths.get("ecom-inventory.csv"));
    }
}
