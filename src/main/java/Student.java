import java.util.*;

public class Student extends Account {
    Random rand = new Random();
    List<Course> courses;
    static HashMap<UUID, Double> TeacherScore = new HashMap<>();
    List<Teacher> Teachers;
    String HogwartsSchool;
    String[] sch = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};

    public Student(String username, String password){
        super(username, password);
        HogwartsSchool = sch[rand.nextInt(4)];
        Teachers = new ArrayList<>();
        courses = new ArrayList<>();
    }
    public void addCourse (Course c) {
        courses.add(c);
        c.addStudent(getUsername());
        Teachers.add(c.getCourseTeacher());
    }
    public List<Course> getCourses() {
        return courses;
    }
    public List<Teacher> getTeachers() {
        return Teachers;
    }
    public void scoreTeacher(UUID uuid, Double teacherScore) {
        this.scoreTeacher(uuid, teacherScore);
    }

    public static void add(Student student) {

    }
}
