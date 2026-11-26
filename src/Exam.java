import java.time.*;

public class Exam extends Activity{
    private String examType = "quiz";
    private Course course;
    private String location;
    private int scorePercentage;


    public Exam(String activityName, LocalDateTime start , LocalDateTime end , String priority, String location, Course course){
        super(activityName ,start ,end ,priority);
        this.location = location;
        this.course = course;
    }

    public void setExamScore(int score){
        this.scorePercentage = score;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    @Override
    public String toFileString() {
        return "EXAM|" + super.toFileString() + "|"
                + examType + "|" + course.getCourseCode()
                + "|" + location + "|" + scorePercentage;
    }


}
