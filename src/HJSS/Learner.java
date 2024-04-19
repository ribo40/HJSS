package HJSS;
import java.util.ArrayList;
import java.util.List;
public class Learner {
    private String name;
    private String gender;
    private int age;
    private String emergencyContact;
    private int currentGrade;
    private List<Lesson> bookedLessons;
    private List<Lesson> attendedLessons;
    private List<Lesson> cancelledLessons;
    public Learner(String name, String gender, int age, String emergencyContact, int currentGrade) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.emergencyContact = emergencyContact;
        this.currentGrade = currentGrade;
        this.bookedLessons = new ArrayList<>();
        this.attendedLessons = new ArrayList<>();
        this.cancelledLessons = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmergencyContact() {
        return emergencyContact;
    }
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
    public int getCurrentGrade()
    {
        return currentGrade;
    }
    public void setCurrentGrade(int currentGrade) {
        this.currentGrade = currentGrade;
    }
    public List<Lesson> getBookedLessons()
    {
        return bookedLessons;
    }
    public void setBookedLessons(List<Lesson> bookedLessons)
    {
        this.bookedLessons = bookedLessons;
    }
    public List<Lesson> getAttendedLessons()
    {
        return attendedLessons;
    }
    public void setAttendedLessons(List<Lesson> attendedLessons) {
        this.attendedLessons = attendedLessons;
    }
    public List<Lesson> getCanceledLessons()
    {
        return cancelledLessons;
    }
    public void setCancelledLessons(List<Lesson> canceledLessons)
    {
        this.cancelledLessons = canceledLessons;
    }
    public void bookLesson(Lesson lesson) {
        bookedLessons.add(lesson);
    }
    public void attendLesson(Lesson lesson) {
        bookedLessons.remove(lesson);
        attendedLessons.add(lesson);
    }
    public void changeBooking(Lesson oldLesson, Lesson newLesson) {
        bookedLessons.remove(oldLesson);
        bookedLessons.add(newLesson);
    }
    /*public void canceLesson(Lesson lesson) {
        bookedLessons.remove(lesson);
        cancelledLessons.add(lesson);
    }
    public int getRatingForLesson(Lesson lesson) {
        for (Lesson attendedLesson : attendedLessons) {
            if (attendedLesson.equals(lesson)) {
                return attendedLesson.getRating();
            }
        }
        return -1;
    }*/
    public void incrementGrade()
    {
        this.currentGrade++;
    }
    public void cancelBooking(Lesson lesson) {
        bookedLessons.remove(lesson);
        cancelledLessons.add(lesson);
    }

}