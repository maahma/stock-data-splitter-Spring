import com.example.model.BranchRecord;
import org.junit.jupiter.api.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import com.example.services.*;

import static org.junit.jupiter.api.Assertions.*;
public class CSVReaderTest {
    private CSVReader csvReader;

    @BeforeEach
    void setup() {
        csvReader = new CSVReader();
    }

    @Test
    void testReadCsv_Success() {
        Path testFile = Paths.get("src/test/java/test_inventory.csv");

        List<BranchRecord> records = csvReader.readCsv(testFile);

        assertFalse(records.isEmpty(), "CSV records should not be empty");
        assertEquals("Italy", records.get(0).getBranch()); 
    }

    @Test
    void testReadCsv_FileNotFound() {
        Path invalidFile = Paths.get("src/test/java/missing.csv");

        List<BranchRecord> records = csvReader.readCsv(invalidFile);

        assertTrue(records.isEmpty(), "Should return empty list for missing file");
    }
}
