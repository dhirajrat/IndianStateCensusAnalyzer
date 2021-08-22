import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateCensusAnalyzerTest {
    ReadRecordsOperations readObj = new ReadRecordsOperations();
    String fileName = "IndiaStateCensusData";

    @Test
    public void givenStateCensusCSVFileCorrect_EnsureNumberOfRecordsMatch() throws StateCensosAnalyzerException {
        String filePathRead = "./src/main/resources/IndiaStateCensusData.csv";
        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assert.assertEquals(29, count);
        } catch (StateCensosAnalyzerException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenStateCensusCSVFile_WhenFileNameIncorrectShouldThrowException() {
        String filePathRead = "./src/main/resources/IndiaStateCensusData";

        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assert.assertEquals(29, count);
        } catch (StateCensosAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenFileTypeIncorrectShouldThrowException() {
        String filePathRead = "./src/main/resources/IndiaStateCensusData.pdf";

        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assert.assertEquals(29, count);
        } catch (StateCensosAnalyzerException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenStateCensusCSVFileCorrect_ButDelimiterIncorrectShouldThrowException() {
        String filePathRead = "IndianStateCensusAnalyzer/src/main/resources/IndiaStateCensusData.csv";
        String delimiter = ".";
        try {
            if (delimiter.equals(","))
                Assert.assertTrue(readObj.readDelimiter(filePathRead, delimiter));
            else
                Assert.assertFalse(readObj.readDelimiter(filePathRead, delimiter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenStateCensusCSVFileCorrect_ButHeaderIncorrectShouldThowException() {
        List<String> stringName = new ArrayList<>();
        String filePathRead = "IndianStateCensusAnalyzer/src/main/resources/IndiaStateCensusData.csv";
        stringName.add("State");
        stringName.add("Population");
        stringName.add("AreaInSqKm");
        stringName.add("Density");

        try {
            boolean flag = readObj.readHeader(filePathRead, stringName);
            if (flag == true)
                Assert.assertTrue(flag);
            else
                Assert.assertFalse(flag);
        } catch (IOException | StateCensosAnalyzerException e) {
            e.printStackTrace();
        }
    }
}