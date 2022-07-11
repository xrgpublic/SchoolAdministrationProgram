package StudentData;

import java.util.Scanner;
import java.util.UUID;

public class Student {
    
    String firstName;
    String lastName;
    String ID;
    int gradeLevel; 
    int num = 0;
    String birthday;

    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        createID();
        getGradeLevel();
        getBirthday();
        System.out.println("The students name is: "+firstName+" "+lastName+"\nThe Students ID is: "+ID+"\nThe Students Grade Level is: "+gradeLevel+"\nThe Student's Birthday is: "+birthday+"\n");
        num++;  
    }

     //Creates student ID
    private void createID(){
        this.ID = UUID.randomUUID().toString();  
    }
    //Returns Student ID
    protected String getID(){
        return ID;
    }
    //Returns student's first name
    protected String getFirstName(){
        return firstName;
    }
    //Returns student's last name
    protected String getLastName(){
        return lastName;
    }
    //Returns student's full name
    protected String getFullName(){
        return firstName+" "+lastName;
    }
    //Returns student's birthday
    protected String getbirtday(){
        return birthday;
    }

    //Assigns grade level to student
    private void getGradeLevel(){ 
        boolean loopController = false;
        Scanner gradeLevelScanner = new Scanner(System.in);

        while(loopController == false){
            System.out.println("please enter the students grade level");
            String gradeLevel = gradeLevelScanner.nextLine();
            try{
                int gradeLevelNumber = Integer.parseInt(gradeLevel);
                this.gradeLevel = gradeLevelNumber;
                loopController = true;
            }
            catch(NumberFormatException e){
                System.out.println("Error! The Grade Level You Entered Does Not Exist.");
            }
        }
    }

    //Assign birthday to student
    private void getBirthday(){
        boolean whileLoopController = false;
        Scanner birthdayScanner = new Scanner(System.in);
        VerifyBirthday birthdayCheck = new VerifyBirthday();
        String birthday = "";

        while (whileLoopController == false){
            System.out.println("Please enter the student's birthday in mm/dd/yyyy format.");
            birthday = birthdayScanner.nextLine();
            this.birthday = birthday;
            whileLoopController = birthdayCheck.checkBirthdayDate(birthday);
        }
    }
}
