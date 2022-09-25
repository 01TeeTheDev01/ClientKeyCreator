package com.services;

import com.model.Client;

import java.util.ArrayList;
import java.util.Arrays;

public class MockData
{
    private static final ArrayList<Client> keysList = new ArrayList<>();

    public static void AddKeyToList(Client client)
    {
        try
        {
            int duplicateCount = 0;
            client.setUniqueKey(client.getUniqueKey() + "-" + (duplicateCount + 1));
            keysList.add(client);
        }
        catch (Exception e)
        {
            System.out.printf("%nError occured%n");
            System.out.printf("%nMessage -> Failed to initialize list.");
            System.out.printf("%n%nStackTrace%n%n%s%n%n", Arrays.deepToString(e.getStackTrace()));
        }
    }

    public static ArrayList<Client> GetClientKeys()
    {
        return keysList;
    }

    public static int GetClientKeyCount()
    {
        return keysList.size();
    }
}
