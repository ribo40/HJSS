package HJSS;


import java.util.ArrayList;
import java.util.List;

public class LearnerManager{
    private String name;
    private List<Lesson> lessonsTaught;
    private List<Double> ratings;

    public LearnerManager() {
        this.name = name;
        this.lessonsTaught = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    // Add a lesson to the coach's schedule
    public void addLesson(Lesson lesson) {
        if (!lessonsTaught.contains(lesson)) {
            lessonsTaught.add(lesson);
        }
    }

    // Add a rating received from a learner
    public void addRating(double rating) {
        ratings.add(rating);
    }

    // Calculate the coach's average rating
    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0; // Return 0 if no ratings yet
        }
        double sum = 0;
        for (Double rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Lesson> getLessonsTaught() {
        return new ArrayList<>(lessonsTaught); // Return a copy to prevent modification
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    // Utility method to print the coach's lessons and average rating - for debug or reporting
    public void printCoachSummary() {
        System.out.println("Coach: " + name);
        System.out.println("Lessons Taught: ");
        for (Lesson lesson : lessonsTaught) {
            System.out.println("- " + lesson);
        }
        System.out.println("Average Rating: " + getAverageRating());
    }
}

