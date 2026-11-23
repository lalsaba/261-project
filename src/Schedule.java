import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Schedule {
    private ArrayList<Activity> scheduleList;

    public Schedule() {
        scheduleList = new ArrayList<>();
    }

    public boolean hasConflict(Activity newActivity) {
        for (Activity existing : scheduleList) {
            if (newActivity.getStartTime().isBefore(existing.getEndTime())
                    && existing.getStartTime().isBefore(newActivity.getEndTime())) {
                return true;
            }
        }
        return false;
    }

    public void addActivity(Activity added) {
        if (!added.getEndTime().isAfter(added.getStartTime())) {
            System.out.println("End must be after start.");
        } else if (hasConflict(added)) {
            System.out.println("Time conflict: " + added.getActivityTitle() + " on " + added.getStartTime().toLocalDate());
        } else {
            scheduleList.add(added);
        }
    }

    public void addCourse(Course c) {
        String days = c.getMeetingDays();

        if (!days.equalsIgnoreCase("mw")
                && !days.equalsIgnoreCase("ut")
                && !days.equalsIgnoreCase("utr")) {
            System.out.println("enter mw ut utr");
            return;
        }

        LocalTime start = c.getStartTime().toLocalTime();
        LocalTime end = c.getEndTime().toLocalTime();


        LocalDate firstDate = LocalDate.of(2026, 12, 1);
        LocalDate lastDate = LocalDate.of(2026, 12, 31);

        while (!firstDate.isAfter(lastDate)) {
            DayOfWeek day = firstDate.getDayOfWeek();
            boolean matches = false;

            if (days.equalsIgnoreCase("mw")) {
                if (day == DayOfWeek.MONDAY || day == DayOfWeek.WEDNESDAY) {
                    matches = true;
                }
            } else if (days.equalsIgnoreCase("ut")) {
                if (day == DayOfWeek.SUNDAY || day == DayOfWeek.TUESDAY) {
                    matches = true;
                }
            } else if (days.equalsIgnoreCase("utr")) {
                if (day == DayOfWeek.SUNDAY || day == DayOfWeek.TUESDAY || day == DayOfWeek.THURSDAY) {
                    matches = true;
                }
            }

            if (matches) {
                LocalDateTime meetingStart = firstDate.atTime(start);
                LocalDateTime meetingEnd = firstDate.atTime(end);

                ClassSession meeting = new ClassSession(c, meetingStart, meetingEnd);

                addActivity(meeting);
            }

            firstDate = firstDate.plusDays(1);
        }
    }

    public void printSchedule() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate firstDate = LocalDate.of(2026, 12, 1);
        LocalDate lastDate = LocalDate.of(2026, 12, 31);

        while (!firstDate.isAfter(lastDate)) {
            DayOfWeek day = firstDate.getDayOfWeek();

            if (day != DayOfWeek.FRIDAY && day != DayOfWeek.SATURDAY) {

                System.out.println("\n" + firstDate.format(dateFormat));


                for (Activity a : scheduleList) {
                    if (a.getStartTime().toLocalDate().equals(firstDate)) {
                        String type;

                        if (a instanceof ClassSession) {
                            type = "Course";
                        } else if (a instanceof Exam) {
                            type = "Exam";
                        } else if (a instanceof StudySession) {
                            type = "Study session";
                        } else if (a instanceof Event) {
                            type = "Event";
                        } else {
                            type = "Activity";
                        }

                        System.out.println(
                                a.getStartTime().format(timeFormat) + " - " + a.getEndTime().format(timeFormat) + " | " + type + ": " + a.getActivityTitle()
                        );


                    }
                }


            }

            firstDate = firstDate.plusDays(1);
        }
    }
}