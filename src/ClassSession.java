import java.time.LocalDateTime;

public class ClassSession extends Activity {
    private Course course;

    public ClassSession(Course course, LocalDateTime start, LocalDateTime end) {
        super(course.getCourseName(), start, end, "normal");
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String getTypeName() {
        return "Class Session";
    }
}