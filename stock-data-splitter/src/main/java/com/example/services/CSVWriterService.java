package com.example.services;
import java.io.*;
import com.opencsv.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.util.*;
import java.util.logging.Logger;
import java.nio.file.*;
import org.springframework.stereotype.*;
import com.example.model.*;

@Service
public class CSVWriterService {

    private static final Logger logger = Logger.getLogger(CSVReader.class.getName());

    public void writeCsv(Map<String, List<BranchRecord>> groupedRecords){

        for (Map.Entry<String, List<BranchRecord>> branch : groupedRecords.entrySet()){
            String branchName = branch.getKey();
            List<BranchRecord> row = branch.getValue();

            if (branchName  == null) {
                branchName = "sample_stock";
            }

            Path outputFile = Paths.get("output_csv", branchName.toLowerCase() + ".csv");
            logger.info("Storing records for branch: " + branchName + " in file: " + outputFile);

            ColumnPositionMappingStrategy<BranchRecord> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(BranchRecord.class);
            String[] headerColumns = {
                "branch", 
                "nscModelCodeCalc", 
                "colour", 
                "confirmedLateDate", 
                "currentNode", 
                "dealerCode", 
                "dealerName", 
                "finalDeliveryDealerAddr", 
                "finalDeliveryDealerCode", 
                "financialOwnerCategory", 
                "holdDamage", 
                "modelGroup", 
                "modelGroupCode", 
                "modelvariant", 
                "nsccode", 
                "nscLocalVehicleCode", 
                "numberOfRecords", 
                "plannedOfflineDate", 
                "revisedLateDate", 
                "secondaryfleetcode", 
                "engine", 
                "transmission", 
                "wheelDrive", 
                "transDate", 
                "vehOrderClassCode", 
                "vehOrderClassTypeCode", 
                "vehicleScrapDate", 
                "vin", 
                "latestAchievementPoint", 
                "prodnYyyymm", 
                "orderNumber", 
                "dateAvailable", 
                "dateDelivered", 
                "revisedDeliveryDate", 
                "latestAchievementPointDate", 
                "buyerCode"
            };

            strategy.setColumnMapping(headerColumns);

            try (
                Writer fileWriter = new FileWriter(outputFile.toString());
                CSVWriter headerWriter = new CSVWriter(fileWriter)
            ) {
                headerWriter.writeNext(headerColumns, false);

                StatefulBeanToCsv<BranchRecord> sbc = new StatefulBeanToCsvBuilder<BranchRecord>(fileWriter)
                .withMappingStrategy(strategy)
                .withQuotechar(com.opencsv.CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(com.opencsv.CSVWriter.DEFAULT_SEPARATOR)
                .build();

                    sbc.write(row);
            
                } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
