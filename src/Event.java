import java.time.*;

public class Event extends Activity {
    private String eventType;

    public Event(String activityTitle , LocalDateTime startTime , LocalDateTime endTime , String priority ,  String eventType){
        super(activityTitle,startTime,endTime,priority);
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }

    @Override
    public String toFileString() {
        return "EVENT|" + super.toFileString() + "|" + eventType;
    }

    @Override
    public String toString() {
        return "Event: " + getActivityTitle()
                + " | Start: " + getStartTime()
                + " | End: " + getEndTime()
                + " | Priority: " + getPriority();
    }

    @Override
    public String getTypeName() {
        return "Event";
    }
}
