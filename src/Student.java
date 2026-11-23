import java.util.ArrayList;

public class Student {
    private String name;
    private String studentId;
    private ArrayList<Course> courseList;

    public Student(String name, String studentId){
        this.name = name;
        this.studentId = studentId;
        courseList = new ArrayList<>();
    }

    public ArrayList<Course> getCourseList() {
        return this.courseList;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void addCourse(Course addedCourse){
        courseList.add(addedCourse);
    }

    public void removeCourse(Course removedCourse){
        courseList.remove(removedCourse);
    }

    public void printCourses(){
        System.out.print(getName() + "'s course list:\n");
        for (Course c : courseList){
             System.out.print(c);
        }
    }

    @Override
    public String toString() {
        return "Student " + getName() +" course list: " + getCourseList();
    }

}
