package org.bridgesoft.app;
import java.util.Scanner;

public class PossibleOccurence {
	    static void permute(int[] a, int k) 
	    {
	        if (k == a.length) 
	        {
	            for (int i = 0; i < a.length; i++) 
	            {
	                System.out.print( String.valueOf(a[i]) );
	            }
	            System.out.println();
	        } 
	        else 
	        {
	            for (int i = k; i < a.length; i++) 
	            {
	                int temp = a[k];
	                a[k] = a[i];
	                a[i] = temp;
	 
	                permute(a, k + 1);
	 
	                temp = a[k];
	                a[k] = a[i];
	                a[i] = temp;
	            }
	        }
	    }
	 
	    public static void main(String args[]) 
	    {
	        //Random random = new Random();
	        Scanner sc = new Scanner(System.in);
	       // System.out.println("Enter the length of list: ");
	        //int N = sc.nextInt();
	        //int[] sequence = new int[N];
	        System.out.println("enter the elements");
	        String str=sc.next();
	        int[] sequence = new int[str.length()];
	        for (int i = 0; i < str.length(); i++)
	         //sequence[i] = Math.abs(random.nextInt(100));
	        //sequence[i] = sc.nextInt();
	        sequence[i] =str.charAt(i);
	        System.out.println("The original sequence is: ");
	        for (int i = 0; i < str.length(); i++)
	            System.out.print(sequence[i] + " ");
	 
	        System.out.println("\nThe permuted sequences are: ");
	        permute(sequence, 0);
	 
	        sc.close();
	    }
	}
