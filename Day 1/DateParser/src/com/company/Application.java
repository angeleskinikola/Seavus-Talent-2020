package com.company;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        boolean quit = false;
        while (!quit) {
            System.out.println("Enter date in format MM/DD/YYYY");

            try {
                String date = new Scanner(System.in).nextLine();
                String[] strings = date.split("/");

                String month = strings[0];
                String day = strings[1];
                String year = strings[2];

                if (isValidDate(Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(year))) {
                    System.out.println("Month: " + month);
                    System.out.println("Day: " + day);
                    System.out.println("Year: " + year);
                    quit = true;
                } else {
                    System.out.println("Invalid month, day or year.");
                }
            } catch (Exception e) {
                System.out.println("Invalid date format.");
            }
        }
    }

    static boolean isValidDate(int month, int day, int year) {
        if(month < 13 && month > 0 && day > 0 && day < 32 && year > 0 ) {
            if(year % 4 == 0 && month == 2 && day > 29) {
                return false;
            } else if(year % 4 != 0 && month == 2 && day > 28) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
