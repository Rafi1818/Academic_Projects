

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner scnr = new Scanner(System.in);
	    System.out.printf("Enter monthly saving amount: ");
	    Double savings = scnr.nextDouble();                                                //getting input from the user
	    Double total = 0.00;

		//calculating the total sum after 6 months

		total = (savings + total) * (1 + 0.05 / 12);
		total = (savings + total) * (1 + 0.05 / 12);
		total = (savings + total) * (1 + 0.05 / 12);
		total = (savings + total) * (1 + 0.05 / 12);
		total = (savings + total) * (1 + 0.05 / 12);
		total = (savings + total) * (1 + 0.05 / 12);

	    System.out.printf("After the sixth month, the account value is $%.2f\n" , total);  // printing final result
	}
}