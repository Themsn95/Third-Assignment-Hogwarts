import java.util.*;

public class Course {
    Teacher courseTeacher;
    private String courseName;
    private String details;
    private UUID courseID;
    private String teacherName;
    List<String> students;
    static HashMap<String, Double> studentScore = new HashMap<>();

    public Course(Teacher teacher, String courseName, String details) {
    }

    public void course(Teacher courseTeacher, String courseName, String details) {
        this.courseTeacher = courseTeacher;
        this.courseName = courseName;
        this.details = details;
        this.courseID = UUID.randomUUID();
        this.students = new ArrayList<>();
    }
    public void addStudent(String student) {
        this.students.add(student);
    }
    public String getCourseName(){
        return courseName;
    }

    public Teacher getCourseTeacher(){
        return courseTeacher ;
    }

    public static void add(Course course) {
    }

    public UUID getCourseID() {
        return courseID ;
    }

    public String getDetails() {
        return details;
    }

    public void changeTeacher(Teacher courseTeacher) {
        this.courseTeacher = courseTeacher ;
    }

    public List<String> getStudent() {
        return students;
    }

    public void scoring(String studentName, Double score) {
        studentScore.put(studentName, score);
    }
}
