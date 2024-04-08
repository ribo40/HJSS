package HJSS;
public class Review{
    private Learner learner;
    private String reviewText;
    private int rating;
    public Review(Learner learner,String reviewText, int rating)
    {
        this.learner = learner;
        this.reviewText = reviewText;
        this.rating = rating;
    }
    public Learner getLearner() {
        return learner;
    }
    public void setLearner(Learner learner) {
        this.learner = learner;
    }
    public String getReviewText() {
        return reviewText;
    }

    public int getRating() {
        return rating;
    }
    @Override
    public String toString() {
        return "Review from " + learner.getName() + ": Rating " + rating + " - " + reviewText;
    }
}