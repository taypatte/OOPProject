import java.util.Scanner;

public class Account {
    private String accountNumber;
    private String pinNumber;
    private String ssn;
    private double balance;
    private double lastDeposit;
    public static Scanner scanner = new Scanner(System.in);

    public Account(String accountNumber, String pinNumber, String ssn, double balance) {
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
        System.out.println("Pleace type in PIN");
        Scanner scan=new Scanner(System.in);
        String pin = scan.nextLine();
        if(pin.equals(pinNumber))
            return true;
        else
            return false;
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

    public double getBalance() {
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return this.accountNumber + " " + this.pinNumber + " " + this.ssn + " " + this.balance;
    }

//--------------------------------------------------------------------//

    void depositFunds() {
        System.out.println("Please type in the amount of money you would like to deposit.");
        double deposit =scanner.nextDouble();
        scanner.nextLine();
        balance += deposit;
        lastDeposit = deposit;
        System.out.println("Deposit $"+deposit+" dollars");
        System.out.println("The balance becomes $"+balance+" dollars");
    }
    void withdrawFunds() {
        System.out.println("Please type in the amount of money");
        double withdrawAmount = scanner.nextDouble();
        if(withdrawAmount > balance) {//insufficient funds
            System.out.println("Sorry you don't have that much money.");
        }
        else {
            balance-=withdrawAmount;
            System.out.println("Withdraw $"+withdrawAmount+" dollars");
            System.out.println("The balance becomes $"+balance+" dollars");
        }
    }
    void queryBalance() {
        System.out.println("The balance is $"+balance+" dollars");
    }
    void transfer(Account target) {
        System.out.println("Please type in the amount of money");
        double transferAmount = scanner.nextDouble();
        if(transferAmount > balance) {//insufficient funds
            System.out.print("Sorry you don't have that much money\n");
        }
        else {
            balance -= transferAmount;
            target.balance += transferAmount;
            System.out.print("Transfer $"+transferAmount+" dollars\n");
            System.out.print("The balance becomes $"+balance+" dollars\n");
        }
    }
    void VLDA() {
        System.out.print("The last deposit ammount is $"+lastDeposit+" dollars\n");
    }
}

