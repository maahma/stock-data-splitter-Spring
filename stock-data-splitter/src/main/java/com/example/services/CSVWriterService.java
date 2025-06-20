package com.example.services;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import static com.example.constants.CSVConstants.DEFAULT_BRANCH;
import static com.example.constants.CSVConstants.HEADER_COLUMNS;
import com.example.exception.*;
import com.example.model.BranchRecord;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

@Service
public class CSVWriterService {

    private static final Logger logger = LogManager.getLogger(CSVWriterService.class);

    public void writeCsv(Map<String, List<BranchRecord>> groupedRecords) throws CsvWriteException {

        for (Map.Entry<String, List<BranchRecord>> branch : groupedRecords.entrySet()) {
            String key = branch.getKey();
            String branchName = (key == null || key.isEmpty()) ? DEFAULT_BRANCH : key;
            List<BranchRecord> row = branch.getValue();

            Path outputFile = Paths.get("output_csv", branchName.toLowerCase() + ".csv");

            try {

                // add the header first
                try (Writer headerWriter = new FileWriter(outputFile.toFile())) {
                    CSVWriter csvWriter = new CSVWriter(headerWriter);
                    csvWriter.writeNext(HEADER_COLUMNS, false);
                }

                //  and then append the records
                // some records would not be stored if we use the same FileWriter for both header and records
                try (Writer fileWriter = new FileWriter(outputFile.toFile(), true)) {
                    ColumnPositionMappingStrategy<BranchRecord> strategy = new ColumnPositionMappingStrategy<>();
                    strategy.setType(BranchRecord.class);
                    strategy.setColumnMapping(HEADER_COLUMNS);

                    StatefulBeanToCsv<BranchRecord> sbc = new StatefulBeanToCsvBuilder<BranchRecord>(fileWriter)
                        .withMappingStrategy(strategy)
                        .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                        .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                        .build();

                    sbc.write(row);
                }

                logger.info("Stored {} records for branch: {} in file: {}", row.size(), branchName, outputFile);

            } catch (Exception e) {
                logger.error("Error writing CSV for branch: {}", branchName, e);
                throw new CsvWriteException("Failed to write CSV for branch: " + branchName, e);
            }
        }
    }
}