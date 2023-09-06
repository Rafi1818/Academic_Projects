//Partition of a list's code by Tahmidul Karim (TXK210009)

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args){
	    Scanner scnr = new Scanner(System.in);
	    System.out.print("Enter list: ");
	    int a = scnr.nextInt();
	    int[] arr = new int[a];
	    for (int i = 0; i < a; i++){
	        arr[i] = scnr.nextInt();
	    }
	    pivot (arr, a);
	}
	public static int pivot(int[] arr, int a){
	    int[] newArr = new int[a]; 
	    int m = 0;
	    for (int j = 1; j < a; j++){
	        if(arr[j] <= arr[0]){
	            newArr[m] = arr[j];
	            m++;
	        }
	    }
	    int n = 1;
	    newArr[m] = arr[0];
	    for (int k = 0; k < a; k++){
	        if(arr[k] > arr[0]){
	                newArr[m + n] = arr[k];
	                n++;
	            }
	    }
	    System.out.print("After the partition, the list is ");
	    for (int p = 0; p < a; p++){
	        System.out.print(newArr[p] + " ");
	    }
	    return newArr[m];
	}
}


