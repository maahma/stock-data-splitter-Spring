package com.example.services;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.example.model.BranchRecord;

@Service
public class FileProcessor {
    
    @Autowired
    private CSVReader csvReader;

    @Autowired
    private CSVWriterService csvWriter;

    @Autowired
    private CSVSplitter csvSplitter;

    public void processCsvFile(Path filePath){
        // Read CSV
        List<BranchRecord> allRecords = csvReader.readCsv(filePath);

        // Split CSV
        Map<String, List<BranchRecord>> splitRecords = csvSplitter.splitCsv(allRecords);

        // Write to CSV 
        csvWriter.writeCsv(splitRecords);
    }
}
