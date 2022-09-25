package com.services;

import com.model.Client;

import java.util.Arrays;

public class KeyFormatter
{
    public static String FormatInput(Client client)
    {
        String tempFirst = "", tempMiddle = "", tempLast, shortLastName , finalOutput = "";

        try
        {
            if (client.getFirstName().length() > 0)
                tempFirst = client.getFirstName().substring(0, 1);

            if (client.getMiddleName() != null)
                tempMiddle = client.getMiddleName().substring(0, 1);

            if (client.getLastName().length() > 0 &&
                    client.getLastName().length() < 5)
            {
                tempLast = client.getLastName().substring(0, client.getLastName().length()) + "....";
                shortLastName = tempLast.substring(0, 5);
                tempLast = shortLastName;
            }
            else
                tempLast = client.getLastName();


            if (client.getLastName().length() - tempLast.length() > 0)
                return tempLast + (client.getLastName().length() - tempLast.length()) + tempFirst + (client.getFirstName().length() - tempFirst.length()) + 0;

            finalOutput = tempLast + tempFirst + (client.getFirstName().length() - tempFirst.length()) + tempMiddle;
        }
        catch (Exception e)
        {
            System.out.printf("%nError occured%n");
            System.out.printf("%nMessage -> Failed to create key. Please check your datasource and verify that the data is in the expected format.");
            System.out.printf("%n%nStackTrace%n%n%s%n%n", Arrays.toString(e.getStackTrace()));
        }

        return finalOutput;
    }
}
