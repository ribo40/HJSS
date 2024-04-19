package HJSS;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        SwimmingSchool swimmingSchool = new SwimmingSchool();
        Scanner in=new Scanner(System.in);
        while (true) {
            System.out.println("1. Book a swimming Lesson");
            System.out.println("2. Change/Cancel a booking");
            System.out.println("3. Attend a swimming Lesson");
            System.out.println("4. Monthly learner report");
            System.out.println("5. Monthly coach report");
            System.out.println("6. Register a new learner");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            int ch=in.nextInt();
            in.nextLine();
            switch (ch) {
                case 1:
                    bookLesson(swimmingSchool,in);
                    break;
                case 2:
                    System.out.println("Enter learner's name:");
                    String learnerName =in.nextLine();
                    swimmingSchool.handleBookingChanges(learnerName);
                    break;
                case 3:
                    System.out.println("Enter learner's name:");
                    String learnerName1 =in.nextLine();
                    swimmingSchool.attendingSwimmingLesson(learnerName1);
                    break;
                case 4:
                    System.out.println("Enter the month number (e.g., 3 for March):");
                    int month =in.nextInt();
                    in.nextLine();
                    swimmingSchool.monthlyReport(month);
                    break;
                case 5:
                    System.out.println("Enter the month number (e.g., 3 for March): ");
                    int month1 =in.nextInt();
                    in.nextLine();
                    swimmingSchool.monthlyReportForCoach(month1);
                    break;
                case 6:
                    swimmingSchool.NewLearnerReg();
                    break;

                case 7:
                    System.out.println("Exit");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void bookLesson(SwimmingSchool swimmingSchool, Scanner scanner) {
        System.out.println("Enter your name:\n");
        String learnerName = scanner.nextLine();
        System.out.println("1. View timetable by Day");
        System.out.println("2. View timetable by Grade level");
        System.out.println("3. View timetable by Coach");
        System.out.println("Choose option from 1 to 3: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        String Value;
        switch (option) {
            case 1:
                System.out.println("Enter the Day (e.g., Monday) :");
                Value = scanner.nextLine();
                swimmingSchool.displayTimetable("Day",Value);
                swimmingSchool.requestForBooking(scanner,learnerName);
                break;
            case 2:
                System.out.println("Enter the grade level between 1 and 5: ");
                int gradeLevel = scanner.nextInt();
                scanner.nextLine();
                swimmingSchool.displayTimetable("Grade level", String.valueOf(gradeLevel));
                swimmingSchool.requestForBooking(scanner,learnerName);
                break;
            case 3:
                System.out.println("Enter the coach name: ");
                Value = scanner.nextLine();
                swimmingSchool.displayTimetable("Coach",Value);
                swimmingSchool.requestForBooking(scanner,learnerName);
                break;
            default:
                System.out.println("Choose a Valid Option.");
                return;
        }
    }
}