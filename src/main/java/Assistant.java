import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assistant extends Account{
    static List<Course> allCourses = new ArrayList<>() ;
    static List<Teacher> teachersInQueue = new ArrayList<>();
    private String pass;

    public Assistant (String username, String password){
        super(username, password);
    }
    public void getCoursesAndStudents(List<Course> allCourses){
        for (int i = 0 ; i < allCourses.size() ; i++){
            System.out.println(allCourses.get(i).getCourseName() + " : ");
            System.out.println( "\t" + allCourses.get(i).getStudent());
        }
    }
    public void addCourse(Course c) {
        allCourses.add(c);
    }
    public void makeCourse (String courseName, String details){
        Teacher teacher = new Teacher("" ,"");
        Course c = new Course(teacher, courseName, details);
        addCourse(c);
    }
    public static List<String> getCourseName () {
        List<String> courseName = new ArrayList<>();
        for (int i = 0 ; i < allCourses.size() ; i++){
            courseName.add(allCourses.get(i).getCourseName());
        }
        return courseName;
    }
    public void getProfile() {
        System.out.println();
    }
    public void teacherRegister () {
        Scanner input = new Scanner(System.in);
        for (int i = 0 ; i < teachersInQueue.size() ; i++){
            System.out.println(teachersInQueue.get(i).getUsername() + " , ");
        }
        System.out.println("Enter teacher name for register");
        String teacherName = input.next();
        Teacher teachert = new Teacher("", "");
        for (int i = 0 ; i < teachersInQueue.size() ; i++){
            Teacher teacher = teachersInQueue.get(i) ;
            if (teacher.getUsername().equals(teacherName)){
                teacher.signUp(this.pass);
                teachert = teacher;
            }
        }
        teachersInQueue.remove(teachert);
    }
    public static void add(Assistant assistant) {

    }
}
