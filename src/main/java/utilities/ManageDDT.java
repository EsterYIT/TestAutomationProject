package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps{

    @DataProvider(name = "data-provider-users")
    public Object[][] getDataObject()
    {
        return getDataFromCSV(getData("DDTFile"));
    }

    public static List<String> readCSV(String csvFile)
    {
        List<String > lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static Object[][] getDataFromCSV(String filePath)
    {
        List<String> csvData = readCSV(filePath);
        int rows = csvData.size();
        String [] column  = csvData.get(0).split(",");
        Object[][] data = new Object[rows][column.length];

        for(int i = 0; i < csvData.size(); i++){
            for(int j = 0; j < column.length;j++){
                data[i][j] =  csvData.get(i).split(",")[j];
            }
        }
        return data;
    }
}
