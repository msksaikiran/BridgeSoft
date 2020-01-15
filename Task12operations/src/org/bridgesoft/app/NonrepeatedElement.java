package org.bridgesoft.app;

import java.util.Scanner;

public class NonrepeatedElement {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("enter the String");
		String string = scan.next();
		m1(string);
        scan.close();
	}

	public static void m1(String string1) {

		String[] ch = string1.split("");
		char[] ar = string1.toCharArray();
		int n = ar.length;
        //comparing the first array element
		for (int i = 0; i < n; i++) {
			int count = 0;
			//comparing the second element
			for (int j = i + 1; j < n; j++) {
				if (ar[i] == ar[j]) {
					count++;
					int k = j;//swapping into the values
					while (k < n - 1) {
						ar[k] = ar[k + 1];
						k++;
					}
					n--;//decreasing the length
					j--;

				}

			}
			if (count == 0) {
				// sum=sum+ar[i];
				System.out.println(ar[i] + " is first non repeated element");
				break;

			}
		}
		/*for(int k=0;k<n;k++)
		{
			System.out.println(ar[k]);
		}
*/
	}
}
