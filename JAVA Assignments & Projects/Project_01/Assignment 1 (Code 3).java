//Business check ISBN-10 code by Tahmidul Karim (TXK210009)

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args){
	    Scanner scnr = new Scanner(System.in);
	    System.out.print("Enter the first 9 digits of an ISBN as integer: ");
	    Integer input = scnr.nextInt();
	    String str = input.toString();
	    if (str.length() < 9){
	        str = "0" + input.toString();
	    }
	    
	    Integer number[] = new Integer[9];
	    for(int i = 0; i < 9; i++){
	        String Num = "" + str.charAt(i);
	        int num = Integer.parseInt(Num);
	        number[i] = num;
	    }
	    int mult = 0;
	    for(int j = 0; j < 9; j++){
	        mult = mult + number[j] * (j + 1);
	    }
	    if(mult % 11 == 10){
	    	System.out.print("The ISBN-10 number is " + str + "X");
	    }
	    else{
	        System.out.print("The ISBN-10 number is " + str + (mult % 11));
	    }
	    
	}
}
