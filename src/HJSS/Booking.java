package HJSS;
public class Booking {
    private String learnerName;
    private Lesson lesson;
    public String getLearnerName()
    {
        return learnerName;
    }
    public void setLearnerName(String learnerName)
    {
        this.learnerName = learnerName;
    }
    public Lesson getLesson()
    {
        return lesson;
    }
    public void setLesson(Lesson lesson)
    {
        this.lesson = lesson;
    }
}