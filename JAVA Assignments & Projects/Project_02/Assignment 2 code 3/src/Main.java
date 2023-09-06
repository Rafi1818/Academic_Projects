import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) {
        Account acct = new Account(1122, 20000);
        acct.setInterestRate(4.5);                              //setting yearly interest rate
        acct.withdraw(2500);                                    //withdraw $2500 from the account
        acct.deposit(3000);                                     //deposit $3000
        System.out.print("$");
        System.out.printf("%.2f", acct.getBalance());           //display account balance
        System.out.println();
        System.out.print("$");
        System.out.printf("%.2f", acct.getMonthlyInterest());   //display total monthly interest
        System.out.println();
        System.out.print(acct.getDate());                       //display account creation date
    }
}
