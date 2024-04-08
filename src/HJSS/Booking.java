package HJSS;

public class Booking {
    private final String id;
    private final Lesson lesson;
    private final Learner learner;
    private String status;
    private String review;
    private int rating;

    public Booking(String id, Lesson lesson, Learner learner) {
        this.id = id;
        this.lesson = lesson;
        this.learner = learner;
        this.status = "booked";
    }
    public void attendLesson(String reviewText, int rating) {
        this.review = reviewText;
        this.rating = rating;

    }

    public void cancelBooking() {
        this.status = "cancelled";
    }
    public String getId() {
        return id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Learner getLearner() {
        return learner;
    }

    public String getStatus() {
        return status;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}