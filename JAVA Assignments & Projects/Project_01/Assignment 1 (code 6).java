//Pyramid's code by Tahmidul Karim (TXK210009)

import java.util.*;
import java.io.*;

public class Assignment 1 (code 6)
{
  public static void main (String[]args){

	//loop for printing the pyramid
    for (int i = 0; i <= 7; i++){
    	for (int j = 0; j <= 7 - i; j++){
    	    System.out.print ("    ");
    	}
    	for (int k = 0; k < i; k++){
    	    System.out.printf("%4d", (int)Math.pow(2,k));       //printing the first half of the line
    	}
    	for (int m = i; m >= 0; m--){
    	    System.out.printf("%4d", (int)Math.pow(2,m));      //printing the second half of the line
    	}
    	System.out.println();
    }
  }
}
