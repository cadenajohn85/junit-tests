import java.util.ArrayList;

public class Student {

    private long id;
    private String name;
    private ArrayList<Integer> grades;


    public Student(long studentID, String studentName) {
        this.id = studentID;
        this.name = studentName;
        this.grades = new ArrayList<>();
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Integer> getGrades() {
        return this.grades;
    }


    public void addGrade(int newGrade) {
        this.grades.add(newGrade);
    }

    public double getGradeAverage() {
        int total = 0;
        for (int grade : this.grades) {
            total += grade;
        }
        return (double) total / this.grades.size();
    }
}
