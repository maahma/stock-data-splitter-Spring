// package com.example.services;
// import java.io.*;
// import com.opencsv.*;
// import java.util.*;
// import java.nio.file.*;
// import org.springframework.stereotype.*;

// @Service
// public class CSVWriter {
//     public void writeCsv(List<String> header, List<List<String>> branchRows){
//         try{

//             String branchName = branchRows.get(0).get(0);
//             if (branchName == ""){
//                 branchName = "sample_stock";
//             }
//             Path outputFolder = Paths.get("output_csv");
//             Path outputFile = outputFolder.resolve(branchName + ".csv");
//             FileWriter outputfile = new FileWriter(outputFile.toFile());
//             CSVWriter writer = new CSVWriter(outputfile);
            
//             writer.writeNext(header.toArray(new String[0]));
//             for (List<String> row: branchRows){
//                 writer.writeNext(row.toArray(new String[0]));
//             }
//             writer.close();
//         } catch (IOException e){
//             e.printStackTrace();
//         }
//     } 
// }
