package com.bfs.app;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.LinkedHashSet;
	import java.util.Scanner;
	import java.util.Set;

	public class Multipleacces {

		public static void main(String[] args) throws IOException {
			multipleAcess();
		}

		static Scanner scan = new Scanner(System.in);

		private static void multipleAcess() throws IOException {
			System.out.println("enter the acess1");
			String access = scan.next();
			System.out.println("enter the access2");
			String access2 = scan.next();
			Set<String> a1 = new LinkedHashSet<String>();
			Set<String> a2 = new LinkedHashSet<String>();
			Set<String> a3 = new LinkedHashSet<String>();
			ArrayList<String> a4 = new ArrayList<>();
			File file = new File("F:\\Bridgesoft\\notepad\\ACME finance.csv");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			// reading the header
			reader.readLine();
			String rows;
			// reading the footer

			while ((rows = reader.readLine()) != null) {

				String[] aa = rows.split(",");
				
				String Fvst = aa[5];
				String idlst = aa[6];

				if (access.equals(Fvst)) {
					a1.add(idlst);
					a3.add(idlst);
				}

				if (access2.equals(Fvst)) {
					a2.add(idlst);
				}
				
			}
			a1.retainAll(a2);
			System.out.println("id=" + a1);
			// System.out.println(access+":id="+a3);
			//System.out.println(access2 + ":id=" + a2);
			// System.out.println("Araaylist:"+a4);

		}
		/*
		 * public static int index() throws IOException { File file = new
		 * File("F:\\Bridgesoft\\notepad\\ACME finance.csv"); BufferedReader reader =
		 * new BufferedReader(new FileReader(file)); // reading the header String row =
		 * reader.readLine(); String rows = reader.readLine(); String
		 * access1=scan.next(); int index1; String[] ss = rows.split(",");
		 * System.out.println(ss[5].toString()); int index = Arrays.binarySearch(ss,
		 * access1); index1 = (index < 0) ? index*-1 : index;
		 * System.out.println("After adding:::"+index1);
		 * 
		 * return index1;
		 * 
		 * }
		 */

	}

