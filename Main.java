package com.eddiegonzalez;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Bank bank = new Bank();
        int choice = 0;
        Account account1 = new SavingsAccount("12345", "7890", "123456789", 55);
        Account account2 = new CheckingAccount("54321", "4567", "987654321", 100);
        bank.addAccount(account1);
        bank.addAccount(account2);

        while(choice != 3) {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    customer(bank);
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
    public static void customer(Bank bank) {
        while(true) {
            System.out.println("Pleace enter account number");
            String number = scanner.nextLine();
            boolean validaccount = false;
            int number2;
            for(int i=0;i<bank.getAccounts().size();i++) {
                if(bank.getAccounts().get(i).getAccountNumber().equals(number)) {//verify account number
                    int invalidPIN=3;
                    validaccount=true;
                    while(invalidPIN>0) {//3 chance to type wrong PIN
                        if(bank.getAccounts().get(i).validatePIN()) {
                            boolean cancel=false;

                            while(!cancel) {
                                System.out.print("\nChoose your transaction type:\n");
                                System.out.print("1.Deposit  2.Withdrawal               3.Query Balance\n");
                                System.out.print("4.Transfer 5.View Last Deposit Amount 6.Cancel\n");
                                number2=scanner.nextInt();
                                if(number2==1) {//Deposit
                                    bank.getAccounts().get(i).depositFunds();
                                }
                                if(number2==2) {//Withdrawal
                                    bank.getAccounts().get(i).withdrawFunds();
                                }
                                if(number2==3) {//Query Balance
                                    bank.getAccounts().get(i).queryBalance();
                                }
                                if(number2==4) {//Transfer
                                    System.out.print("Pleace type in the target account number\n");
                                    number=scanner.nextLine();
                                    boolean validtarget=false;
                                    for(int j=0;j<bank.getAccounts().size();j++) {
                                        if(bank.getAccounts().get(j).getAccountNumber().equals(number)){
                                            bank.getAccounts().get(i).transfer(bank.getAccounts().get(j));
                                            validtarget=true;
                                        }
                                    }
                                    if(!validtarget) {
                                        System.out.println("No such account number");
                                    }
                                }
                                if(number2==5) {//View Last Deposit Amount
                                    bank.getAccounts().get(i).VLDA();
                                }
                                if(number2==6) {//Cancel
                                    System.out.print("Thanks!!\n");
                                    cancel=true;
                                }
                            }
                            break;
                        }
                        else {
                            System.out.print("Correct PIN is "+bank.getAccounts().get(i).getPinNumber()+"\n");
                            System.out.print("\nWrong PIN, you have "+(--invalidPIN)+" times to try\n");
                        }
                    }
                }
            }
            if(!validaccount) {
                System.out.println("No such account number\n");
            }

        }

    }

}
