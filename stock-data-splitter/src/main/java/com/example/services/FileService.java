package com.example.services;

import java.nio.file.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.*;
import com.example.exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class FileService {
    private static final Logger logger = LogManager.getLogger(FileService.class);

    public Reader getCsvReader(Path path) throws FileServiceException{
        try {
            logger.info("Loading the CSV file from path: {}", path.toAbsolutePath());
            return Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            throw new FileServiceException("Could not open the input CSV file", e);
        }
    }
}
