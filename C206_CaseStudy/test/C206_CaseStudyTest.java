import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class C206_CaseStudyTest {

    @Test
    public void testIsNameValid() {
        Assert.assertTrue(C206_CaseStudy.isNameValid("John Doe"));
        Assert.assertFalse(C206_CaseStudy.isNameValid("John3 Doe"));
    }

    @Test
    public void testIsNRICValid() {
        Assert.assertTrue(C206_CaseStudy.isNRICValid("S1234567A"));
        Assert.assertFalse(C206_CaseStudy.isNRICValid("A1234567Z"));
    }

    @Test
    public void testIsEmailValid() {
        Assert.assertTrue(C206_CaseStudy.isEmailValid("johndoe@gmail.com"));
        Assert.assertFalse(C206_CaseStudy.isEmailValid("johndoegmail.com"));
    }

    @Test
    public void testIsAgeValid() {
        Assert.assertTrue(C206_CaseStudy.isAgeValid(5));
        Assert.assertTrue(C206_CaseStudy.isAgeValid(36));
        Assert.assertFalse(C206_CaseStudy.isAgeValid(0));
        Assert.assertFalse(C206_CaseStudy.isAgeValid(37));
    }

    @Test
    public void testIsGradeValid() {
        Assert.assertTrue(C206_CaseStudy.isGradeValid(1));
        Assert.assertTrue(C206_CaseStudy.isGradeValid(12));
        Assert.assertFalse(C206_CaseStudy.isGradeValid(0));
        Assert.assertFalse(C206_CaseStudy.isGradeValid(13));
    }

    @Test
    public void testAddStudent() {
        ArrayList<Student> studentList = new ArrayList<>();
        C206_CaseStudy.addStudent(studentList);
        Assert.assertEquals(1, studentList.size());

        Student student = studentList.get(0);
        Assert.assertEquals("John Doe", student.getName());
        Assert.assertEquals(20, student.getAge());
        Assert.assertEquals("johndoe@gmail.com", student.getEmail());
        Assert.assertEquals("S1234567A", student.getNric());
        Assert.assertEquals(1, student.getGrade());
    }

    @Test
    public void testDisplayStudentList() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student student1 = new Student("John Doe", 20, "johndoe@gmail.com", "S1234567A", 1);
        Student student2 = new Student("Jane Doe", 21, "janedoe@gmail.com", "S2345678B", 2);
        studentList.add(student1);
        studentList.add(student2);

        String expectedOutput = String.format("%-20s %-5s %-25s %-12s %-5s\n", "Student Name", "Age", "Email", "NRIC", "Grade");
        expectedOutput += String.format("%-20s %-5s %-25s %-12s %-5s\n",
                student1.getName(),
                student1.getAge(),
                student1.getEmail(),
                student1.getNric(),
                student1.getGrade());
        expectedOutput += String.format("%-20s %-5s %-25s %-12s %-5s\n",
                student2.getName(),
                student2.getAge(),
                student2.getEmail(),
                student2.getNric(),
                student2.getGrade());

        String actualOutput = C206_CaseStudy.displayStudentList(studentList);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void testDeleteStudent_StudentExists() {
        ArrayList<Student> studentList = new ArrayList<>();
        Student student1 = new Student("John Doe", 20, "johndoe@gmail.com", "S1234567A", 1);
        studentList.add(student1);

        boolean isDeleted = C206_CaseStudy.deleteStudent(studentList);
        Assert.assertTrue(isDeleted);
        Assert.assertEquals(0, studentList.size());
    }

    @Test
    public void testDeleteStudent_StudentDoesNotExist() {
        ArrayList<Student> studentList = new ArrayList<>();
        boolean isDeleted = C206_CaseStudy.deleteStudent(studentList);
        Assert.assertFalse(isDeleted);
        Assert.assertEquals(0, studentList.size());
    }
    //yati
    
    @Test
    public void testAddFeeStudent() {
    	//testcase1
    	//test that feeList contains one fee entry 
        ArrayList<Fee> feeList = new ArrayList<>();
        Fee fee1 = new Fee("John Doe","S1234567A","C8","tuition",200,"January","2023-01-23");
        feeList.add(fee1);
        Assert.assertEquals(1, feeList.size());
        
        //testcase2
        //test that feelist is not null
        Assert.assertNotNull("Test if there is a valid feeList",feeList);
      
        //testcase3
        //test that feeList contains 2 fee entries
        Fee fee2 = new Fee("John Doe","S1234567A","C8","tuition",200,"March","2023-03-23");
        feeList.add(fee2);
        Assert.assertEquals(2, feeList.size()); 
    }
    
    @Test
    public void testViewFeeStudent() {
    	
    	//testcase1
    	//test that feeList is null
        ArrayList<Fee> feeList = new ArrayList<>();
        assertTrue("Fee list should be empty", feeList.isEmpty());
        
        //testcase2
    	//test that feeList contains one fee entry and that the student name matches "John Doe" 
        Fee fee1 = new Fee("John Doe", "S1234567A", "C8", "tuition", 200, "January", "2023-01-23");
        feeList.add(fee1);
        Assert.assertEquals(1, feeList.size());
        Assert.assertEquals("John Doe", feeList.get(0).getStudentName());
        
        //testcase3
        //test that after adding fee1, list is not null 
        feeList.add(fee1);
        assertFalse("Fee list should be empty", feeList.isEmpty());
    }
    
    @Test
    public void testDeleteFee() {
    	//testcase1
    	//test whether arraylist is suitable to delete from
        ArrayList<Fee> feeList = new ArrayList<>();
        Fee fee1 = new Fee("John Doe", "S1234567A", "C8", "tuition", 200, "January", "2023-01-23");
        feeList.add(fee1);
        assertNotNull("test if the fee list is valid to delete from", feeList);
        
        // testcase2
        // test whether fee list is empty after removing
        feeList.remove(fee1);
        assertTrue("Fee list should be empty", feeList.isEmpty());

        //testcase3
        // test that there is no fees in the list
        assertEquals(0, feeList.size());

    }
    //maha
    
    @Test
    public void testAddUser_Normal() {
        assertNotNull("Check if there is a valid teacher ArrayList to add to", teachers);
     
        teachers.add(new Teacher("Ms. Kong", "S2345671H", 25, "Mathematics", "kong25@edu.com"));
        assertEquals("Check that teacher ArrayList size is 1", 1, teachers.size());
        assertEquals("Check that the teacher's name is correct", "Ms. Kong", teachers.get(0).getTname());
    }
     
    --------------------------------------------------------------------------
     
    @Test
    public void testAddUser_InvalidNRIC() {
        assertNotNull("Check if there is a valid teacher ArrayList to add to", teachers);
     
        teachers.add(new Teacher("Mr. Smith", "12345678", 30, "Science", "smith30@edu.com"));
        assertEquals("Check that teacher ArrayList size is 0", 0, teachers.size());
    }
     
    ---------------------------------------------------------------------------
     
    @Test
    public void testAddUser_MaximumLimit() {
        assertNotNull("Check if there is a valid teacher ArrayList to add to", teachers);
     
        for (int i = 1; i <= C206_CaseStudy.MAX_TEACHERS; i++) {
            teachers.add(new Teacher("Teacher " + i, "S" + i + "1234567H", 30, "Subject", "teacher" + i + "@edu.com"));
        }
     
        assertEquals("Check that teacher ArrayList size is at maximum limit", C206_CaseStudy.MAX_TEACHERS, teachers.size());
    }
     
    ---------------------------------------------------------------------------
     (VIEW)
     
    @Test
    public void testViewUser_ExistingUsers() {
        assertNotNull("Check if there is a valid teacher ArrayList to view", teachers);
     
        teachers.add(new Teacher("Ms. Lee", "S3456789Z", 28, "English", "lee28@edu.com"));
        teachers.add(new Teacher("Mr. Tan", "S4567890X", 32, "History", "tan32@edu.com"));
     
        // Redirect system output to capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
     
        C206_CaseStudy.viewUsers(students, teachers);
     
        // Restore original system output
        System.setOut(System.out);
     
        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("Ms. Lee") && consoleOutput.contains("Mr. Tan"));
    }
     
    ---------------------------------------------------------------------------
     
    @Test
    public void testViewUser_EmptyList() {
        assertNotNull("Check if there is a valid teacher ArrayList to view", teachers);
     
        // Redirect system output to capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
     
        C206_CaseStudy.viewUsers(students, teachers);
     
        // Restore original system output
        System.setOut(System.out);
     
        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("No users available."));
    }
     
    ---------------------------------------------------------------------------
     
    @Test
    public void testViewUser_MaximumLimit() {
        assertNotNull("Check if there is a valid teacher ArrayList to view", teachers);
     
        for (int i = 1; i <= C206_CaseStudy.MAX_TEACHERS; i++) {
            teachers.add(new Teacher("Teacher " + i, "S" + i + "1234567H", 30, "Subject", "teacher" + i + "@edu.com"));
        }
     
        // Redirect system output to capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
     
        C206_CaseStudy.viewUsers(students, teachers);
     
        // Restore original system output
        System.setOut(System.out);
     
        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("Teacher 1") && consoleOutput.contains("Teacher " + C206_CaseStudy.MAX_TEACHERS));
    }
     
    ---------------------------------------------------------------------------
     
    (DELETE)
     
    @Test
    public void testDeleteUser_ExistingUser() {
        assertNotNull("Check if there is a valid teacher ArrayList to delete from", teachers);
     
        Teacher teacher = new Teacher("Ms. Lim", "S5678901A", 29, "Geography", "lim29@edu.com");
        teachers.add(teacher);
     
        boolean isDeleted = C206_CaseStudy.deleteUserFromLists(students, teachers, teacher.getTname(), teacher.getTnric());
        assertTrue(isDeleted);
        assertEquals("Check that teacher ArrayList size is 0", 0, teachers.size());
    }
     
    ---------------------------------------------------------------------------
     
    @Test
    public void testDeleteUser_NonexistentUser() {
        assertNotNull("Check if there is a valid teacher ArrayList to delete from", teachers);
     
        boolean isDeleted = C206_CaseStudy.deleteUserFromLists(students, teachers, "Nonexistent Teacher", "S1234567Z");
        assertFalse(isDeleted);
    }
     
    ---------------------------------------------------------------------------
     
    @Test
    public void testDeleteUser_LastUser() {
        assertNotNull("Check if there is a valid teacher ArrayList to delete from", teachers);
     
        Teacher teacher = new Teacher("Mr. Lee", "S6789012B", 35, "Physics", "lee35@edu.com");
        teachers.add(teacher);
     
        boolean isDeleted = C206_CaseStudy.deleteUserFromLists(students, teachers, teacher.getTname(), teacher.getTnric());
        assertTrue(isDeleted);
        assertEquals("Check that teacher ArrayList size is 0", 0, teachers.size());
    }

}