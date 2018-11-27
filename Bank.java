import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    public static Scanner scanner = new Scanner(System.in);
    private ArrayList<Account> accounts;
    private String adminPassword;
    private int partialCheckingAccountNumber;
    private int partialSavingsAccountNumber;


    public Bank() {
        this.accounts = new ArrayList<Account>();
        this.adminPassword = "1234";
        this.partialCheckingAccountNumber = 1;
        this.partialSavingsAccountNumber = 1;
    }
    public void addAccount(Account account) {
        this.accounts.add(account);
    }
    private String getValidPIN() {
        boolean correctLength = false;
        String pin = "";
        while (!correctLength) {
            System.out.println("Please enter a 4 digit PIN");
            pin = scanner.nextLine();
            if (pin.length() == 4) {
                correctLength = true;
            }
            else {
                System.out.println("PIN must be 4 digits. Please try again.");
            }
        }
        return pin;
    }
    private String getValidAccountChoice() {
        boolean correct = false;
        String choice = "";
        while (!correct) {
            System.out.println("Enter type of account. Savings or Checking");
            choice = scanner.nextLine().toLowerCase();
            if (choice.equals("checking") || choice.equals("savings")) {
                correct = true;
            }
            else {
                System.out.println("Invalid account type. Please try again.");
            }
        }
        return choice;
    }
    private String getValidSSN() {
        boolean correctLength = false;
        String ssn = "";
        while (!correctLength) {
            System.out.println("Please enter a 9 digit SSN");
            ssn = scanner.nextLine();
            if (ssn.length() == 9) {
                correctLength = true;
            }
            else {
                System.out.println("Invalid SSN. Must be 9 digits. Please try again.");
            }
        }
        return ssn;
    }

    private Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Your account was found");
                return account;
            }
        }
        System.out.println("The account was not found.");
        return null;
    }
//    private String generateAccountNumber() {
//        String accountNumber = "";
//        if (this.partialAccountNumber < 10) {
//            accountNumber = "0000" + this.partialAccountNumber;
//
//        }
//        else if (this.partialAccountNumber < 100) {
//            accountNumber = "000" + this.partialAccountNumber;
//
//        }
//        else if(this.partialAccountNumber < 1000) {
//            accountNumber = "00" + this.partialAccountNumber;
//
//        }
//        else if(this.partialAccountNumber < 10000) {
//            accountNumber = "0" + this.partialAccountNumber;
//        }
//        else {
//            accountNumber = Integer.toString(this.partialAccountNumber);
//        }
//        this.partialAccountNumber++;
//        return accountNumber;
//
//    }
    private String generateCheckingAccountNumber() {
        String accountNumber = "";
        int leadingZeroes = 5 - Integer.toString(this.partialCheckingAccountNumber).length();
        if (leadingZeroes == 0) {
            accountNumber = Integer.toString(this.partialCheckingAccountNumber);
            this.partialCheckingAccountNumber++;
            return accountNumber;
        }
        for (int i = 0; i < leadingZeroes; i++) {
            accountNumber += "0";
        }
        accountNumber += this.partialCheckingAccountNumber;
        this.partialCheckingAccountNumber++;
        return accountNumber;
    }
    private String generateSavingsAccountNumber() {
        String accountNumber = "1";
        int trailingZeroes = 4 - Integer.toString(this.partialSavingsAccountNumber).length();
        if (trailingZeroes == 0) {
            accountNumber = Integer.toString(this.partialSavingsAccountNumber);
            this.partialSavingsAccountNumber++;
            return accountNumber;
        }
        for (int i = 0; i < trailingZeroes; i++) {
            accountNumber += "0";
        }
        accountNumber += this.partialSavingsAccountNumber;
        this.partialSavingsAccountNumber++;
        return accountNumber;
    }

    private void openAccount() {
        String accountType = getValidAccountChoice();
        String pinNumber = getValidPIN();
        String ssn = getValidSSN();
        if (accountType.equals("savings")) {
            String newAccountNumber = this.generateSavingsAccountNumber();
            Account newAccount = new SavingsAccount(newAccountNumber, pinNumber, ssn);
            accounts.add(newAccount);
        }
        else if (accountType.equals("checking")) {
            String newAccountNumber = this.generateCheckingAccountNumber();
            Account newAccount = new CheckingAccount(newAccountNumber, pinNumber, ssn);
            accounts.add(newAccount);
        }
        else {
            System.out.println("Invalid account type.");
        }

    }
    private void closeAccount() {
        System.out.println("Please enter the customers's account number.");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.setBalance(0);
            System.out.println("The current balance of this account is: $" + account.getBalance());
            System.out.println("Balance is now $0.");
            accounts.remove(account);
            System.out.println("The account was successfully removed.");
        }
        else {
            System.out.println("Unsuccessfully closed account");
        }
    }
    private void adminMenu() {
        System.out.println("Please select an option.");
        System.out.println("1. Open Account");
        System.out.println("2. Close Account");
        System.out.println("3. Display Accounts");
        System.out.println("4. Exit");
    }
    private void displayAccounts() {
        if (this.accounts.size() == 0) {
            System.out.println("There are no accounts in the bank system.");
        }
        else {
            for (Account account : accounts) {
                System.out.println(account.toString());
            }
        }

    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void admin(String adminPassword) {
        if (this.adminPassword.equals(adminPassword)) {
            System.out.println("Correct Password!");
            int adminChoice = 0;
            boolean adminLogin = true;
            while(adminLogin) {
                adminMenu();
                adminChoice = scanner.nextInt();
                scanner.nextLine();
                switch(adminChoice) {
                    case 1:
                        openAccount();
                        break;
                    case 2:
                        closeAccount();
                        break;
                    case 3:
                        displayAccounts();
                        break;
                    case 4:
                        adminLogin = false;
                        break;
                    default:
                        adminLogin = false;
                        break;

                }

            }

        }
        else {
            System.out.println("Invalid password");
        }
    }
}
