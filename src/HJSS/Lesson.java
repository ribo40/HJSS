package HJSS;

import java.util.ArrayList;
import java.util.List;

public class Lesson {
    private String day;
    private String timeSlot;
    private int gradeLevel;
    private Coach coach;
    private List<Learner> enrolledLearners;
    private static final int MAX_LEARNERS = 4;

    // Constructor
    public Lesson(String day, String timeSlot, int gradeLevel, Coach coach) {
        this.day = day;
        this.timeSlot = timeSlot;
        this.gradeLevel = gradeLevel;
        this.coach = coach;
        this.enrolledLearners = new ArrayList<>();
        // Optionally, add this lesson to the coach's schedule
        coach.addLesson(this);
    }

    // Enroll a learner in the lesson
    public boolean enrollLearner(Learner learner) {
        if (enrolledLearners.size() < MAX_LEARNERS && !enrolledLearners.contains(learner)) {
            enrolledLearners.add(learner);
            return true;
        }
        return false;
    }

    // Remove a learner from the lesson
    public boolean leaveLearner(Learner learner) {
        return enrolledLearners.remove(learner);
    }

    // Get the number of available spots in the lesson
    public int getAvailableSpots() {
        return MAX_LEARNERS - enrolledLearners.size();
    }

    // Getters
    public String getDay() {
        return day;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public Coach getCoach() {
        return coach;
    }

    public List<Learner> getEnrolledLearners() {
        return new ArrayList<>(enrolledLearners); // Return a copy to prevent modification
    }

    // Setters
    public void setDay(String day) {
        this.day = day;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    // Utility method to print lesson details - useful for debugging and user display
    public void printLessonDetails() {
        System.out.println("Lesson: " + day + ", " + timeSlot + " | Grade: " + gradeLevel + " | Coach: " + coach.getName());
        System.out.println("Enrolled Learners: ");
        for (Learner learner : enrolledLearners) {
            System.out.println("- " + learner.getName());
        }
    }
}
