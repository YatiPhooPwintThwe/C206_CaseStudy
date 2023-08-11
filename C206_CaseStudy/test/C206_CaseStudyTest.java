import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    @After
    public void tearDown() throws Exception {
        students = null;
        teachers = null;
    }
}
