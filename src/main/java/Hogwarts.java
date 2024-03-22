import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Hogwarts {

    // TODO: Define Attributes
    static List<Assistant> Assistant = new ArrayList<>();
    static List<Student> students = new ArrayList<>();
    static List<Teacher> teachers = new List<>() ;
    static List<Course> courses = new List<>();
    public void AddAssistant (Assistant assistant){
        Assistant.add(assistant);
    }
    public void AddStudent (Student student){
        Student.add(student);
    }
    public void AddTeacher (Teacher teacher){
        Teacher.add(teacher);
    }
    public void AddCourse (Course course){
        Course.add(course);
    }
    public void CourseReq (Teacher teacher, Course courseName){
        if (courseName.getCourseTeacher().getUsername().equals("")){
            courseName.courseTeacher.changeUsername(teacher.getUsername());
        }
        else {
            System.out.println("Access Denied");
        }
    }


    public static void addAssistant(Assistant assistant) {
        Assistant.add(assistant);
    }
    // TODO: Define Functionalities
    public static void viewAllTeachers() {
        //TODO
        for (int i = 0 ; i < teachers.size() ; i++){
            System.out.println(teachers.get(i).getUsername());
        }
    }

    public void viewAllStudents() {
        //TODO
        for (int i = 0 ; i < students.size() ; i++){
            System.out.println(students.get(i).getUsername());
        }
    }

    public void viewAllCourses() {
        //TODO
        for (int i = 0 ; i < courses.size() ; i++){
            System.out.println(courses.get(i).getCourseName());
        }
    }
    public static void CourseRequest(Teacher teacher){
        Scanner input = new Scanner(System.in);
        for (int i = 0 ; i < Hogwarts.courses.size() ; i++){
            if (courses.get(i).courseTeacher.getUsername().equals(""))
                System.out.println(courses.get(i).courseTeacher.getUsername() + " - " + courses.get(i).getCourseID() + " Details : " + Hogwarts.courses.get(i).getDetails());
        }
        System.out.println("Enter UUID for get the corse");
        String a = input.next();
        for (int i = 0 ; i < Hogwarts.courses.size() ; i++){
            if (!courses.get(i).courseTeacher.getUsername().equals("") && courses.get(i).getCourseID().toString().equals(a)){
                System.out.println("Access Denide");
            }
            else if (courses.get(i).courseTeacher.getUsername().equals("") && courses.get(i).getCourseID().toString().equals(a)){
                teacher.addCourse(courses.get(i), teacher);
            }
        }
    }
    public static void Scoring(Teacher teacher) {
        teacher.scoring();
    }
    public static void GetCourseViaUUID(UUID uuid) {
        for (int i = 0 ; i < courses.size() ; i++){
            if (courses.get(i).getCourseID().equals(uuid)){
                System.out.println(courses.get(i).getCourseName());
                System.out.println("Teacher : " + courses.get(i).courseTeacher.getUsername());
                System.out.println("Students : ");
                System.out.print("\t");
                for (int j = 0 ; courses.get(i).getStudent().size() ; j++){
                    System.out.println(courses.get(i).getStudent().get(j));
                }
            }
        }
    }
}
