package com.services;

import com.model.Client;

import java.util.*;

public class KeyValidator
{
    public static ArrayList<Client> ValidateKeys()
    {
        try
        {
            if (MockData.GetClientKeys() != null)
            {
                //Convert Enumeration type client to list
                var clientArrayList = MockData.GetClientKeys();

                //Loop through list items
                for (int count = 0; count < clientArrayList.size(); count++)
                {
                    //Find duplicates
                    int clientIndex = count;
                    var duplicateKeys = MockData.GetClientKeys().stream().filter(k-> Objects.equals(k.getUniqueKey(), clientArrayList.get(clientIndex).getUniqueKey())).toList();

                    if (duplicateKeys.size() > 1)
                    {
                        for (int counter = 0; counter < duplicateKeys.size() - 1; counter++)
                        {
                            //get next duplicate client key in list and get client's id in list
                            var nextClient = duplicateKeys.get(counter + 1);
                            int nextClientIndex = MockData.GetClientKeys().indexOf(nextClient);
                            var splitVal = nextClient.getUniqueKey().split("-");

                            //check if duplicate is number
                            int duplicateVal = Integer.parseInt(splitVal[1]);
                            splitVal[1] = String.valueOf(++duplicateVal);

                            //Append duplicate count to client key
                            MockData.GetClientKeys().get(nextClientIndex).setUniqueKey(String.join("-", splitVal));
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.printf("%nError occured%n");
            System.out.printf("%nMessage -> Failed to initialize list.");
            System.out.printf("%n%nStackTrace%n%n%s%n%n", Arrays.deepToString(e.getStackTrace()));
        }
        return MockData.GetClientKeys();
    }
}
