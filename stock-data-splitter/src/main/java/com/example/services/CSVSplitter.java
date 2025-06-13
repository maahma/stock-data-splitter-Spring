package com.example.services;
import org.springframework.stereotype.*;
import java.io.*;
import com.opencsv.*;
import java.util.*;
import java.nio.file.*;
import com.example.model.BranchRecord;

@Service
public class CSVSplitter{

    public void splitCsv(List<BranchRecord> branchRecords){

        

//         List<String> header = branchRecords.get(0);
//         String currentBranch = "";
//         List<List<String>> branchRows = new ArrayList<>();

//         for (int i = 1; i < branchRecords.size(); i++){
//             List<String> row = branchRecords.get(i);
//             String branchName = row.get(0);
//             if (!branchName.equals(currentBranch)){
//                 if (!branchRows.isEmpty()){
//                     writeCsv(header, branchRows);
//                     branchRows.clear();
//                 }
//                 currentBranch = branchName;
//             }
//             branchRows.add(row);
//         }

//         if (!branchRows.isEmpty()) {
//             writeCsv(header, branchRows);
//         }     
         
    }
}