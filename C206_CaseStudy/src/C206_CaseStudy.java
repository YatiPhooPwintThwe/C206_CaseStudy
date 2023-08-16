import java.util.ArrayList;

public class C206_CaseStudy {

   
	/**
	 * 
	 */
	private static final int OPTION_DELETEFEE = 9;
	private static final int OPTION_VIEWFEE = 8;
	private static final int OPTION_ADDFEE = 7;
	private static final int OPTION_DELETE = 6;
	private static final int OPTION_ADDSTUDENT = 4; 
	private static final int OPTION_VIEWSTUDENT = 5; 
	private static final int OPTION_QUIT = 19;
	
	public static boolean isNameValid(String name) {
	     String namePattern = "\\D{2,100}";
	  
	     return name.matches(namePattern);
	    }

	public static boolean isNRICValid(String nric) {
	     String nricPattern = "[STGFMstgm][0-9]{7}[A-Za-z]";
	     
	     return nric.matches(nricPattern);
	    }
	
	public static boolean isEmailValid(String email) {
	     String emailPattern = "^.+@.+\\.com$";
	     return email.matches(emailPattern);
	    }
	
	public static boolean isAgeValid(int age) {
	    return age >= 5 && age <= 36;
	}
	
	public static boolean isGradeValid(int grade) {
	    return grade >= 1 && grade <= 12;
	}


	public static void main(String[] args) {
        // Create an empty ArrayList to store student data
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Fee> feeList = new ArrayList<>();
    
        int option = -99;
       
       
        while (option != OPTION_QUIT) {
        	option = Helper.readInt("Enter option > ");
        
            if (option == OPTION_ADDSTUDENT) {
                addStudent(studentList);
                
            }
            if (option == OPTION_VIEWSTUDENT) {
            	displayStudentList(studentList);
            }
            if (option == OPTION_DELETE) {
            	deleteStudent(studentList);
            	
            }
            if (option == OPTION_ADDFEE) {
            	addFee(feeList);
            	
            }
            if (option == OPTION_VIEWFEE) {
            	viewFeesByStudent(feeList);
            }
            if (option == OPTION_DELETEFEE) {
            	deleteFee(feeList);
            }
            // Add other menu options and corresponding methods here.
        }
    }
	
	private void addUsers(ArrayList<Teacher> teachers) { 

        int choice; 

  

        do { 

            System.out.println("--------------------"); 

            System.out.println("ADD USER"); 

            System.out.println("--------------------"); 


            System.out.println("1. Add Teacher Account"); 

            System.out.println("3. Back"); 

            choice = Helper.readInt("Enter an option > "); 

  

            if (choice == 1) { 

              addTeacher(teachers); 

            }

        } while (choice != 3); 

    } 

  

   

    private void addTeacher(ArrayList<Teacher> teachers) { 

        String tname = validateAlphabets("Enter teacher's name > "); 

        int tage = validateNumbers("Enter teacher's age > "); 

        String tnric = validateNRIC("Enter teacher's NRIC > "); 

        String tcourse = Helper.readString("Enter teacher's course > "); 

        String temail = Helper.readString("Enter teacher's email > "); 

  

        teachers.add(new Teacher(tname, tnric, tage, tcourse, temail)); 

        System.out.println("Teacher added successfully!"); 

    } 

  

    private String validateAlphabets(String message) { 

        while (true) {

String input = Helper.readString(message); 

            if (input.matches("[A-Za-z ]+")) { 

                return input; 

            } else { 

                System.out.println("Alphabets Only!"); 

            } 

        } 

    } 

  

    private int validateNumbers(String message) { 

        while (true) { 

            String input = Helper.readString(message); 

            if (input.matches("\\d+")) { 

                return Integer.parseInt(input); 

            } else { 

                System.out.println("Numbers Only!"); 

            } 

        } 

    } 

  

    private String validateNRIC(String message) { 

        while (true) { 

            String input = Helper.readString(message); 

            if (input.matches("[STGFMA][0-9]{7}[A-Za-z]")) { 

                return input; 

            } else { 

                System.out.println("Invalid NRIC Format!"); 

            } 

        } 

    } 

  

