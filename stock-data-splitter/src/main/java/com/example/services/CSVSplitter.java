package com.example.services;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.stream.Collectors;
import com.example.model.BranchRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class CSVSplitter{

    private static final Logger logger = LogManager.getLogger(CSVSplitter.class);
    
    // groups a list of BranchRecord objects by branch name
    public Map<String, List<BranchRecord>> splitCsv(List<BranchRecord> branchRecords){

        logger.info("Starting to split CSV by branch name");

        // uses Java Streams to group the records by their branch name
        // the result is a map like this : {"Italy": [...], "Denmark": [...], ...}
        Map<String, List<BranchRecord>> groupedBranch = branchRecords.stream().collect(Collectors.groupingBy(BranchRecord::getBranch));

        return groupedBranch;
    }
}