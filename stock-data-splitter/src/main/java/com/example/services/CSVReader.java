package com.example.services;
import java.io.*;
import com.opencsv.*;
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

        try (Reader reader = Files.newBufferedReader(path)) {

            CsvToBean<BranchRecord> allRecords = new CsvToBeanBuilder<BranchRecord>(reader)
             .withType(BranchRecord.class)
             .build();


            List<BranchRecord> parsedRecords = allRecords.parse();
            logger.info("Successfully parsed CSV. Total records: " + parsedRecords.size());

            return parsedRecords;
        
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList(); 
        }



        // List<List<String>> allRecords = new ArrayList<>();

        // try{
        //     FileReader fileReader = new FileReader(file);
        //     CSVReader csvReader = new CSVReader(fileReader);
        //     String[] nextRecord;

        //     while ((nextRecord = csvReader.readNext()) != null){
        //         List<String> row = Arrays.asList(nextRecord);
        //         allRecords.add(row);
        //     }

        //     splitFile(allRecords);

        // } catch (Exception e){
        //     e.printStackTrace();
        // }
    }
}
