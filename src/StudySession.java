import java.time.*;

public class StudySession extends Activity{
    public StudySession(String activityName, LocalDateTime start , LocalDateTime end , String priority){
        super(activityName ,start ,end ,priority);
    }

    @Override
    public String toFileString() {
        return "STUDY|" + super.toFileString();
    }

}