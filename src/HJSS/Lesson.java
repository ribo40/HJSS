package HJSS;

public class Lesson {
    private int id;
    private int gradeLevel;
    private String dayOfWeek;
    private String timeSlot;
    private int coachId;
    public Lesson(int id, int gradeLevel, String dayOfWeek, String timeSlot, int coachId) {
        this.id = id;
        this.gradeLevel = gradeLevel;
        this.dayOfWeek = dayOfWeek;
        this.timeSlot = timeSlot;
        this.coachId = coachId;
    }
    public int getId() {
        return id;
    }

    // Setter for ID
    public void setId(int id) {
        this.id = id;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }
    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTimeSlot() {
        return timeSlot;
    }
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }
}
