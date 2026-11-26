import java.time.*;
import java.util.*;


public abstract class Activity implements Comparable<Activity> {
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

    private static final HashMap<String, Integer> priorityMap = new HashMap<>();

    static {
        priorityMap.put("high", 1);
        priorityMap.put("normal", 2);
        priorityMap.put("low", 3);
    }
    @Override
    public int compareTo(Activity other) {

        int pri1 = priorityMap.getOrDefault(
                this.priority.toLowerCase(), 2);

        int pri2 = priorityMap.getOrDefault(
                other.priority.toLowerCase(), 2);

        if (pri1 != pri2)
            return pri1 - pri2;

        return this.getStartTime().compareTo(other.getStartTime());
    }

    public String toFileString() {
        return activityTitle + "|" + startTime + "|" + endTime + "|" + priority;
    }


}


