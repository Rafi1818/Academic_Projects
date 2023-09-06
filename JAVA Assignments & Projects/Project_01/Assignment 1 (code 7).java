//Financial application's code by Tahmidul Karim (TXK210009)

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args){
	    Scanner scnr = new Scanner(System.in);

		//getting all the inputs from user
	    System.out.print("Loan Amount: ");
	    Double loan = scnr.nextDouble();
	    System.out.print("Number of years: ");
	    int year = scnr.nextInt();
	    System.out.print("Annual Interest Rate: ");
	    Double interest = scnr.nextDouble();

		//calculating monthly interest rate, total amount due each month, and gross total due
	    Double monthlyInterest = interest / (12 * year * 100);
	    Double monthlyDue = loan * monthlyInterest / (1 - 1 / (Math.pow(1 + monthlyInterest, 12 * year)));
	    Double totalDue = monthlyDue * 12 * year;
	    
	    System.out.println();
	    System.out.printf("Monthly Payment: " + "%.2f" , monthlyDue);
	    System.out.println();
	    System.out.printf("Total Payment: " + "%.2f" , totalDue);
	    System.out.println();
	    
	    System.out.println("Payment#" + "        " +  "Interest" + "        " + "Principal" + "       " + "Balance");

		//using for loop to print the spreadsheet
		for(int i = 1; i <= 12; i++){
	        Double interestAmount = monthlyInterest * loan;
	        Double principal = monthlyDue - interestAmount;
	        loan = loan - principal;
	        System.out.printf(i + "\t\t" + "%.2f", interestAmount);
	        System.out.printf("\t\t" + "%.2f", principal);
	        System.out.printf("\t\t" + "%.2f", loan);
	        System.out.println();
	    }
	}
}



