import java.util.*;
import java.time.*;
public class Dashboard {

    private Schedule schedule;

    public Dashboard(Schedule schedule){
        this.schedule = schedule;
    }
    public ArrayList<Activity> getUpcomingAct() {
        ArrayList<Activity> upcomig = new ArrayList<>();

    for(Activity a : schedule.getScheduleList()){
        if(!a.isCompleted()
                && !( a instanceof ClassSession)
                && a.getEndTime().isAfter(LocalDateTime.now())){
            upcomig.add(a);
        }
     } upcomig.sort(Comparator.comparing(Activity::getStartTime));
    return upcomig;
    }
}
