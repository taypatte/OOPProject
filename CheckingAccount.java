package com.eddiegonzalez;

public class CheckingAccount extends Account {

    public CheckingAccount(String accountNumber, String pinNumber, String ssn, long balance) {
        super(accountNumber, pinNumber, ssn, balance);
    }

    public CheckingAccount(String accountNumber, String pinNumber, String ssn) {
        super(accountNumber, pinNumber, ssn);
    }
    public void viewLastDeposit() {
        System.out.println("Viewing Last Deposit");
    }
}