    private void viewUsers( ArrayList<Teacher> teachers) { 

        System.out.println("--------------------"); 

        System.out.println("VIEW ALL USERS"); 

        System.out.println("--------------------"); 

       

        System.out.println("Teachers:"); 

        for (Teacher teacher : teachers) { 

            System.out.println("Name: " + teacher.getTname() + ", NRIC: " + teacher.getTnric() + ", Age: " + teacher.getTage() + ", Course: " + teacher.getTcourse() + ", Email: " + teacher.getTemail()); 

        } 

    } 

  

    private void deleteUser(ArrayList<Teacher> teachers) { 

        System.out.println("--------------------"); 

        System.out.println("DELETE USER"); 

        System.out.println("--------------------"); 

        String name = Helper.readString("Enter name of user to delete > "); 

        String nric = Helper.readString("Enter NRIC of user to delete > "); 

        boolean userDeleted = deleteUserFromLists(teachers, name, nric); 

        if (userDeleted) { 

            System.out.println("User deleted successfully!"); 

        } else { 

            System.out.println("User not found or incorrect personal details."); 

        } 

    } 

  

    private boolean deleteUserFromLists(ArrayList<Teacher> teachers, String name, String nric) { 

      

        boolean teacherDeleted = teachers.removeIf(teacher -> teacher.getTname().equals(name) && teacher.getTnric().equals(nric)); 

        return teacherDeleted; 

    } 

 


 
/**
 * @return
 */
	

   
     
	public static void addStudent(ArrayList<Student> studentList) {
	    boolean validName = false;
	    boolean validAge = false;
	    boolean validEmail = false;
	    boolean validNRIC = false;
	    boolean validGrade = false;
	    boolean isFound = false;
	    String finalNric = ""; // Move the declaration outside the loop

	    Helper.line(45, "*");
	    System.out.println("*****     ADDING NEW STUDENT    *****");
	    Helper.line(45, "*");

	    while (!validName) {
	        String name = Helper.readString("Enter your name > ");
	        String finalName = name.toUpperCase();
	        if (!isNameValid(name)) {
	            System.out.println("Invalid name. Please enter again.");
	            continue;
	        }
	        validName = true;
	    

	    while (!validAge) {
	        int age = Helper.readInt("Enter your age > ");
	        if (!isAgeValid(age)) {
	            System.out.println("Invalid age. Please enter again.");
	            continue;
	        }
	        validAge = true;
	    

	    while (!validEmail) {
	        String email = Helper.readString("Enter your email address > ");
	        if (!isEmailValid(email)) {
	            System.out.println("Invalid email. Please enter again.");
	            continue;
	        }
	        validEmail = true;
	    

	        while (!validNRIC) {
	            String nric = Helper.readString("Enter your NRIC > ");
	            int foundIndex = -1; // Initialize the foundIndex to -1
	            for (int i = 0; i < studentList.size(); i++) {
	                if (nric.equalsIgnoreCase(studentList.get(i).getNric())) {
	                    foundIndex = i;
	                    break;
	                }
	            }
	            if (foundIndex >= 0) {
	                System.out.println("This student is already existed.");
	                continue; // Prompt the user to enter NRIC again
	            } else {
	                finalNric = nric.toUpperCase(); // Assign the valid NRIC to finalNric
	                if (!isNRICValid(finalNric)) {
	                    System.out.println("Invalid NRIC. Please enter again.");
	                    continue;
	                }
	                validNRIC = true;
	            }
	        


	    while (!validGrade) {
	        int grade = Helper.readInt("Enter your grade (1 to 12) > ");
	        if (!isGradeValid(grade)) {
	            System.out.println("Invalid grade. Please enter again.");
	            continue;
	        }
	        validGrade = true;
	    

	    // Create a new Student object with the given details
	    Student student = new Student(finalName, age, email, finalNric, grade);

	    // Add the student to the ArrayList
	    studentList.add(student);
	    }
	    }
	    }
	    }
	    }
	    // Return a success message
	    System.out.println("Student added successfully.");
	}   

