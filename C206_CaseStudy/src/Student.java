/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Yati Phoo Pwint Thwe
 * Student ID: 22003299
 * Class: W65N
 * Date/Time created: Saturday 05-08-2023 00:58
 */

/**
 * @author Yati Phoo Pwint Thwe
 *
 */
public class Student {
	
	    private int grade;
	    private String name;
	    private int age;
	    private String nric;
	    private String email;
	    

	    // Constructor to initialize a new Student object
	    public Student( String name, int age, String email, String nric, int grade) {
	        
	        this.name = name;
	        this.age = age;
	        this.email = email;
	        this.nric= nric;
	        this.grade = grade;
	    }

	    // Getters and setters for each attribute
	  
	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    public String getNric() {
	    	return nric;
	    }
	    
	    public int getGrade() {
	        return grade;
	    }
	  
	}


