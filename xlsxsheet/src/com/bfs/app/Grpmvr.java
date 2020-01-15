package com.bfs.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Grpmvr {
	
	/*public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the key to be search");
		String n = scan.next();
		groupmbr1(n);
	}*/
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the key to be search");
		String n = scan.next();
		try {
			groupmbr1(n);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static void groupmbr1(String n) throws IOException {
		
		BufferedReader csvfile1 = new BufferedReader(new FileReader("F:\\Bridgesoft\\notepad\\ACME finance.csv"));
		// reading the header value
		String sp = csvfile1.readLine();
		String[] header = sp.split(",");
		// reading the body value
		String rowss;
		Map<String, List<String>> mm = new LinkedHashMap<>();
		Map<String, List<String>> m4 = new LinkedHashMap<>();
		while ((rowss = csvfile1.readLine()) != null) { // reading the file line-by-line
			String[] s1 = rowss.split(",");
			List<String> aa4 = new ArrayList<>();
			if (mm.containsKey(s1[0])) {
				aa4 = mm.get(s1[0]);// change
				aa4.add(s1[5]);
				mm.put(s1[0], aa4);

			} else {
				aa4.add(header[5] + "=" + s1[5]);
				mm.put(s1[0], aa4);

			}
		}
		List<String> as = mm.get(n);
		
		m4.put(n, as);
		System.out.println(m4);
		csvfile1.close();
		
	}
}
