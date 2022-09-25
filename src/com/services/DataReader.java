package com.services;

import com.model.Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class DataReader
{
    public static ArrayList<Client> GetMockData;

    public static void ReadData(String stringPath)
    {
        //initialize new list to hold data
        ArrayList<Client> data = new ArrayList<>();

        try
        {
            //instantiate stream reader and pass in file to read
            var buffer = new BufferedReader(new FileReader((stringPath)));

            while (buffer.ready())
            {
                //read records asynchronously
                var tempData = buffer.readLine();

                //split data using delimiter
                var strippedData = new ArrayList<>(Arrays.stream(tempData.split(";")).toList());

                //define dob variables
                String year = "", month = "", day = "";

                //check and remove blank records
                for (int i = 0; i < strippedData.size(); i++)
                    if (strippedData.get(i).isBlank() && strippedData.get(i).isBlank())
                        strippedData.remove(i);

                var client = new Client();

                //check count of list items
                switch (strippedData.size()) {
                    case 3 -> {
                        //get dob by yyyy mm dd
                        var yr = LocalDateTime.of(Integer.parseInt(strippedData.get(2).substring(0, 4)),1,1,0,0).getYear();
                        //month = strippedData.get(2).substring(4, strippedData.get(2).length() - 4);
                        //day = strippedData.get(2).substring(6, strippedData.get(2).length() - 2);

                        //check if dob is valid and create new client
                        if (yr >= 1900 && yr <= LocalDateTime.now().getYear()) {
                            client.setFirstName(strippedData.get(0));
                            client.setLastName(strippedData.get(1));
                            client.setDateOfBirth(LocalDateTime.of(yr, 1, 1, 0, 0));
                            data.add(client);
                        } else {
                            client.setFirstName(strippedData.get(0));
                            client.setLastName(strippedData.get(1));
                            client.setDateOfBirth(LocalDateTime.of(1899,1,1,0,0));
                            data.add(client);
                        }
                    }
                    case 4 -> {
                        //get dob by yyyy mm dd
                        var myYr = LocalDateTime.of(Integer.parseInt(strippedData.get(3).substring(0, 4)), 1,1,0,0).getYear();
                        //month = strippedData.get(3).substring(4, 2);
                        //day = strippedData.get(3).substring(6, 2);

                        if (myYr >= 1900 && myYr <= LocalDateTime.now().getYear()) {
                            client.setFirstName(strippedData.get(0));
                            client.setMiddleName(strippedData.get(1));
                            client.setLastName(strippedData.get(2));
                            client.setDateOfBirth(LocalDateTime.of(myYr, 1, 1, 0, 0));
                            data.add(client);
                        } else {
                            client.setFirstName(strippedData.get(0));
                            client.setMiddleName(strippedData.get(1));
                            client.setLastName(strippedData.get(2));
                            client.setDateOfBirth(null);
                            data.add(client);
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.printf("%nError occurred%n");
            System.out.printf("%nMessage -> %s", e.getMessage());
            System.out.printf("%n%nStackTrace%n%n%s\n\n", Arrays.deepToString(e.getStackTrace()));
        }

        GetMockData = data;
    }
}
