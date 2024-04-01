package HJSS;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LessonManager {
    private List<Lesson> lessons;

    public LessonManager() {
        this.lessons = new ArrayList<>();
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public List<Lesson> viewLessonsByDay(String day) {
        return lessons.stream().filter(lesson -> lesson.getDay().equalsIgnoreCase(day)).collect(Collectors.toList());
    }

    public List<Lesson> viewLessonsByGrade(int grade) {
        return lessons.stream().filter(lesson -> lesson.getGradeLevel() == grade).collect(Collectors.toList());
    }

    public List<Lesson> viewLessonsByCoach(String coachName) {
        return lessons.stream().filter(lesson -> lesson.getCoachName().equalsIgnoreCase(coachName)).collect(Collectors.toList());
    }

    public Lesson getLessonById(String lessonId) {
        return lessons.stream().filter(lesson -> lesson.getId().equals(lessonId)).findFirst().orElse(null);
    }
}
