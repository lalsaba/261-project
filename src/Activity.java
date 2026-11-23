import java.time.*;


public abstract class Activity {
    private String activityTitle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String priority;
    private boolean isCompleted;

    public Activity(String activityTitle , LocalDateTime startTime , LocalDateTime endTime , String priority ){
        this.activityTitle = activityTitle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;

    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public String getPriority() {
        return priority;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted() {
        isCompleted = true;
    }

    public void setIncomplete(){
        isCompleted = false;
    }
}


