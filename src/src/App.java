import java.util.ArrayList;
import java.util.Scanner;

import StudentData.Student;
import StudentData.NameList;

public class App {


    public static void main(String[] args) throws Exception {
        NameList listCheck = new NameList();
        Student student1 = new Student("Pual", "James");
        Student student2 = new Student("Henry", "Short");
        Student student3 = new Student("jake", "Miller");
        listCheck.updateNameList(student1);
        listCheck.updateNameList(student2);
        listCheck.updateNameList(student3);
        listCheck.printNameList();
        //listCheck.deleteStudent();
        //listCheck.printNameList();
        //listCheck.checkStudentID();
       // listCheck.checkStudentBirthday();

    }

   
}
