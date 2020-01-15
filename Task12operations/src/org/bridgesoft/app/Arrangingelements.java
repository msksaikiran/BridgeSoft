package org.bridgesoft.app;

import java.util.Scanner;

public class Arrangingelements {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the number of elements");
		int size = scan.nextInt();
		int[] elements = new int[size];
		System.out.println("enter the elements");
		for (int i = 0; i < elements.length; i++) {
			elements[i] = scan.nextInt();
		}
		int[] result = arrange(elements);// method call
		int n = result.length;
		for (int first = 0; first < n; first++) {
			int count = 0;
			// comparing the second element
			for (int second = first + 1; second < n; second++) {
				if (elements[first] == elements[second]) {
					count++;
					/*int k = second;// swapping into the values
					while (k < elements.length - 1) {
						elements[k] = elements[k + 1];
						k++;
					}
					n--; // decreasing the length
					second--;*/
				}		  
				// scan.close();
			}
			// diplaying the resultant elements
			/*for(int i=0;i<result.length;i++){
				  if (count == 3)
				  System.out.println("**********");
				  System.out.println(result[i]); }*/
				 
			if (count == 1) {
				System.out.println("*********");
				//for(int k=0;k<4;k++)
				System.out.println(result[first]);
			}/*else if(count==2){
				System.out.println(result[first]);
			}else{
				System.out.println(result[first]);
			}*/
			
		}
	}

	private static int[] arrange(int[] elements) {
		// comparing the first element
		int n = elements.length;
		for (int first = 0; first < n - 1; first++) {
			int count = 0;
			// comparing the second element
			for (int second = first + 1; second < n; second++) {
				/*
				 * if(elements[first]==elements[second]){ int k =
				 * second;//swapping into the values while (k < elements.length
				 * - 1) { elements[k] = elements[k + 1]; k++; } n--;
				 * //decreasing the length second--; }
				 */
				// swapping the elements according to the arrangement
				if (elements[first] > elements[second]) {
					// count++;
					int temp = elements[first];
					elements[first] = elements[second];
					elements[second] = temp;
				}
			}
		}

		/*
		 * if(count==4){ System.out.println(elements[first]); }
		 */
		for (int k = 0; k < n; k++) {
			System.out.println(elements[k]);

		}

		return elements;
		// 2,3,2,4,5,12,2,3,3,3,12
	}

}
