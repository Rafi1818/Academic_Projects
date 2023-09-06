//Credit card number validation code by Tahmidul Karim (TXK210009)

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args){
	    Scanner scnr = new Scanner(System.in);
	    System.out.print("Enter a credit card number as a long integer: ");
	    String credit = scnr.next();
	    int length = credit.length();
	    int singDigit = 0, oddDigit = 0;
	    for (int i = length - 2; i >= 0; i -= 2){
	        String str = "" + credit.charAt(i);
	        Integer digit = Integer.parseInt(str);
	        if((digit * 2) >= 10){
	            singDigit += 1 + (digit * 2) % 10;
	        }
	        else{
	            singDigit += digit * 2; 
	        }
	    }
	    for (int j = length - 1; j >=0; j -= 2){
	        String strOdd = "" + credit.charAt(j);
	        oddDigit += Integer.parseInt(strOdd);
	    }
	    int sum = singDigit + oddDigit;
	    if((sum % 10) == 0){
	        System.out.print(credit + " is valid");
	    }
	    else{
	        System.out.print(credit + " is invalid");
	    }
	}
}

