package com.company;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        System.out.println("Enter height of box: ");
        int height = new Scanner(System.in).nextInt();

        System.out.println("Enter width of box: ");
        int width = new Scanner(System.in).nextInt();

        System.out.println("Enter depth of box: ");
        int depth = new Scanner(System.in).nextInt();

        if (height > 0 && width > 0 && depth > 0) {
            Box box = new Box(height, width, depth);
            System.out.println("Volume of the box is " + box.volume());
        } else {
            System.out.println("Cannot create box with values less or equal to zero.");
        }

    }
}
