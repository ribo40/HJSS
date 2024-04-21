//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class SwimmingSchoolTest {
//
//    @Test
//    public void displayAvailableLessonsByGradeTest() {
//        System.out.println(" Beginning Test: Display Lessons by Grade Level");
//        SwimmingSchool school = new SwimmingSchool();
//        school.addLesson(new Lesson("Monday", "5-6", 2, "Lisa", 4));
//        school.addLesson(new Lesson("Wednesday", "5-6", 2, "Mike", 3));
//        var lessonsForGradeTwo = school.getLessonsByGrade(2);
//
//        Assertions.assertTrue(lessonsForGradeTwo.stream().allMatch(lesson -> lesson.getGradeLevel() == 2),
//                "All displayed lessons should be for grade 2.");
//        System.out.println("Test Passed: Correct Lessons Displayed by Grade Level");
//    }
//
//    @Test
//    public void updateLessonDetailsTest() {
//        // Start of test to update lesson details
//        System.out.println("========= Beginning Test: Update Lesson Details ==========");
//        SwimmingSchool school = new SwimmingSchool();
//        Lesson lesson = new Lesson("Thursday", "11:00", 1, "Coach Anna", 15);
//        school.addLesson(lesson);
//
//        // Update lesson details
//        school.updateLesson(lesson, "Friday", "12:00", 1, "Coach Anna", 20);
//
//        // Assert the details are updated correctly
//        Assertions.assertEquals("Friday", lesson.getDay(), "Lesson day should be updated to Friday.");
//        Assertions.assertEquals("12:00", lesson.getTime(), "Lesson time should be updated to 12:00.");
//        Assertions.assertEquals(20, lesson.getVacancy(), "Vacancy should be updated to 20.");
//
//        // Indicate the test passed
//        System.out.println("========= Test Passed: Lesson Details Updated Successfully ==========");
//    }
//
//}
