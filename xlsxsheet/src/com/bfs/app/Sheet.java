package com.bfs.app;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Sheet {
	static String lst1;
	static String zero1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the no of entites");
		int entites = scan.nextInt();
		String[] details = new String[entites];
		for (int i = 0; i < details.length; i++) {
			System.out.println("enter the details");
			details[i] = scan.next();

		}
		Map<String, String> m4 = new LinkedHashMap<>();
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list3 = new ArrayList<>();
		ArrayList<String> list4 = new ArrayList<>();
		Set<String> set = new LinkedHashSet<String>();
		// Extracting the similar values
		for (String s : details) {
			String[] sp = s.split(",");
			String fst = sp[1].toString();
			set.add(fst);
		}
		// extracting the values from set object
		String setvalues = String.join(",", set);
		String[] splt = setvalues.split(",");// Europe,America
		String fistset = splt[1].toString().substring(3, splt[1].length());// Europe
		String zeroset = splt[0].toString().substring(3, splt[0].length());// America
		// comparing with the extracted values
		for (String s : details) {

			String[] splitdetails = s.split(",");

			String fstvalue = splitdetails[1].toString().substring(3, splitdetails[1].length());
			String zerovalue = splitdetails[0].toString().substring(3, splitdetails[0].length());

			if (fstvalue.equals(fistset)) {

				list.add(zerovalue);
			}

			if (fstvalue.equals(zeroset)) {

				list1.add(zerovalue);
			}

		}

		String jn = String.join(",", list);
		list3.add(fistset + "=" + jn);
		String jn1 = String.join(",", list1);
		list4.add(zeroset + "=" + jn1);
		String sss = String.join(",", list3);
		String svs = String.join(",", list4);

		m4.put(sss, svs);
		String a = m4.toString();
		StringBuffer buffer = new StringBuffer(a);
		buffer.replace(25, 26, " ");
		System.out.println(buffer);

	}
}