     public static String displayStudentList(ArrayList<Student> studentList) {
    	 String output = "";

         if (studentList.isEmpty()) {
             System.out.println("No students found.");
         } else {
             Helper.line(45, "*");
             System.out.println("*****     STUDENT  INFORMATION    *****");
             Helper.line(45, "*");
             output = String.format("%-20s %-5s %-25s %-12s %-5s\n", "Student Name", "Age", "Email", "NRIC", "Grade");
             for (int i = 0; i < studentList.size(); i++) {
                 output += String.format("%-20s %-5s %-25s %-12s %-5s\n",
                         studentList.get(i).getName(),
                         studentList.get(i).getAge(),
                         studentList.get(i).getEmail(),
                         studentList.get(i).getNric(),
                         studentList.get(i).getGrade());
             }
             System.out.println(output);;
         }
		return output;
     }

    public static boolean deleteStudent(ArrayList<Student> studentList) {
    	Helper.line(45, "*");
        System.out.println("*****     DELETING STUDENT    *****");
        Helper.line(45, "*");
        String nricToDelete = Helper.readString("Enter student's NRIC to delete > ");
        boolean removed = false;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getNric().equalsIgnoreCase(nricToDelete)) {
                String studentName = studentList.get(i).getName();
                char delInfo = Helper.readChar("\nConfirm deletion of " + studentName + "? (y/n) > ");
                if (delInfo == 'y' || delInfo == 'Y') {
                    studentList.remove(i);
                    System.out.println(studentName + " deleted successfully.\n");
                    removed = true;
                    break;
                } else if (delInfo == 'n' || delInfo == 'n') {
                    System.out.println(studentName + " is not deleted.\n");
                    removed = true;
                    break;
                } else {
                    System.out.println("Invalid option. Deletion canceled.\n");
                    removed = true;
                }
            }
        }

        if (!removed) {
            System.out.println("\n***No such student is found***\n");
        }
		return removed;
    }
	//maha
	public static boolean deleteStudentHelper(ArrayList<Student> studentList, String nric) {
		return false;
		// TODO Auto-generated method stub
		
	}
	//add fee
	public static void addFee(ArrayList<Fee> feeList) {
        String studentName = Helper.readString("Enter student's name > ");
        String nric = Helper.readString("Enter NRIC > ");
        String courseCode = Helper.readString("Enter course code > ");
        String feeType = Helper.readString("Enter fee type (tuition/exam/others) > ");
        int amount = Helper.readInt("Enter fee amount > ");
        String month = Helper.readString("Enter month > ");
        String dueDate = Helper.readString("Enter due date (yyyy-MM-dd) > ");

        Fee fee = new Fee(studentName, nric, courseCode, feeType, amount, month, dueDate);
        feeList.add(fee);
        System.out.println("Fee added successfully.");
    }
    //view fee
    public static void viewFeesByStudent(ArrayList<Fee> feeList) {
        String studentName = Helper.readString("Enter student's name > ");
        boolean found = false;

        System.out.println("List of Fees for " + studentName + ":");
        for (Fee fee : feeList) {
            if (fee.getStudentName().equalsIgnoreCase(studentName)) {
                System.out.println("NRIC: " + fee.getNric());
                System.out.println("Course Code: " + fee.getCourseCode());
                System.out.println("Fee Type: " + fee.getFeeType());
                System.out.println("Amount: " + fee.getAmount());
                System.out.println("Month: " + fee.getMonth());
                System.out.println("Due Date: " + fee.getDueDate());
                System.out.println("---------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No fees found for " + studentName);
        }
    }
    // delete fee
    public static void deleteFee(ArrayList<Fee> feeList) {
        String nric = Helper.readString("Enter student's NRIC > ");
        String monthToDelete = Helper.readString("Enter the month of the fee paid > ");

        boolean found = false;
        for (int i = 0; i < feeList.size(); i++) {
            Fee fee = feeList.get(i);
            if (fee.getNric().equalsIgnoreCase(nric) && fee.getMonth().equalsIgnoreCase(monthToDelete)) {
                feeList.remove(i);
                System.out.println("Fee for " + fee.getStudentName() + " in month " + monthToDelete + " deleted.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No fee found for the specified student and month.");
        }
    }

}
		
		
     
	
		
            
        

      

