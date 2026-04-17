package JavaBasics.src;

import java.util.Scanner;

public class Days {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String monthInput;
        String yearInput;
        int month;
        System.out.print("Enter month: ");
            monthInput = sc.nextLine().trim();
            System.out.print("Enter year: ");
            yearInput = sc.nextLine().trim();

            month = getMonthNumber(monthInput);
            if (month == -1) {
                System.exit(0);
            }
            int year = Integer.parseInt(yearInput);
            int days = calculateDays(month, year);
            System.out.println("Number of days in " + monthInput + "/" + year + " is: " + days);


        sc.close();
    }

    private static int getMonthNumber(String input) {
        String lower = input.toLowerCase();
        if (lower.equals("january") || lower.equals("jan.") || lower.equals("jan") || lower.equals("1")) return 1;
        if (lower.equals("february") || lower.equals("feb.") || lower.equals("feb") || lower.equals("2")) return 2;
        if (lower.equals("march") || lower.equals("mar.") || lower.equals("mar") || lower.equals("3")) return 3;
        if (lower.equals("april") || lower.equals("apr.") || lower.equals("apr") || lower.equals("4")) return 4;
        if (lower.equals("may") || lower.equals("5")) return 5;
        if (lower.equals("june") || lower.equals("jun.") || lower.equals("jun") || lower.equals("6")) return 6;
        if (lower.equals("july") || lower.equals("jul.") || lower.equals("jul") || lower.equals("7")) return 7;
        if (lower.equals("august") || lower.equals("aug.") || lower.equals("aug") || lower.equals("8")) return 8;
        if (lower.equals("september") || lower.equals("sep.") || lower.equals("sep") || lower.equals("9")) return 9;
        if (lower.equals("october") || lower.equals("oct.") || lower.equals("oct") || lower.equals("10")) return 10;
        if (lower.equals("november") || lower.equals("nov.") || lower.equals("nov") || lower.equals("11")) return 11;
        if (lower.equals("december") || lower.equals("dec.") || lower.equals("dec") || lower.equals("12")) return 12;
        return -1;
    }

    private static int calculateDays(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }
}