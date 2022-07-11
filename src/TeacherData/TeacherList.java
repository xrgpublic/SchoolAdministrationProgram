/*
 * This file holds and minipulates the student objects
 */

package TeacherData;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherList {
    
    ArrayList<Teacher> nameList = new ArrayList<Teacher>();

    //Adds student to list of teachers
    public void updateNameList(Teacher name){
        nameList.add(name);
    }

    //Checks to see if student is in system through ID
    public boolean checkTeacherID(){
        Scanner teacherIDScanner = new Scanner(System.in);
        System.out.println("Please enter UID");
        String name = teacherIDScanner.nextLine();
        
        for(int i=0; i<nameList.size(); i++){
            if ((nameList.get(i).getID()).equals(name)){
                System.out.println("Teacher already in system");
                return true;
            }
        }
        System.out.println("Teacher is not in system");
        return false;
    }

    //Checks to see if teacher is in system through full name and birthday
    public boolean checkTeacherBirthday(){
        boolean whileLoopController = false;
        VerifyBirthday birthdayCheck = new VerifyBirthday();
        String birthday = "";
        Scanner teacherInformationScanner = new Scanner(System.in);
        System.out.println("Please enter the teacher's first name.");
        String firstName = teacherInformationScanner.nextLine();
        System.out.println("Please enter the teacher's last name.");
        String lastName = teacherInformationScanner.nextLine();

        while(whileLoopController == false){
            System.out.println("Please enter the teacher's birthday in mm/dd/yyyy format.");
            birthday = teacherInformationScanner.nextLine();
            
            whileLoopController = birthdayCheck.checkBirthdayDate(birthday);
        }

        for(int i=0; i<nameList.size(); i++){
            if (((nameList.get(i).getFullName().toLowerCase()).equals(firstName.toLowerCase()+" "+lastName.toLowerCase())) && (nameList.get(i).getbirtday().equals(birthday))){
                System.out.println("Teacher already in system");
                return true;
            }
        }
        System.out.println("Teacher is not in system");
        return false;
    }

    //Deletes teacher from system
    public void deleteTeacher(){
        Scanner teacherIDScanner = new Scanner(System.in);
        System.out.println("Please enter teacher ID");
        String id = teacherIDScanner.nextLine();

        for(int i=0; i<nameList.size(); i++){
            if ((nameList.get(i).getID()).equals(id)){
                nameList.remove(i);
                System.out.println("Teacher has been deleted from system");
            }
        }
    }

    //Finds teacher information based on what class they teach
    public void checkTeacherClass(){

    }

    //Prints all teacher in list
    public void printNameList(){
        for(int i=0; i<nameList.size(); i++){
            System.out.println("Teacher "+i+" "+nameList.get(i).getFullName());
        }
    }
}
