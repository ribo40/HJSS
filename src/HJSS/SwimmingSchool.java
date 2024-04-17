package HJSS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
public class SwimmingSchool {
    private List<Lesson> lessons;
    private List<Learner> learners;
    private List<Coach> coaches;
    public List<Lesson> getLessons() {
        return lessons;
    }
    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
    public List<Learner> getLearners() {
        return learners;
    }
    public void setLearners(List<Learner> learners) {
        this.learners = learners;
    }
    public List<Coach> getCoaches() {
        return coaches;
    }
    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }
    public SwimmingSchool()
    {
        this.lessons = new ArrayList<>();
        Defaultlessons();
        this.learners = new ArrayList<>();
        defaultLearners();
        this.coaches = new ArrayList<>();
        defaultCoaches();
    }
    private void Defaultlessons() {
        String fileN="C:\\Users\\User\\IdeaProjects\\HJSS\\src\\HJSS\\Lessons\\Schedule.txt";
        try {
            BufferedReader reader=new BufferedReader(new FileReader(fileN));
            int grade;
            int week;
            String ln;
            while ((ln=reader.readLine()) != null) {
                String[] l =ln.split(",");
                week = Integer.parseInt(l[0]);
                grade = Integer.parseInt(l[3]);
                Lesson less = new Lesson(l[1], l[2], grade, l[4].trim());
                less.setWeek(week);
                lessons.add(less);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
    public void addLesson(Lesson lesson)
    {
        lessons.add(lesson);
    }
    public void addNewLesson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the day:");
        String day = scanner.nextLine();
        System.out.println("Enter the time:");
        String time = scanner.nextLine();
        System.out.println("Enter the grade level:");
        int gradeLevel = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the coach name:");
        String coach = scanner.nextLine();
        System.out.println("Enter the vacancy of the lesson:");
        int vacancy = scanner.nextInt();
        scanner.nextLine();
        Lesson lesson = new Lesson(day, time, gradeLevel, coach, vacancy);
        addLesson(lesson);
        System.out.println("Lesson added successfully.");
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }
    public void addNewCoach() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the coach:");
        String name = scanner.nextLine();
        Coach coach = new Coach(name);
        addCoach(coach);
        System.out.println("Coach successfully added.");
    }

    public void addLearner(Learner learner)
    {
        learners.add(learner);
    }
    public void displayTimetableByGradeLevel(int gradeLevel) {
        System.out.println("Available Lessons for the Grade Level " + gradeLevel + ":");
        for (Lesson lesson : lessons) {
            if (lesson.getGradeLevel() == gradeLevel) {
                System.out.println("Day: " + lesson.getDay() + ", Time: " + lesson.getTime() + ", Coach: "
                        + lesson.getCoach() + ", Vacancy: " + lesson.getVacancy());
            }
        }
    }

    private Lesson findLessonByGradeLevelAndTime(int gradeLevel, String lessonTime) {
        for (Lesson lesson : lessons) {
            if (lesson.getGradeLevel() == gradeLevel && lesson.getTime().equalsIgnoreCase(lessonTime))
            {
                return lesson;
            }
        }
        return null;
    }
    public Learner findLearnerByName(String learnerName) {
        for (Learner learner : learners)
        {
            if (learner.getName().equalsIgnoreCase(learnerName))
            {
                return learner;
            }
        }
        return null;
    }
    public void displayTimetable(String day, String filterValue) {
        System.out.println("Timetable for " + day + ": " + filterValue);
        System.out.println("\n");
        System.out.println("Week\tDay\t\t\t  Time\tGrade Level\tCoach\tVacancy");
        for (Lesson lesson : lessons) {
            boolean match = false;
            if(day.equalsIgnoreCase("day"))
            {
                match = lesson.getDay().equalsIgnoreCase(filterValue);
            }
            else if(day.equalsIgnoreCase("coach")) {
                match = lesson.getCoach().equalsIgnoreCase(filterValue);
            }
            else if(day.equalsIgnoreCase("grade level")) {
                match = lesson.getGradeLevel() == Integer.parseInt(filterValue);
            }
            if (match) {
                System.out.println(lesson.getWeek()
                        + "\t\t" + lesson.getDay()
                        + "\t\t  " + lesson.getTime()
                        + "\t\t" + lesson.getGradeLevel()
                        + "\t\t" + lesson.getCoach()
                        + "\t\t" + (4 - lesson.getLearners().size()));
            }
        }
        System.out.println("\n");
    }
    public void requestForBooking(Scanner scanner, String learnerName) {
        Learner learner = findLearnerByName(learnerName);
        if (learner == null) {
            System.out.println("Learner Not registered");
            return;
        }
        System.out.println("Enter the Week number: ");
        int sel_week = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter  Day: ");
        String sel_day = scanner.nextLine();
        System.out.println("Enter Time:");
        String sel_slot = scanner.nextLine();
        System.out.println("Enter Grade:");
        int sel_grade = scanner.nextInt();
        scanner.nextLine();
        if (learner.getCurrentGrade() < sel_grade - 1) {
            //System.out.println("");
            System.out.println("You are ineligible for this grade.");
        }
        Optional<Lesson> first = this.lessons.stream().filter(lesson -> (lesson.getWeek() == sel_week
                        && lesson.getDay().equals(sel_day)
                        && lesson.getTime().equals(sel_slot)
                        && lesson.getGradeLevel() == sel_grade))
                .findFirst();
        if (first.isEmpty()) {
            System.out.println(".................");
            System.out.println("Lesson Not Found!");
        } else {
            if (first.get().getLearners().size() < 4) {
                first.get().getLearners().add(learner);
                learner.getBookedLessons().add(first.get());
                System.out.println("...................");
                System.out.println("Booking Successfull");
            } else {
                System.out.println("....................");
                System.out.println("Maximum: 4 Allowed!");
                System.out.println("Booking Unsuccessful");
            }
        }
    }
    public void NewLearnerReg() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter your age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        if(age<4 || age>11)
        {
            System.out.println("Age must be between 4 and 11");
            return;
        }
        System.out.println("Enter your emergency contact: ");
        String emergencyContact = scanner.nextLine();
        System.out.println("Enter your current grade level: ");
        int currentGrade = scanner.nextInt();
        scanner.nextLine();
        Learner learner = new Learner(name, gender, age, emergencyContact, currentGrade);
        addLearner(learner);
        System.out.println("New learner successfully enrolled.");
        System.out.println("***********************************************");
    }
    public void attendingSwimmingLesson(String learnerName) {
        Learner learner = findLearnerByName(learnerName);
        if (learner == null) {
            System.out.println(learnerName + "Not Registered");
            return;
        }
        System.out.println("List of " + learnerName + "'s Booked Lessons");
        if (learner.getBookedLessons().size() < 1)
        {
            System.out.println(learnerName + " has no Lessons to attend");
            return;
        }
        System.out.println("************************************************");
        learner.getBookedLessons().forEach(bookedLesson -> System.out.println(bookedLesson.toString()));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the week:");
        int week = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the day:");
        String day = scanner.nextLine();
        System.out.println("Please enter the time:");
        String timeSlot = scanner.nextLine();
        Lesson lesson=getLessonByDayTimeGrade(day, timeSlot, week);
        if (lesson != null) {
            if (learner != null) {
                if (lesson.getLearners().contains(learner)) {
                    System.out.println(learnerName + "successfully attended the lesson.\n");
                    System.out.println("1: Very dissatisfied \n"
                            + " 2: Dissatisfied\n"
                            + " 3: Ok\n"
                            + " 4: Satisfied\n"
                            + " 5: Very Satisfied\n");
                    System.out.println("Assign a Rating to the Coach: 1 to 5 ");
                    int rating = scanner.nextInt();
                    scanner.nextLine();
                    Optional<Coach> coach = this.coaches.stream()
                            .filter(coach1 -> coach1.getName().equals(lesson.getCoach())).findFirst();
                    if (!coach.isEmpty())
                    {
                        try {
                            lesson.setRating(rating);
                            coach.get().getLessonsTaught().add((Lesson) lesson.clone());
                        } catch (CloneNotSupportedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    lesson.getLearners().remove(learner);
                    learner.attendLesson(lesson);
                    learner.incrementGrade();
                }
                else
                {
                    System.out.println(learnerName + " hasn't booked this lesson.");
                }
            }
            else
            {
                System.out.println("Learner not found.");
            }
        }
        else
        {
            System.out.println("Lesson not found.");
        }
    }
    private Lesson getLessonByDayTimeGrade(String day, String timeSlot, int week) {
        for (Lesson lesson : lessons)
        {
            if (lesson.getDay().equalsIgnoreCase(day) && lesson.getTime().equalsIgnoreCase(timeSlot)
                    && lesson.getWeek() == week)
            {
                return lesson;
            }
        }
        return null;
    }
    private Lesson getLessonByWeekDayTimeGrade(String day, String timeSlot, int week, int grade)
    {
        for(Lesson lesson : lessons)
        {
            if(lesson.getDay().equalsIgnoreCase(day) && lesson.getTime().equalsIgnoreCase(timeSlot)
                    && lesson.getWeek()==week && lesson.getGradeLevel() == grade)
            {
                return lesson;
            }
        }
        return null;
    }
    //Change/cancel booking
    public void handleBookingChanges(String learnerName)
    {
        Learner learner = findLearnerByName(learnerName);
        if(learner==null)
        {
            System.out.println(learnerName + "Not Registered");
            return;
        }
        System.out.println("List of " + learnerName + "'s booking lessons");
        if (learner.getBookedLessons().size()< 1)
        {
            System.out.println(learnerName + " has no booked Lesson");
            return;
        }
        learner.getBookedLessons().forEach(bookedLesson -> System.out.println(bookedLesson.toString()));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the week:");
        int week = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the day:");
        String day = scanner.nextLine();
        System.out.println("Enter the time:");
        String timeSlot = scanner.nextLine();
        Lesson lesson =getLessonByDayTimeGrade(day, timeSlot, week);
        if (lesson != null)
        {
            if (lesson.getLearners().contains(learner))
            {
                System.out.println("change or cancel the booking");
                System.out.println("1.Change booking");
                System.out.println("2.Cancel booking");
                int ch=scanner.nextInt();
                scanner.nextLine();
                switch (ch)
                {
                    case 1:
                        updateBooking(learner, lesson);
                        break;
                    case 2:
                        cancelBooking(learner, lesson);
                        break;
                    default:
                        System.out.println("Please choose another option.");
                }
            }
            else
            {
                System.out.println(learnerName + " is not booked for this lesson.");
            }
        }
        else
        {
            System.out.println("Lesson not found.");
        }
    }
    private void cancelBooking(Learner learner, Lesson lesson)
    {
        lesson.getLearners().remove(learner);
        learner.cancelBooking(lesson);
        System.out.println("Booking cancelled successfully.");
    }
    //change booking
    private void updateBooking(Learner learner, Lesson lesson) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new week :");
        int NewWeek = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new day :");
        String newDay = scanner.nextLine();
        System.out.println("Enter the new time :");
        String newTime= scanner.nextLine();
        System.out.println("Enter the new grade level:");
        int newGrad= scanner.nextInt();
        scanner.nextLine();
        Lesson newLesson=getLessonByWeekDayTimeGrade(newDay, newTime, NewWeek, newGrad);
        if (newLesson != null) {
            if (newLesson.addLearner(learner))
            {
                lesson.getLearners().remove(learner);
                learner.changeBooking(lesson, newLesson);
                System.out.println("Booking successfully changed.");
            }
            else
            {
                System.out.println("The lesson is fully booked. Booking change failed.");
            }
        }
        else
        {
            System.out.println("New lesson not found.");
        }
    }

    private void defaultLearners() {
        Learner learner = new Learner("Mina", "Female", 7, "0123456789", 3);
        addLearner(learner);
        learner = new Learner("Rima", "Female", 5, "0123456789", 1);
        addLearner(learner);
        learner = new Learner("Sakib", "Male", 6, "0134567899", 2);
        addLearner(learner);
        learner = new Learner("Anika", "Female", 9, "0123456783", 5);
        addLearner(learner);
        learner = new Learner("Raja", "Male", 8, "01234567894", 4);
        addLearner(learner);
        learner = new Learner("Raju", "Male", 5, "01234567994", 2);
        addLearner(learner);
    }
    private void defaultCoaches(){
        this.coaches.add(new Coach("Helen"));
        this.coaches.add(new Coach("John"));
        this.coaches.add(new Coach("David"));
    }
}