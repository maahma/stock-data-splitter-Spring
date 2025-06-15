package com.example.services;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import com.example.model.BranchRecord;

@Service
public class CSVSplitter{
    private static final Logger logger = Logger.getLogger(CSVReader.class.getName());

    public Map<String, List<BranchRecord>> splitCsv(List<BranchRecord> branchRecords){

        logger.info("Starting to split CSV by branch name");

        Map<String, List<BranchRecord>> groupedBranch = branchRecords.stream().collect(Collectors.groupingBy(BranchRecord::getBranch));

        return groupedBranch;
    }
}