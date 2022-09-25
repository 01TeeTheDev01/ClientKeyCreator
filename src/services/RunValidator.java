package services;

import java.util.Collections;

public class RunValidator
{
    public static void BeginExec()
    {
        //Get file path
        //String path = FileLocator.ClientFilePath();

        //Read data from file
        DataReader.ReadData("C:\\Users\\Pro-Music\\Downloads\\SampleCSVFile_2kb.csv");

        System.out.printf("%n===[Client Keys]===%n");

        //Format data into expected format
        for(var mockObj : DataReader.GetMockData)
            KeyDataDisplay.ValidateData(mockObj);

        //Sort data and display
        for (var item : KeyValidator.ValidateKeys())
            KeyDataDisplay.DisplayKeyData(item);

        //Output results
        System.out.printf("%nTotal keys processed: %s", MockData.GetClientKeyCount());
    }
}