/*
 * This file checks to make sure each birthday it recieves is a real date
 */

package StudentData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class VerifyBirthday {
    
    //Verifies date
    public boolean checkBirthdayDate(String birthday){
        //Student must be between the ages 4 and 12
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate earliestDate =LocalDate.parse("05/01/2010", formatter);
        LocalDate latestDate = LocalDate.parse("05/01/2018", formatter);
        try {
            LocalDate birthdate = LocalDate.parse(birthday, formatter);
            System.out.println("Compareing birthday "+birthdate.compareTo(earliestDate)+ "  "+birthdate.compareTo(latestDate));
            //Return true if birthday is between 05/01/2010 and 05/01/2018
            if(birthdate.compareTo(earliestDate) >= 0 && birthdate.compareTo(latestDate) <= 0){
                return true;
            }
            System.out.println("Error! The date you entered is not between 05/01/2010 and 05/01/2018");
            return false;
    
        } catch (DateTimeParseException e) {
            System.out.println("Error! The date you entered does not exist");
            return false;
        }     
    }
}
