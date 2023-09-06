//Hangman game's code by Tahmidul Karim (TXK210009)

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args){
	    Scanner scnr = new Scanner(System.in);
	    String[] str = {"write", "program", "that", "receive", "positive"};
	    while(true){
	        int x = randomGenerator(str.length);
	        boolean bool = printMenu(str[x]);
	        if(bool){
	            continue;
	        }
	        else{
	            break;
	        }
	    }
	    
	}
	
	public static boolean printMenu(String str){
	    Scanner scnr = new Scanner(System.in);
	    String choice = "";
	    int validation = 0;
	    int length = str.length();
	    String[] sample = new String[length];
	    
	        for (int j = 0; j < length; j++){
	            sample[j] = "*";
	        }
	    while(true){
	        int cntr = 0;
	        for(int m = 0; m < length; m++){
    	        if (sample[m].charAt(0) == '*'){
    	            cntr++;
    	        }
    	    }
    	    if(cntr == 0){
    	        if(validation > 1){
    	            System.out.println("The word is " + str + ". You missed " + validation + " times");
    	        }
    	        else{
    	            System.out.println("The word is " + str + ". You missed " + validation + " time");
    	        }
    	        System.out.print("Do you want to guess another word? Enter y or n > ");
    	        choice = scnr.next();
    	        break;
    	        
    	    }
    	    
	        System.out.print("(Guess) Enter a letter in word ");
	        for(int k = 0; k < length; k++){
	            System.out.print(sample[k]);
	        }
	        System.out.print(" > ");
	        String input = scnr.next();
	        int counter = 0;
	        boolean bool = false;
	        for(int n = 0; n < length; n++){
    	        if(input.charAt(0) == sample[n].charAt(0)){
    	            bool = true;
    	            break;
    	        }
    	    }
    	    if(bool){
    	        System.out.println("     " + input + " is already in the word");
    	        continue;
    	    }
    	    for(int i = 0; i < length; i++){
    	        if(input.charAt(0) == str.charAt(i)){
    	            sample[i] = "" + input.charAt(0);
    	            counter++;
    	        }
    	    }
    	    
    	    if (counter == 0){
    	        System.out.println("     " + input + " is not in the word");
    	        validation++;
    	    }
    	    
	    }
	    if(choice.charAt(0) == 'n'){
	        return false;
	    }
	    else{
	        return true;
	    }
	    
	}
	public static int randomGenerator(int x){
	    Random rand = new Random();
	    int randInt = rand.nextInt(x);
	    return randInt;
	}
}



