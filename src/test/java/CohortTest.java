import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CohortTest {

    Student student1;
    Student student2;
    Student student3;

    Cohort noStudentsCohort;
    Cohort oneStudentCohort;
    Cohort manyStudentsCohort;

    @Before
    public void setUp() {
        student1 = new Student(1L, "John");
        student2 = new Student(2L, "James");
        student3 = new Student(3L, "Jeff");

        noStudentsCohort = new Cohort();

        oneStudentCohort = new Cohort();
        oneStudentCohort.addStudent(student1);

        manyStudentsCohort = new Cohort();
        manyStudentsCohort.addStudent(student1);
        manyStudentsCohort.addStudent(student2);
        manyStudentsCohort.addStudent(student3);
    }

    @Test
    public void testGetStudents() {
        assertEquals(0, noStudentsCohort.getStudents().size());
        assertEquals(1, oneStudentCohort.getStudents().size());
        assertEquals(3, manyStudentsCohort.getStudents().size());
    }

    @Test
    public void testAddStudent() {
        noStudentsCohort.addStudent(student1);
        assertEquals(1, noStudentsCohort.getStudents().size());
        oneStudentCohort.addStudent(student2);
        assertEquals(2, oneStudentCohort.getStudents().size());
    }

    @Test
    public void testGetCohortAverage() {
        student1.addGrade(80);
        student1.addGrade(100);
        assertEquals(90, oneStudentCohort.getCohortAverage(), 0);
        student2.addGrade(50);
        student2.addGrade(60);
        student2.addGrade(70);
        student3.addGrade(70);
        student3.addGrade(75);
        student3.addGrade(80);
        assertEquals(75, manyStudentsCohort.getCohortAverage(), 0);
    }

//    Follow the TDD cycle and create a new feature to find students by their ID like: findStudentById(long id) in the Cohort class, remember to create the tests first before any production code.

    @Test
    public void testFindStudentById() {
        assertSame("John", oneStudentCohort.findStudentById(1));
        assertSame("James", manyStudentsCohort.findStudentById(2));
    }





}
