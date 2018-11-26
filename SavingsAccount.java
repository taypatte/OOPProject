
public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, String pinNumber, String ssn, long balance) {
        super(accountNumber, pinNumber, ssn, balance);
    }

    public SavingsAccount(String accountNumber, String pinNumber, String ssn) {
        super(accountNumber, pinNumber, ssn);
    }
}
