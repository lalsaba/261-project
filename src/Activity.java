import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Activity {
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    boolean isCompleted;

}

