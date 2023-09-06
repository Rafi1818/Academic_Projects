import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        Account[] acct = new Account[10];                           //array for 10 accounts
        for(int i = 0; i < acct.length; i++){
            acct[i] = new Account(i, 100.00);                       //setting initial balance to $100
        }
        //infinite loop for the menu to run until terminated
        while(true){
            int id = 0;
            System.out.print("Enter your ID: ");
            //loop for getting a valid input for the id
            while(true){
                id = scnr.nextInt();
                if (id < 0 || id > 9){
                    System.out.print("Enter a correct ID: ");       //asks for correct ID if invalid number is entered
                    continue;
                }
                else{
                    break;
                }
            }
            //printing the menu
            System.out.print("Press 1 for current balance \nPress 2 for withdrawing money \nPress 3 for depositing money \nPress 4 to exit \n");
            //taking input for selection
            int selection = scnr.nextInt();
            if(selection == 1){
                System.out.print("Your current blanace is: $");
                System.out.printf("%.2f", acct[id].getBalance());   //displays balance when press 1
            }
            else if(selection == 2){
                System.out.print("Enter withdrawal ammount: $");
                double withdrawAmount = scnr.nextDouble();
                acct[id].withdraw(withdrawAmount);                  //withdraws money from account
            }
            else if(selection == 3){
                System.out.print("Enter deposit amount: $");
                double depositAmount = scnr.nextDouble();
                acct[id].deposit(depositAmount);                    //deposits money in account
            }
            else{
                System.out.println();
                continue;
            }
            System.out.println();
        }
    }
}
