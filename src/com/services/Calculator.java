package com.services;

import com.model.Client;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;

public class Calculator {

    public static LocalDateTime AgeCalculator(Client client)
    {
        LocalDateTime age = null;

        try
        {
            age = LocalDateTime.now().minus(Period.ofYears(client.getDateOfBirth().getYear()));
        }
        catch (Exception e)
        {
            System.out.printf("%nError occured%n");
            System.out.printf("%n%nMessage -> There's a problem parsing the data. Please check your datasource and verify that the data is in the expected format.");
            System.out.printf("%n%nStackTrace%n%n%s%n%n", Arrays.deepToString(e.getStackTrace()));
        }

        return age;
    }
}
