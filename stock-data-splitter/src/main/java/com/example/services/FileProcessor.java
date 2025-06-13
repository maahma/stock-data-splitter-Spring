package com.example.services;
import org.springframework.stereotype.*;

@Service
public class FileProcessor {
    
    @Autowired
    private CSVReader csvReader;

    @Autowired
    private CSVWriter csvWriter;

    @Autowired
    private CSVSplitter csvSplitter;
}
