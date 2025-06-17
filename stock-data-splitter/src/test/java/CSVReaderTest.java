import com.example.model.BranchRecord;
import org.junit.jupiter.api.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import com.example.services.*;

import static org.junit.jupiter.api.Assertions.*;
public class CSVReaderTest {
    private CSVReader csvReader;

    // runs before each test
    // creates a new CSVReader and ensures a clean state
    @BeforeEach
    void setup() {
        csvReader = new CSVReader();
    }

    // test behaviour when it finds a CSV file
    @Test
    void testReadCsv_Success() {
        // loads a real test CSV file
        Path testFile = Paths.get("src/test/java/test_inventory.csv");

        List<BranchRecord> records = csvReader.readCsv(testFile);

        // checks if it returns non empty records
        assertFalse(records.isEmpty(), "CSV records should not be empty");

        // also checks that the first record branch is Italy
        assertEquals("Italy", records.get(0).getBranch()); 
    }

    // test behaviour when the CSV file doesn't exist
    @Test
    void testReadCsv_FileNotFound() {
        Path invalidFile = Paths.get("src/test/java/missing.csv");

        List<BranchRecord> records = csvReader.readCsv(invalidFile);

        //  instead of crashing, it returns an empty list
        assertTrue(records.isEmpty(), "Should return empty list for missing file");
    }
}
