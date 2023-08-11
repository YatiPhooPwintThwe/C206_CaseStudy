import java.util.ArrayList;

public class C206_CaseStudy {

 // Student > add,view,delete
	private static final int OPTION_DELETE = 5;
	private static final int OPTION_ADDSTUDENT = 3;
	private static final int OPTION_VIEWSTUDENT = 4;
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
    
        int option = -99;
       
       
        while (option != OPTION_QUIT) {
        	option = Helper.readInt("Enter option > ");
        	Helper.line(80, "-");
        
            if (option == 1) {
            	optionA = Helper.readInt("Enter option for User > ");
            }else if (option == 2) {
            	optionB = Helper.readInt("Enter option for Course > ");
            }else if (option == 3) {
            	optionC = Helper.readInt("Enter option for Student > ");
            	if (optionC = OPTION_ADDSTUDENT) {
            		addStudent(studentList);
        		}else if (optionC == OPTION_VIEWSTUDENT) {
        			displayStudentList(studentList);
        		}else if (optionC == OPTION_DELETE) {
        			deleteStudent(studentList); 	
        		}
            }else if (option == 4) {
            	optionD = Helper.readInt("Enter option for Fee > ");
            }else if (option == 5) {
            	optionE = Helper.readInt("Enter option for Enrolment > ");
            }else if (option == 6 )
            	optionF = Helper.readInt("Enter option for Attendance > ");
            // Add other menu options and corresponding methods here.
        }
    }
     
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
	
	public static boolean deleteStudentHelper(ArrayList<Student> studentList, String nric) {
		return false;
		// TODO Auto-generated method stub
		
	}
}
		
		
     
	
		
            
        

      

