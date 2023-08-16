import static org.junit.Assert.assertTrue;


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
}