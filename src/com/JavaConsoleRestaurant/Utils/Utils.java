package com.JavaConsoleRestaurant.Utils;

import com.JavaConsoleRestaurant.Console.Signals.MainMenuSignal;

import java.util.Scanner;

public class Utils {

    public enum TypeOfInput {
        ID("customerID"),
        PASSWORD("password");

        private String display;

        TypeOfInput(String display) {
            this.display = display;
        }

        @Override
        public String toString() {
            return display;
        }

    }

    private final Scanner scanner;
    private MainMenuSignal mainMenuSignal;

    public Utils(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputValidityCheckString(String message, String... options) {
        String input;
        while (true) {
            System.out.println(message);
            for (String option : options) {
                System.out.print("\u001B[46m\u001B[30m\u001B[1m[" + option.toUpperCase() + "]\u001B[0m    ");
            }
            System.out.print("\n> ");
            input = scanner.nextLine().trim().toLowerCase();
            for (String option : options) {
                if (input.equalsIgnoreCase(option)) {
                    return input;
                }
            }
            System.out.println("Oops! It seems that you made a mistake!\n");
        }
    }

    public String inputValidityCheckInt(TypeOfInput typeOfInput, int digit) {
        String input;
        String main = "back to main menu";
        while (true) {
            System.out.println("Please write down your " + digit + "-digit " + typeOfInput.display + ":");
            System.out.print("\u001B[46m\u001B[30m\u001B[1m[BACK TO MAIN MENU]\u001B[0m\n");
            System.out.print("> ");
            input = scanner.nextLine().trim().toLowerCase();
            if(input.equalsIgnoreCase("back to main menu")){
                mainMenuSignal.execute();
                return null;
            }
            if (!input.isEmpty() && input.matches("\\d+")) {
                if (input.length() != digit) {
                    System.out.println("You entered " + (input.length()) + "-digit " + typeOfInput.display + ".\n");
                    if (typeOfInput == TypeOfInput.ID){
                        System.out.println("Kindly reminder, that small numbers should start with zeros." +
                                "\nFor example: 000013\n");
                    }
                } else {
                    switch (typeOfInput) {
                        case ID -> {
                            System.out.println("OK! You customerID is [" + input + "].");
                            return input;
                        }
                        case PASSWORD -> {
                            System.out.println("\u001B[1m\u001B[93mYour password is checking...\u001B[0m");
                            return input;
                        }
                    }
                }

            } else {
                System.out.println("\u001B[1m\u001B[91mUnexpected value.\u001B[0m");
            }
        }
    }

    public void setMainMenuSignal(MainMenuSignal mainMenuSignal) {
        this.mainMenuSignal = mainMenuSignal;
    }

}

