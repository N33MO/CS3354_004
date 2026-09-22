package Module1.JavaProgramExample;

import java.time.Year;
import java.time.LocalDate;

public class MethodOverloadingExample {
    public static void main(String[] args) {
        printDate(2026, 2, 4);
        printDate("2026", "2", "4");
        printDate(2, 4);
        printDate();
    }

    public static void printDate(int year, int month, int day) {
        System.out.printf("Date: %2d/%02d/%4d.%n", month, day, year);
    }
    public static void printDate(String year, String month, String day) {
        System.out.printf("Date: %2s/%s/%s.%n", month, day, year);
    }

    public static void printDate(int month, int day) {
        int curYear = Year.now().getValue();
        printDate(curYear, month, day);
    }

    public static void printDate() {
        LocalDate today = LocalDate.now();
        printDate(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
    }
}