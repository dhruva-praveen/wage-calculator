import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class main {

    static final double HOURLY_WAGE = 16.50;
    static final String[] DAYS = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String employeeName = scanner.nextLine();

        double totalHours = 0.0;

        for (String day : DAYS) {
            System.out.println(day);
            System.out.print("Enter time in (format: 9.00 for 9:00 AM): ");
            double timeIn = scanner.nextDouble();
            System.out.print("Enter time out (format: 17.30 for 5:30 PM): ");
            double timeOut = scanner.nextDouble();

            double hoursWorked = convertHours(timeOut) - convertHours(timeIn);
            if (hoursWorked < 0) {
                System.out.println("Error. Skipping this day.");
                continue;
            }

            System.out.printf("Hours worked on %s: %.2f hours%n", day, hoursWorked);
            totalHours += hoursWorked;
        }

        double totalPay = totalHours * HOURLY_WAGE;

        System.out.println("\n---------------------------");
        System.out.println("Employee: " + employeeName);
        System.out.printf("Total Hours Worked: %.2f hours%n", totalHours);
        System.out.printf("Total Weekly Pay: $%.2f%n", totalPay);
        System.out.println("---------------------------");
    }

    // Converts HH.MM to decimal hours (e.g., 8.30 → 8.5)
    public static double convertHours(double time) {
        int hours = (int) time;
        double minutes = (time - hours) * 100;
        return hours +(minutes/60);
    }
}
