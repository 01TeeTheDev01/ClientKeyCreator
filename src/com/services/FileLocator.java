package com.services;

import java.util.Arrays;
import java.util.Scanner;

public class FileLocator
{
    private static Scanner sc;

    public static String ClientFilePath()
    {
        String filePath = "";
        sc = new Scanner(System.in);

        try
        {
            while (filePath.equals(""))
            {
                System.out.printf("%n===[Client key verifier]===%n");
                System.out.println("Enter full path and extension of filename:");
                System.out.printf("E.g. c:\\users\\john\\myfile\\data.csv%n%n");
                System.out.printf("%nFile path: ");
                filePath = sc.next();

                if (!filePath.isBlank() && filePath.isEmpty())
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.printf("Error occured%n%nMessage -> %s%n%nStackTrace:%n%n%s", e.getMessage(), Arrays.toString(e.getStackTrace()));
        }

        return filePath;
    }
}
