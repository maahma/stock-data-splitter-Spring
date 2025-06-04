package com.example.services;
import org.springframework.stereotype.*;
import java.io.*;
import com.opencsv.*;
import java.util.*;
import java.nio.file.*;

@Service
public class FileSplitService{

    public void splitFile(List<List<String>> branchRecords){
        List<String> header = branchRecords.get(0);
        String currentBranch = "";
        List<List<String>> branchRows = new ArrayList<>();

        for (int i = 1; i < branchRecords.size(); i++){
            List<String> row = branchRecords.get(i);
            String branchName = row.get(0);
            if (!branchName.equals(currentBranch)){
                if (!branchRows.isEmpty()){
                    writeCsv(header, branchRows);
                    branchRows.clear();
                }
                currentBranch = branchName;
            }
            branchRows.add(row);
        }

        if (!branchRows.isEmpty()) {
            writeCsv(header, branchRows);
        }     
         
    }

    public void readCsv(String file){
        List<List<String>> allRecords = new ArrayList<>();

        try{
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null){
                List<String> row = Arrays.asList(nextRecord);
                allRecords.add(row);
            }

            splitFile(allRecords);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeCsv(List<String> header, List<List<String>> branchRows){
        try{

            String branchName = branchRows.get(0).get(0);
            if (branchName == ""){
                branchName = "sample_stock";
            }
            Path outputFolder = Paths.get("output_csv");
            Path outputFile = outputFolder.resolve(branchName + ".csv");
            FileWriter outputfile = new FileWriter(outputFile.toFile());
            CSVWriter writer = new CSVWriter(outputfile);
            
            writer.writeNext(header.toArray(new String[0]));
            for (List<String> row: branchRows){
                writer.writeNext(row.toArray(new String[0]));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }   
}