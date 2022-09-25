package services;

import com.model.Client;

import java.time.LocalDateTime;
import java.util.Arrays;

public class DateValidator
{
    public static char ValidateDate(Client client)
    {
        if (client != null)
        {
            try
            {
                var oldestDate = LocalDateTime.of(1900, 1, 1,0,0).getYear();

                if (client.getDateOfBirth() == null)
                    client.setValidIndicator('N');

                if (client.getDateOfBirth().getYear() >= oldestDate && client.getDateOfBirth().getYear() <= LocalDateTime.now().getYear())
                    client.setValidIndicator('Y');
            }
            catch (Exception e)
            {
                System.out.printf("%nError occurred%n");
                System.out.printf("%nMessage -> There's a problem parsing the data. Please check your datasource and verify that the data is in the expected format.");
                System.out.printf("%n%nStackTrace%n%n%s%n%n", Arrays.deepToString(e.getStackTrace()));
            }

            return client.getValidIndicator();
        }

        return '\u0000';
    }
}
