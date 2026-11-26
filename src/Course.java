import java.time.*;


public class Course {
    private String courseName;
    private String courseCode;
    private String courseInstructor;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String meetingDays;
    private String location;

    public Course(String courseName, String courseCode, String courseInstructor, LocalDateTime startTime , LocalDateTime endTime , String meetingDays, String location){
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseInstructor = courseInstructor;
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingDays= meetingDays;
        this.location = location;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getMeetingDays(){
        return this.meetingDays;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString(){
        return "Course name: "+ getCourseName() + " | Course code: " + getCourseCode()  + "\n";
    }


    public String toFileString() {
        return courseName + "|" + courseCode + "|" + courseInstructor
                + "|" + startTime + "|" + endTime
                + "|" + meetingDays + "|" + location;
    }
}
