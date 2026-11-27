import java.time.*;
public class Deadline extends Activity{

    public Deadline(String activityTitle , LocalDateTime start , LocalDateTime end , String priority ){
        super(activityTitle,start,end,priority);
    }
    @Override
    public String toFileString(){
        return "DEADLINE|" + super.toFileString();
    }

    @Override
    public String getTypeName() {
        return "Deadline";
    }
}
