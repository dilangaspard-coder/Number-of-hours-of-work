import java.util.Scanner;
import java.time.LocalDate;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

public static boolean isValidDate(int day, int month, int year) {
    if (year < 1 || month < 1 || month > 12 || day < 1) {
        return false;
    }

    int daysInMonth;

    switch (month) {
        case 4, 6, 9, 11:
            daysInMonth = 30;
            break;

        case 2:
            boolean leapYear = (year % 400 == 0) ||
                    (year % 4 == 0 && year % 100 != 0);

            daysInMonth = leapYear ? 29 : 28;
            break;

        default:
            daysInMonth = 31;
    }

    return day <= daysInMonth;
}

public static int [] chooseDate(Scanner scanner){
    System.out.println("Choose a date, when you want your objectif to be reached :");
        System.out.println("");
        System.out.println("Give the day (valid days): ");
        System.out.println("");
        int day = scanner.nextInt();
        System.out.println("");
        System.out.println("Give the month (between 1 - 12):");
        System.out.println("");
        int month = scanner.nextInt();
        System.out.println("");
        System.out.println("Give the year :");
        int year = scanner.nextInt();
        System.out.println("");
        int [] date = new int [3];
        date [0] = day;
        date [1] = month;
        date [2] = year;
        return date;
}
    

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    LocalDate today = LocalDate.now();

    System.out.println("Give me your name:");
    String name = scanner.nextLine();

    System.out.println("Give me your working hours objectif:");
    int objectif = scanner.nextInt();

    Count count = new Count(name, 0, objectif);

    int[] inDate = chooseDate(scanner);

    // Check if date is valid
    while (!isValidDate(inDate[0], inDate[1], inDate[2])) {
        System.out.println("Invalid date. Choose again!");
        inDate = chooseDate(scanner);
    }

    // Convert array to LocalDate
    LocalDate deadline = LocalDate.of(inDate[2], inDate[1], inDate[0]);

    // Check deadline
    if (today.isAfter(deadline)) {
        System.out.println("Deadline already passed!");
    } 
    else {
        System.out.println("Put the hours you did today!");

        int todayHours = scanner.nextInt();

        if (todayHours >= 0) {
            count.todayHours(todayHours, count);
            try (FileWriter writer = new FileWriter("HoursNumber.txt", true)) {
                writer.write(LocalDate.now() + " : " + todayHours + "\n");
            } 
            catch (IOException e) {
                System.out.println("Error saving hours!");
            }

            System.out.println("Good job! See you soon!");
            System.out.println("Total hours: " + count.hours);
            System.out.println("Objective: " + count.objectif);
        } 
        else {
            System.out.println("Invalid number of hours!");
        }
    }

    scanner.close();
}

}
