package HJSS;
import java.util.Scanner;
public class Runner {
    private static final Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        SwimmingSchool swimmingSchool=new SwimmingSchool();
        while (true) {
            display();
            int choice=getIntInput("Enter your choice: ");
            if (MenuOption(choice, swimmingSchool)) {
                break;
            }
        }
        scanner.close();
    }
    private static void display() {
        System.out.println("1. Book a swimming Lesson");
        System.out.println("2. Change/Cancel a booking");
        System.out.println("3. Attend a swimming Lesson");
        System.out.println("4. Monthly learner report");
        System.out.println("5. Monthly coach report");
        System.out.println("6. Register a new learner");
        System.out.println("7. Exit");
    }

    private static boolean MenuOption(int choice, SwimmingSchool swimmingSchool) {
        switch (choice) {
            case 1:
                bookLesson(swimmingSchool);
                break;
            case 2:
                String learnerName = getStringInput("Enter learner's name:");
                swimmingSchool.handleBookingChanges(learnerName);
                break;
            case 3:
                String learnerName1 = getStringInput("Enter learner's name:");
                swimmingSchool.attendingSwimmingLesson(learnerName1);
                break;
            case 4:
            case 5:
                int month = getIntInput("Enter the month number (e.g., 3 for March):");
                if (choice == 4) {
                    swimmingSchool.monthlyReport(month);
                } else {
                    swimmingSchool.monthlyReportForCoach(month);
                }
                break;
            case 6:
                swimmingSchool.NewLearnerReg();
                break;
            case 7:
                System.out.println("Exiting...");
                return true;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        return false;
    }

    private static void bookLesson(SwimmingSchool swimmingSchool) {
        String learnerName = getStringInput("Enter your name: ");
        System.out.println("Choose an option from 1 to 3: ");
        int option = getIntInput("1. View timetable by Day\n2. View timetable by Grade level\n3. View timetable by Coach");
        processing(option, swimmingSchool, learnerName);
    }

    private static void processing(int option, SwimmingSchool swimmingSchool, String learnerName) {
        switch (option) {
            case 1:
                String day = getStringInput("Enter the Day (e.g., Monday):");
                swimmingSchool.displayTimetable("Day", day);
                break;
            case 2:
                int gradeLevel = getIntInput("Enter the grade level between 1 and 5:");
                swimmingSchool.displayTimetable("Grade level", String.valueOf(gradeLevel));
                break;
            case 3:
                String coachName = getStringInput("Enter the coach name:");
                swimmingSchool.displayTimetable("Coach", coachName);
                break;
            default:
                System.out.println("Choose a Valid Option.");
                return;
        }
        swimmingSchool.requestForBooking(scanner, learnerName);
    }

    private static String getStringInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        System.out.println(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
            }
        }
    }
}
