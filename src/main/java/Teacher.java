import java.util.*;

public class Teacher extends Account {
    List<Course> courses ;
    private String pass;
    List<HashMap<UUID, Double>> scores = new ArrayList<>();

    public static void add(Teacher teacher) {

    }
    public void signUp(String pass) {
        signUp(this.pass);
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public Teacher(String username, String password){
        super(username,password);
        courses = new ArrayList<>();
    }
    public void addCourse(Course course, Teacher teacher) {
        courses.add(course);
        course.changeTeacher(course.getCourseTeacher());
        for (int i = 0 ; i < course.getStudent().size() ; i++){
            for (int j = 0 ; j < Hogwarts.students.size() ; j++){
                if(Hogwarts.students.get(j).getUsername().equals(course.getStudent().get(i))){
                    Hogwarts.students.get(j).Teachers.add(course.courseTeacher);
                }
            }
        }
        for (int i = 0 ; i < Hogwarts.courses.size() ; i++){
            if (Hogwarts.courses.get(i).getCourseID().equals(course.getCourseID())){
                Hogwarts.courses.get(i).changeTeacher(teacher);
            }
        }
    }
    public void addcourse (String coursename, List<Course> allCourses, Teacher teacher){
        for (int i = 0 ; i < allCourses.size() ; i++){
            if (allCourses.get(i).getCourseName().equals(coursename)){
                addCourse(allCourses.get(i), teacher);
            }
        }
    }
    public void scoring (){
        Scanner input = new Scanner(System.in);
        for (int i = 0 ; i < courses.size() ; i++){
            System.out.println(courses.get(i).getCourseName() + " , ");
        }
        System.out.println("Enter the course name ");
        String cn = input.next();
        for (int i = 0 ; i < courses.size() ; i++){
            if (courses.get(i).getCourseName().equals(cn)){
                System.out.println(courses.get(i).getStudent());
                System.out.println("Enter the scores of students ");
                for (int j = 0 ; j < courses.get(i).getStudent().size() ; j++){
                    String studentName = courses.get(i).getStudent().get(j) ;
                    Double sc = input.nextDouble();
                    courses.get(i).scoring(studentName, sc);
                }
            }
        }
    }
    public void getStudent () {
        Scanner input = new Scanner(System.in);
        for (int  i = 0 ; i < courses.size() ; i++){
            System.out.print(courses.get(i).getCourseName() + " , ");
        }
        System.out.println("Enter the course name : ");
        String cn = input.next();
        for (int i = 0 ; i < courses.size() ; i++){
            if (courses.get(i).getCourseName().equals(cn)){
                System.out.println(courses.get(i).getStudent());
            }
        }
    }
    public void getCourses () {
        for (int i = 0 ; i < courses.size() ; i++){
            System.out.println(courses.get(i).getCourseName());
        }
    }
    public void addTeacherScore (Course course, Double TeacherScore){
        HashMap<UUID,Double> save = new HashMap<>() ;
        save.put(course.getCourseID(), TeacherScore);
        this.scores.add(save);
    }
    public void getTeacherScore () {
        for (int i = 0 ; i < courses.size() ; i++) {
            System.out.println(courses.get(i).getCourseName() + " " + courses.get(i).getCourseID() + " : ");
            Double TeacherScore = 0.0, c = 0.0;
            for (int j = 0; j < scores.size(); j++) {
                if (scores.get(j).get(courses.get(i).getCourseID()) != null) {
                    c += 1.0;
                    TeacherScore += scores.get(j).get(courses.get(i).getCourseID());
                }
            }
            if (c == 0.0) {
                System.out.println("Score not exist");
            } else {
                System.out.println(TeacherScore / c);
            }
        }
    }
}
