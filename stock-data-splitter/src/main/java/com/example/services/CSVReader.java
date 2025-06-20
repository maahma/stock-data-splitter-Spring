package com.example.services;
import java.io.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.util.*;
import java.nio.file.*;
import org.springframework.stereotype.*;
import com.example.model.BranchRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.exception.*;

@Service
public class CSVReader {

    private static final Logger logger = LogManager.getLogger(CSVReader.class);

    public List<BranchRecord> readCsv(Reader reader) throws CsvReadException{

        // It reads a CSV file from the given path, parses it into Java objects of type BranchRecord, and returns a list of those objects.
        try {
            logger.info("Reading CSV file and parsing it into objects of type BranchRecord");
            //  creates the CsvToBean parser object
            return new CsvToBeanBuilder<BranchRecord>(reader)
             .withType(BranchRecord.class)
             .build()
             .parse();
        } catch(Exception e) {
            throw new CsvReadException("Failed to read CSV", e);
        }
    }
}
