//Hangman game's code by Tahmidul Karim (TXK210009)

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args){
	    Scanner scnr = new Scanner(System.in);
	    System.out.println("Enter r1's center x-, y-coordinates, width, and height: ");
	    Double x1 = scnr.nextDouble(), y1 = scnr.nextDouble(), w1 = scnr.nextDouble(), h1 = scnr.nextDouble();
	    System.out.println("Enter r2's center x-, y-coordinates, width, and height: ");
	    Double x2 = scnr.nextDouble(), y2 = scnr.nextDouble(), w2 = scnr.nextDouble(), h2 = scnr.nextDouble();
	    
	    Double[] X = new Double[4];
	    X[0] = x1 + w1 / 2;             //r1's right co-ordiante
	    X[1] = x1 - w1 / 2;             //r1's left co-ordiante
	    X[2] = x2 + w2 / 2;             //r2's right co-ordiante
	    X[3] = x2 - w2 / 2;             //r2's left co-ordiante
	    
	    Double[] Y = new Double[4];
	    Y[0] = y1 + h1 / 2;            //r1's top co-ordiante
	    Y[1] = y1 - h1 / 2;            //r1's bottom co-ordiante
	    Y[2] = y2 + h2 / 2;            //r2's top co-ordiante
	    Y[3] = y2 - h2 / 2;            //r2's bottom co-ordiante
	    
	    boolean bool = overlaps(X, Y);
	    if(bool){
	        if(X[0] >= X[2] && X[1] <= X[2] && Y[0] >= Y[2] && Y[1] <= Y[2]){       //checking if one is inside the other
	            System.out.println("r2 is inside r1");
	        }
	        else{
	            System.out.println("r2 overlaps r1");
	        }
	    }
	    else{
	        System.out.println("r2 does not overlap r1");
	    }
	    
	   
	}
	public static boolean overlaps(Double[] X, Double[] Y)
	   {
		   //checking if they overlap
	       if(X[0] <= X[3] || X[1] >= X[2] || Y[0] <= Y[3] || Y[1] >= Y[2]){
	           return false;
	       }
	       else{
	           return true;
	       }
	   }
	
}




