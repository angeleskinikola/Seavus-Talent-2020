package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter numbers in words: ");
	    String words =new Scanner(System.in).nextLine();

	    String[] numbersInWords = words.split(" ");

	    String toInt = "";
	    boolean canParseToInt = true;

	    for(String number : numbersInWords) {
            switch (number.toUpperCase()) {
                case "ONE":
                    toInt += "1";
                    break;
                case "TWO":
                    toInt += "2";
                    break;
                case "THREE":
                    toInt += "3";
                    break;
                case "FOUR":
                    toInt += "4";
                    break;
                case "FIVE":
                    toInt += "5";
                    break;
                case "SIX":
                    toInt += "6";
                    break;
                case "SEVEN":
                    toInt += "7";
                    break;
                case "EIGHT":
                    toInt += "8";
                    break;
                case "NINE":
                    toInt += "9";
                    break;
                case "ZERO":
                    toInt += "0";
                    break;
                default:
                    canParseToInt = false;
            }
        }

	    if(canParseToInt) {
            int parsedNum = Integer.parseInt(toInt);
            System.out.println(parsedNum);
        } else {
            System.out.println("Invalid input.");
        }

    }
}
