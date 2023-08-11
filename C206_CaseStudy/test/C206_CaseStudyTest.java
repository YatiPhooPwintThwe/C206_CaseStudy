<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

=======
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
>>>>>>> branch 'master' of https://github.com/YatiPhooPwintThwe/C206_CaseStudy
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;

    @Before
    public void setUp() throws Exception {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    @Test
    public void testAddTeacher() {
        assertNotNull("Check if there is a valid teacher ArrayList to add to", teachers);

        teachers.add(new Teacher("Ms. Kong", "S2345671H", 25, "Mathematics", "kong25@edu.com"));
        assertEquals("Check that teacher ArrayList size is 1", 1, teachers.size());
        assertEquals("Check that the teacher's name is correct", "Ms. Kong", teachers.get(0).getTname());
    }

    // Other test methods remain unchanged

<<<<<<< HEAD
    @After
    public void tearDown() throws Exception {
        students = null;
        teachers = null;
=======
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
>>>>>>> branch 'master' of https://github.com/YatiPhooPwintThwe/C206_CaseStudy
    }
        @Test
        void testAddAttendance() {
            ArrayList<Student> studentList = new ArrayList<>();
            ArrayList<Attendance> attendanceList = new ArrayList<>();

            Student student = new Student("John", 20, "john@example.com", "S1234567A", 10);
            studentList.add(student);

            // Create an instance of C206_CaseStudy (replace constructor arguments as needed)
            C206_CaseStudy caseStudy = new C206_CaseStudy();

            caseStudy.addAttendance(studentList, attendanceList);

            // Assuming you have added a student named John with valid attendance data
            assertTrue(attendanceList.size() > 0);
        }
    @Test
    void testViewAttendance() {
        ArrayList<Attendance> attendanceList = new ArrayList<>();
        // Assuming you have added some attendance records

        // Create an instance of C206_CaseStudy (replace constructor arguments as needed)
        C206_CaseStudy caseStudy = new C206_CaseStudy();

        // Redirect system output to capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        caseStudy.viewAttendance(attendanceList);

        // Restore original system output
        System.setOut(System.out);

        String consoleOutput = outputStream.toString();
        // Assuming you have valid attendance records, check if they are displayed
        assertTrue(consoleOutput.contains("Student Name") && consoleOutput.contains("Course Code") &&
                   consoleOutput.contains("Lesson No") && consoleOutput.contains("Date") &&
                   consoleOutput.contains("Status"));
    }
        @Test
        void testDeleteAttendance() {
            ArrayList<Attendance> attendanceList = new ArrayList<>();
            // Assuming you have added some attendance records

            // Create an instance of C206_CaseStudy (replace constructor arguments as needed)
            C206_CaseStudy caseStudy = new C206_CaseStudy();

            // Assuming you have valid attendance records, adjust the arguments as needed
            boolean removed = caseStudy.deleteAttendance(attendanceList);

            // Assuming you are testing with a valid attendance record to delete
            assertTrue(removed);
            assertTrue(attendanceList.isEmpty());
        }
        
    }

//hello