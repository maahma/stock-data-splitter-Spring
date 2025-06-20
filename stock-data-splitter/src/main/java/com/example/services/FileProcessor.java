package com.example.services;
import java.io.Reader;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.example.model.BranchRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class FileProcessor {
    
    private CSVReader csvReader;
    private CSVWriterService csvWriter;
    private CSVSplitter csvSplitter;
    private FileService fileService;

    private static final Logger logger = LogManager.getLogger(FileProcessor.class);

    @Autowired
    public FileProcessor(CSVReader csvReader, CSVWriterService csvWriter, CSVSplitter csvSplitter, FileService fileService){
        this.csvReader = csvReader;
        this.csvWriter = csvWriter;
        this.csvSplitter = csvSplitter;
        this.fileService = fileService;
    }

    public void processCsvFile(Path path){
        try{
            // Read CSV
            Reader reader = fileService.getCsvReader(path);
            List<BranchRecord> allRecords = csvReader.readCsv(reader);

            // Split CSV
            Map<String, List<BranchRecord>> splitRecords = csvSplitter.splitCsv(allRecords);

            // Write to CSV 
            csvWriter.writeCsv(splitRecords);

        } catch (Exception e){
            System.err.println("Failed to process file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
