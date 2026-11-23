import java.time.*;

void main() {
    Student s1 = new Student("leen", "123");
    Schedule schedule = new Schedule();

    Course c1 = new Course("java", "ics 108", "eman", LocalDateTime.of(2026, 12, 1, 9, 0), LocalDateTime.of(2026, 12, 1, 10, 0), "mw", "22-339i");

    s1.addCourse(c1);
    schedule.addCourse(c1);

    Event e = new Event("fun", LocalDateTime.of(2026, 12, 2, 17, 0), LocalDateTime.of(2026, 12, 2, 20, 0), "low", "hangout");

    schedule.addActivity(e);

    Event e1 = new Event("another event", LocalDateTime.of(2026, 12, 2, 17, 0), LocalDateTime.of(2026, 12, 2, 20, 0), "low", "hangout");

    schedule.addActivity(e1);

    schedule.printSchedule();
}