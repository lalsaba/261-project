import java.time.format.DateTimeFormatter;
import java.time.*;
import java.io.*;

public class Main {
    public static void main(String[] args)
            throws FileNotFoundException {

        Student s1 = new Student("leen", "123");
        Schedule schedule = new Schedule();

        Course c1 = new Course(
                "Java", "ICS108", "Eman",
                LocalDateTime.of(2026, 12, 1, 9, 0),
                LocalDateTime.of(2026, 12, 1, 10, 0),
                "mw", "22-339i");

        s1.addCourse(c1);
        schedule.addCourse(c1);

        Exam exam = new Exam(
                "Java Midterm",
                LocalDateTime.of(2026, 12, 2, 12, 0),
                LocalDateTime.of(2026, 12, 2, 13, 0),
                "high", "Room 101", c1);

        exam.setExamType("midterm");
        exam.setExamScore(95);
        exam.setCompleted();

        schedule.addActivity(exam);

        StudySession study = new StudySession(
                "Study Java",
                LocalDateTime.of(2026, 12, 3, 15, 0),
                LocalDateTime.of(2026, 12, 3, 17, 0),
                "normal");

        schedule.addActivity(study);

        Event event = new Event(
                "Workshop",
                LocalDateTime.of(2026, 12, 4, 14, 0),
                LocalDateTime.of(2026, 12, 4, 15, 0),
                "low", "academic");

        schedule.addActivity(event);
        Deadline deadline = new Deadline(
                "Java Project Submission",
                LocalDateTime.of(2026, 12, 5, 20, 0),
                LocalDateTime.of(2026, 12, 5, 23, 59),
                "high");

        schedule.addActivity(deadline);

        FileManager.saveCourses(s1.getCourseList());
        FileManager.saveActivities(schedule.getScheduleList());

        Student loadedStudent = new Student("leen", "123");
        Schedule loadedSchedule = new Schedule();

        FileManager.loadCourses(loadedStudent, loadedSchedule);
        FileManager.loadActivities(loadedSchedule, loadedStudent);

        for (Activity a : loadedSchedule.getScheduleList()) {
            if (!(a instanceof ClassSession)) {
                System.out.println(a.toFileString());
                System.out.println("Completed: " + a.isCompleted());
            }
        }
        Dashboard dashboard = new Dashboard(loadedSchedule);

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");

        System.out.println("\n===== DASHBOARD =====");

        for (Activity a : dashboard.getUpcomingAct()) {

            System.out.println("Title: " + a.getActivityTitle());
            System.out.println("Type: " + a.getTypeName());
            System.out.println("Start: " + a.getStartTime().format(format));
            System.out.println("End: " + a.getEndTime().format(format));
            System.out.println("Priority: " + a.getPriority());
            System.out.println("-------------------------");
        }

    }
}