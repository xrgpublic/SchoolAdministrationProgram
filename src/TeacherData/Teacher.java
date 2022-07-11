package TeacherData;

import java.util.Scanner;
import java.util.UUID;

public class Teacher {
    
    String firstName;
    String lastName;
    String ID;
    int gradeLevel; 
    int num = 0;
    String birthday;
    String className;

    public Teacher(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        createID();
        getGradeLevel();
        getBirthday();
        getTeachersClass();
        System.out.println("The teacher's name is: "+firstName+" "+lastName+"\nThe teacher's ID is: "+ID+"\nThe teacher's class is: grade "+gradeLevel+" "+className+
        "\nThe teacher's Birthday is: "+birthday+"\n");
        num++;  
    }

     //Creates teacher ID
    private void createID(){
        this.ID = UUID.randomUUID().toString();  
    }
    //Returns teacher ID
    protected String getID(){
        return ID;
    }
    //Returns teacher's first name
    protected String getFirstName(){
        return firstName;
    }
    //Returns teacher's last name
    protected String getLastName(){
        return lastName;
    }
    //Returns teacher's full name
    protected String getFullName(){
        return firstName+" "+lastName;
    }
    //Returns teacher's birthday
    protected String getbirtday(){
        return birthday;
    }

    //Assigns grade level to teacher
    private void getGradeLevel(){ 
        boolean loopController = false;
        Scanner gradeLevelScanner = new Scanner(System.in);

        while(loopController == false){
            System.out.println("please enter the grade level the Teacher is teaching");
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

    //Assigns class to teacher
    private void getTeachersClass(){
        Scanner classScanner = new Scanner(System.in);
        String[] classList = {"History", "English","Math", "Science", "Art", "Physical Education", "Home Economics", "Spanish", "Music"};
        boolean whileLoopController = false;

        try{
            //Loop runs until a proper class is given to teacher
            while(whileLoopController == false){
                System.out.println("Please enter the number that corrisponds to class you are teaching");
                //Prints list of classes
                for(int i=0; i< classList.length; i++){
                    System.out.println((i+1)+": "+classList[i]); 
                }
                this.className = classScanner.nextLine();
                int classNumber = Integer.valueOf(className);
                classNumber--;
                //Makes sure class is in range of list
                if(classNumber > -1 && classNumber < 9){
                    this.className = classList[classNumber];
                    whileLoopController = true;
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Please enter a number 1-9");
        }

    }

    //Assign birthday to teacher
    private void getBirthday(){
        boolean whileLoopController = false;
        Scanner birthdayScanner = new Scanner(System.in);
        VerifyBirthday birthdayCheck = new VerifyBirthday();
        String birthday = "";

        while (whileLoopController == false){
            System.out.println("Please enter the teacher's birthday in mm/dd/yyyy format.");
            birthday = birthdayScanner.nextLine();
            this.birthday = birthday;
            whileLoopController = birthdayCheck.checkBirthdayDate(birthday);
        }
    }
}
