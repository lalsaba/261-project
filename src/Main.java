
import java.time.*;
import java.io.*;

void main() throws FileNotFoundException {

    Student s1 = new Student("leen", "123");
    Schedule schedule = new Schedule();

    Course c1 = new Course("java", "ics 108", "eman",
            LocalDateTime.of(2026, 12, 1, 9, 0),
            LocalDateTime.of(2026, 12, 1, 10, 0),
            "mw", "22-339i");

    s1.addCourse(c1);
    schedule.addCourse(c1);

    Event e = new Event("fun",
            LocalDateTime.of(2026, 12, 2, 17, 0),
            LocalDateTime.of(2026, 12, 2, 20, 0),
            "low", "hangout");

    schedule.addActivity(e);

    Event e1 = new Event("another event",
            LocalDateTime.of(2026, 12, 2, 17, 0),
            LocalDateTime.of(2026, 12, 2, 20, 0),
            "low", "hangout");

    schedule.addActivity(e1);

    schedule.printSchedule();

    schedule.addActivity(new Event(
            "Workshop",
            LocalDateTime.of(2026, 12, 3, 18, 0),
            LocalDateTime.of(2026, 12, 3, 19, 0),
            "low", "academic"));

    schedule.addActivity(new Event(
            "Project Meeting",
            LocalDateTime.of(2026, 12, 5, 18, 0),
            LocalDateTime.of(2026, 12, 5, 19, 0),
            "high", "academic"));

    schedule.addActivity(new Event(
            "Family Gathering",
            LocalDateTime.of(2026, 12, 4, 18, 0),
            LocalDateTime.of(2026, 12, 4, 19, 0),
            "NormAl", "personal"));

    schedule.addActivity(new Event(
            "Presentation",
            LocalDateTime.of(2026, 12, 3, 20, 0),
            LocalDateTime.of(2026, 12, 3, 21, 0),
            "high", "academic"));

    System.out.println("Prioritized Activities:");

    for (Activity a : schedule.getPriAct()) {
        System.out.println(a);
    }


    FileManager.saveCourses(s1.getCourseList());
    FileManager.saveActivities(schedule.getScheduleList());

    System.out.println("\nData saved successfully!");
}
