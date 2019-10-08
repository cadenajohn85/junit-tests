import java.util.ArrayList;
import java.util.List;

public class Cohort {

    private List<Student> students;

    public Cohort() {
        this.students = new ArrayList<>();
    }

    public double getCohortAverage() {
        double avg = 0;
        for (Student student: this.getStudents()) {
            avg += student.getGradeAverage();
        }
        return avg / this.getStudents().size();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    // New feature: find students by their ID like: findStudentById(long id) in the Cohort class
    public String findStudentById(long id) {
        String returnName = "";
        for(Student student : this.getStudents()) {
            if (student.getId() == id) {
                returnName = student.getName();
            }
        }
        return returnName;
    }


}