import java.util.scanner;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ThisTimer extends TimerTask extends SavingsAccount{

    @Override
    public void run() {
        System.out.println("Timer task started at:"+new Date());
        completeTask();
        System.out.println("Timer task finished at:"+new Date());
    }

    private void completeTask() {
        try {
            //assuming it takes 20 secs to complete the task
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void addInterest() {

        // Get the monthly interest rate.
        double monthlyInterestRate = annualInterestRate / 12;

        // Calculate the last amount of interest earned.
        lastAmountOfInterestEarned = monthlyInterestRate * accountBalance;

        // Add the interest to the balance.
        accountBalance += lastAmountOfInterestEarned;
    }
    
    public static void main(String args[]){
        //timer starts
        
        TimerTask timerTask = new ThisTimer();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
        System.out.println("TimerTask started");
        //cancel after sometime
        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("TimerTask cancelled");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
