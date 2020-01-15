package dfsdfd;

import java.util.Scanner;

public class Randomfunction {
	 public static void main(String args[]) 
	    { 
	        // define the range 
		 Scanner scan=new Scanner(System.in);
		 System.out.println("eneter the max element...");
		 int ele=scan.nextInt();
	        int max = ele; 
	        int min = 1; 
	        int range = max - min + 1; 
	  
	        // generate random numbers within 1 to 10 
	        for (int i = 0; i < ele; i++) { 
	            int rand = (int)(Math.random() * range) + min; 
	            // Output is different everytime this code is executed 
	            System.out.println(rand); 
	        } 
	    } 
}
