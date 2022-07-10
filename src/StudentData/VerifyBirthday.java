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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        try {
            LocalDate birthdate = LocalDate.parse(birthday, formatter);
            return true;
    
        } catch (DateTimeParseException e) {
            System.out.println("Error! The Date You Entered Does Not Exist");
            return false;
        }     
    }
}
