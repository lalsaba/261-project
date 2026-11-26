import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    public static void saveCourses(ArrayList<Course> courses) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("courses.txt");

        for(Course c : courses){
            writer.println(c.toFileString());
        }

        writer.close();
    }

    public static void saveActivities(ArrayList<Activity> activities) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("activities.txt");
        for (Activity a : activities){
            if (!(a instanceof ClassSession)) {
                writer.println(a.toFileString());
            }
        }

        writer.close();
    }


    public static void loadCourses(Student student, Schedule schedule) throws FileNotFoundException {

        File file = new File("courses.txt");

        if (!file.exists()) {
            return;
        }

        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String line = reader.nextLine();

            String[] data = line.split("\\|");

            Course course = new Course(data[0], data[1], data[2], LocalDateTime.parse(data[3]), LocalDateTime.parse(data[4]), data[5], data[6]);

            student.addCourse(course);
            schedule.addCourse(course);
        }

        reader.close();
    }


    public static void loadActivities(Schedule schedule, Student student) throws FileNotFoundException {

        File file = new File("activities.txt");

        if (!file.exists()) {
            return;
        }

        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {

            String line = reader.nextLine();
            String[] data = line.split("\\|");

            String type = data[0];

            String title = data[1];
            LocalDateTime start = LocalDateTime.parse(data[2]);
            LocalDateTime end = LocalDateTime.parse(data[3]);
            String priority = data[4];

            Activity activity = null;

            if (type.equals("EVENT")) {

                activity = new Event(
                        title, start, end, priority, data[5]
                );

            } else if (type.equals("STUDY")) {

                activity = new StudySession(
                        title, start, end, priority
                );

            } else if (type.equals("EXAM")) {

                Course course = null;

                for (Course c : student.getCourseList()) {
                    if (c.getCourseCode().equals(data[6])) {
                        course = c;
                        break;
                    }
                }

                if (course != null) {
                    Exam exam = new Exam(
                            title, start, end, priority,
                            data[7], course
                    );

                    exam.setExamType(data[5]);
                    exam.setExamScore(Integer.parseInt(data[8]));

                    activity = exam;
                }
            }

            if (activity != null) {
                schedule.addActivity(activity);
            }
        }

        reader.close();
    }

}
