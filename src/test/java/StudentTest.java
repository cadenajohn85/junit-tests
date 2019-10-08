import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    Student testStudent;

    @Test
    public void testIfTestsWork() {
        assertTrue(1 + 2 == 3);
    }

    @Test
    public void testIfStudentCanBeCreated() {
        Student student = new Student(5L, "John");
        assertNotNull(student);
    }

    @Before
    public void setUp() {
        testStudent = new Student(1L, "Gary Green");
    }

    @Test
    public void testStudentFields() {
        assertEquals(1L, testStudent.getId());
        assertNotEquals(2L, testStudent.getId());
        assertEquals("Gary Green", testStudent.getName());
        assertNotEquals("Will White", testStudent.getName());
        assertEquals(0, testStudent.getGrades().size());
        assertNotEquals(1, testStudent.getGrades().size());
    }

    @Test
    public void testAddGradeMethod() {
        testStudent.addGrade(80);
        testStudent.addGrade(90);
        // Line 39 is a compile error: int is not a valid data type for arguments of assertEquals
            //  assertEquals(80, testStudent.getGrades().get(0)); // Why is this a compile error?
        // So, use assertSame instead when working with ints.
        assertSame(80, testStudent.getGrades().get(0));
        // Alternatively, cast your raw ints as Object Integer wrapper instead
            // assertEquals((Integer) 80, testStudent.getGrades().get(0));
    }

    @Test
    public void testGetGradeAverage() {
        testStudent.addGrade(80);
        testStudent.addGrade(90);
        // assertEquals requires a third "delta" parameter (acceptable degree of difference) when comparing any decimal numbers
        assertEquals(85, testStudent.getGradeAverage(), 0);
        // assertSame will not work with decimal numbers, because it cannot reconcile the degree of difference (since delta isn't an option as a parameter)
            // assertSame(85.0, testStudent.getGradeAverage());
                // java.lang.AssertionError: expected same:<85.0> was not:<85.0>
                    // Expected :85.0
                    // Actual   :85.0
        testStudent.addGrade(100);
        assertEquals(90, testStudent.getGradeAverage(), 0);
    }

}

