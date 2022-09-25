package services;

import com.model.Client;

import java.time.LocalDateTime;

public class KeyDataDisplay
{
    public static void DisplayKeyData(Client item)
    {
        if (item.getValidIndicator() == 'Y')
        {
            if (item.getMiddleName() == null)
                System.out.printf("%s | %s | %s | %s, %s%n", item.getUniqueKey(), item.getValidIndicator(), item.getFormattedYear(), item.getFirstName(), item.getLastName());
            else
                System.out.printf("%s | %s | %s | %s, %s, %s%n", item.getUniqueKey(), item.getValidIndicator(), item.getFormattedYear(), item.getFirstName(), item.getMiddleName(), item.getLastName());
        }
        else
        {
            if (item.getMiddleName() == null)
                System.out.printf("%s | %s | %s, %s%n", item.getUniqueKey(), item.getValidIndicator(), item.getFirstName(), item.getLastName());
            else
                System.out.printf("%s | %s | %s, %s, %s%n", item.getUniqueKey(), item.getValidIndicator(), item.getFirstName(), item.getMiddleName(), item.getLastName());
        }
    }

    public static void ValidateData(Client client)
    {
        if (DateValidator.ValidateDate(client) == 'Y')
        {
            client.setUniqueKey(KeyFormatter.FormatInput(client));
            var year = LocalDateTime.of(Calculator.AgeCalculator(client).getYear(), Calculator.AgeCalculator(client).getMonth(), Calculator.AgeCalculator(client).getDayOfMonth(), 0, 0);
            client.setFormattedYear(year.getYear() + " 0 0");
            MockData.AddKeyToList(client);
        }
        else
        {
            client.setUniqueKey(KeyFormatter.FormatInput(client));
            MockData.AddKeyToList(client);
        }
    }
}
