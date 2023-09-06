import java.util.Date;

public class Account{
    private int id = 0;
    private double balance = 0.00;
    private double annualInterestRate = 0.00;
    private Date dateCreated = new Date((2022 - 1900), 9, 06, 23, 1, 47);

    //no-arg constructor
    Account(){
    }

    //arg-constructor
    Account(int idIn, double balanceIn){
        id = idIn;
        balance = balanceIn;
    }

    //setter for ID
    public void setID(int setId){
        id = setId;
    }

    //getter for ID
    public int getID(){
        return id;
    }

    //setter for balance
    public void setBalance(double setBalance){
        balance = setBalance;
    }

    //getter for balance
    public double getBalance(){
        return balance;
    }

    //setter for interest rate
    public void setInterestRate(double interestRate){
        annualInterestRate = interestRate;
    }

    //getter for interest rate
    public double getInterestRate(){
        return annualInterestRate / 100.00f;
    }

    //getter for account creation date
    public Date getDate(){
        return dateCreated;
    }

    //getter for monthly interest rate
    public double getMonthlyInterestRate(){
        return annualInterestRate / (100.00f * 12);
    }

    //getter for total monthly interest
    public double getMonthlyInterest(){
        return (balance * annualInterestRate / (100.00f * 12));
    }

    //method for withdrawal
    public void withdraw(double amount){
        balance = balance - amount;
    }

    //method for deposit
    public void deposit(double depositAmount){
        balance += depositAmount;
    }
}