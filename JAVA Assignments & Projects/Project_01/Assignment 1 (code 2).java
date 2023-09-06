//Algebra's code by Tahmidul Karim (TXK210009)

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args){
	    Scanner scnr = new Scanner(System.in);
	    System.out.printf("Enter a, b, c: ");

		//taking all the inputs
	    Double a = scnr.nextDouble();
	    Double b = scnr.nextDouble();
	    Double c = scnr.nextDouble();

	    Double valid = Math.pow(b, 2) - 4 * a * c;   //getting the discriminant

		//checking condition using if-else and printing results
		if(valid < 0){
	        System.out.println("The equation has no real roots");
	    }
	    else if (valid == 0){
	        Double result = -b / (2 * a);
	        System.out.printf("The equation has one root %.2f\n" , result);
	    }
	    else{
	        Double r1 = 0.0, r2 = 0.0;
	        r1 = (-b + Math.pow(valid, 0.5)) / (2 * a);
	        r2 = (-b - Math.pow(valid, 0.5)) / (2 * a);
	        Double R1 = Math.round(r1 * 1000000) / 1000000.0;
	        Double R2 = Math.round(r2 * 1000000) / 1000000.0;
	        System.out.print("The equation has two roots " + R1 + " and " + R2);
	    }
	}
}