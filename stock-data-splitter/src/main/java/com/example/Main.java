package com.example;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.context.annotation.*;
import com.example.services.*;
import com.example.config.*;
import com.example.model.BranchRecord;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    
        // FileSplitService service = context.getBean(FileSplitService.class);
        // service.readCsv("ecom-inventory.csv");
        

        CSVReader service = context.getBean(CSVReader.class);
        List<BranchRecord> records = service.readCsv(Paths.get("dummy.csv"));
        
        
    }
}