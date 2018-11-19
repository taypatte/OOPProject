package com.eddiegonzalez;

public class Account {
    private String accountNumber;
    private String pinNumber;
    private String ssn;
    private long balance;

    public Account(String accountNumber, String pinNumber, String ssn, long balance) {
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;
        this.ssn = ssn;
        this.balance = balance;
    }

    public Account(String accountNumber, String pinNumber, String ssn) {
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;
        this.ssn = ssn;
    }

    public boolean validatePIN() {
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public long getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return this.accountNumber + " " + this.pinNumber + " " + this.ssn + " " + this.balance;
    }
}
