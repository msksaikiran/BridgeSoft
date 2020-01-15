package org.bridgesoft.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Tsk2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the number of values");
		int size = scan.nextInt();
		String arr[] = new String[size];
		ArrayList<String> a1 = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			arr[i] = scan.next();
			a1.add(arr[i]);
		}
		//a1.forEach((as)->System.out.println(as));
		//System.out.println(a1);
		String[] string = String.join(",", a1).split(",");
		int nt = 456;
		
		for (int i = 0; i < string.length; i++) {
			if (string[i].equals("a")) {
				a1.remove(string[i]);
				a1.add(i, String.valueOf(nt));
			}else if (string[i].equals("aa")) {
				a1.remove(string[i]);
				a1.add(i, String.valueOf(++nt) + String.valueOf(nt++));

			}else if(string[i].equals("aaa")){
				a1.remove(string[i]);
				a1.add(i, String.valueOf(++nt) + String.valueOf(nt++)+String.valueOf(1-nt++).replaceAll("-", ""));
			}
		}
		System.out.println(a1);

		scan.close();
	}
}
