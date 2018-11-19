package com.eddiegonzalez;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Bank bank = new Bank();
        int choice = 0;
        Account account1 = new SavingsAccount("12345", "7890", "123456789", 55);
        Account account2 = new CheckingAccount("54321", "4567", "987654321", 100);

        while(choice != 3) {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    System.out.println("Not done");
                    break;
                case 2:
                    System.out.println("Please enter the admin password.");
                    String password = scanner.nextLine();
                    bank.admin(password);
                    break;
                case 3:
                    choice = 3;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }

        }
    }
    public static void printMenu() {
        System.out.println("Please select an option.");
        System.out.println("1. Customer");
        System.out.println("2. Bank Staff");
    }

}
