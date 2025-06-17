package com.example.services;
import java.io.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.util.*;
import java.nio.file.*;
import org.springframework.stereotype.*;
import com.example.model.BranchRecord;
import java.util.logging.Logger;

@Service
public class CSVReader {
    private static final Logger logger = Logger.getLogger(CSVReader.class.getName());

    public List<BranchRecord> readCsv(Path path){

        logger.info("Starting to read CSV from path: " + path.toString());

        // It reads a CSV file from the given path, parses it into Java objects of type BranchRecord, and returns a list of those objects.

        try (Reader reader = Files.newBufferedReader(path, java.nio.charset.StandardCharsets.ISO_8859_1)) {

            //  creates the CsvToBean parser object
            CsvToBean<BranchRecord> allRecords = new CsvToBeanBuilder<BranchRecord>(reader)
             .withType(BranchRecord.class)
             .build();


            //  Parses the CsvToBean object 
            List<BranchRecord> parsedRecords = allRecords.parse();
            logger.info("Successfully parsed CSV. Total records: " + parsedRecords.size());

            return parsedRecords;
        
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList(); 
        }
    }
}
