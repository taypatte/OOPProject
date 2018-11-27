public class CheckingAccount extends Account {

    public CheckingAccount(String accountNumber, String pinNumber, String ssn, long balance) {
        super(accountNumber, pinNumber, ssn, balance,"checking");
    }

    public CheckingAccount(String accountNumber, String pinNumber, String ssn) {
        super(accountNumber, pinNumber, ssn,"checking");
    }
    public void viewLastDeposit() {
        System.out.println("Viewing Last Deposit");
    }
}
