/*
 * This file holds and minipulates the student objects
 */

package StudentData;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    
    ArrayList<Student> nameList = new ArrayList<Student>();

    //Adds student to list of students
    public void updateNameList(Student name){
        nameList.add(name);
    }

    //Checks to see if student is in system through ID
    public boolean checkStudentID(){
        Scanner sudentIDScanner = new Scanner(System.in);
        System.out.println("Please enter UID");
        String name = sudentIDScanner.nextLine();
        
        for(int i=0; i<nameList.size(); i++){
            if ((nameList.get(i).getID()).equals(name)){
                System.out.println("Student already in system");
                return true;
            }
        }
        System.out.println("Student is not in system");
        return false;
    }

    //Checks to see if student is in system through full name and birthday
    public boolean checkStudentBirthday(){
        boolean whileLoopController = false;
        VerifyBirthday birthdayCheck = new VerifyBirthday();
        String birthday = "";
        Scanner sudentInformationScanner = new Scanner(System.in);
        System.out.println("Please enter the student's first name.");
        String firstName = sudentInformationScanner.nextLine();
        System.out.println("Please enter the student's last name.");
        String lastName = sudentInformationScanner.nextLine();

        while(whileLoopController == false){
            System.out.println("Please enter the student's birthday in mm/dd/yyyy format.");
            birthday = sudentInformationScanner.nextLine();
            
            whileLoopController = birthdayCheck.checkBirthdayDate(birthday);
        }

        for(int i=0; i<nameList.size(); i++){
            if (((nameList.get(i).getFullName().toLowerCase()).equals(firstName.toLowerCase()+" "+lastName.toLowerCase())) && (nameList.get(i).getbirtday().equals(birthday))){
                System.out.println("Student already in system");
                return true;
            }
        }
        System.out.println("Student is not in system");
        return false;
    }

    //Deletes student from system
    public void deleteStudent(){
        Scanner sudentIDScanner = new Scanner(System.in);
        System.out.println("Please enter student ID");
        String id = sudentIDScanner.nextLine();

        for(int i=0; i<nameList.size(); i++){
            if ((nameList.get(i).getID()).equals(id)){
                nameList.remove(i);
                System.out.println("Student has been deleted from system");
            }
        }
    }

    //Prints all students in list
    public void printNameList(){
        for(int i=0; i<nameList.size(); i++){
            System.out.println("Student "+i+" "+nameList.get(i).getFullName());
        }
    }
}
