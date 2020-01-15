package com.bfs.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Grpmvr {
	
	/*public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the key to be search");
		String n = scan.next();
		groupmbr1(n);
	}*/
	static List<String> aa4;
	static String[] s1;
	public static void main(String[] args) {
		//Scanner scan=new Scanner(System.in);
		//System.out.println("enter the key to be search");
		//String n = scan.next();
		try {
			groupmbr1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static void groupmbr1() throws IOException {
		
		BufferedReader csvfile1 = new BufferedReader(new FileReader("F:\\Bridgesoft\\notepad\\ACME finance.csv"));
		// reading the header value
		String sp = csvfile1.readLine();
		String[] header = sp.split(",");
		// reading the body value
		String rowss;
		Map<String, List<String>> mm = new LinkedHashMap<>();
		Map<String, String> m4 = new LinkedHashMap<>();
		
		while ((rowss = csvfile1.readLine()) != null) { // reading the file line-by-line
			s1 = rowss.split(",");
		    aa4 = new ArrayList<>();
			if (mm.containsKey(s1[0])) {
				aa4 = mm.get(s1[0]);// change
				aa4.add(s1[5]);
				mm.put(s1[0], aa4);

			} else {
				aa4.add(s1[5]);
				mm.put(s1[0], aa4);

			}
			 List<String> as = mm.get(s1[0]);
	         String values = String.join(",", as);
	         m4.put(s1[0], values);
		}//System.out.println(m4);
		Collection<String> list = m4.values();
		System.out.println("keys:"+m4.keySet());
		String list2 = String.join("/", list);
		System.out.println("list22:"+list2);
		String[] list3 = list2.split("/");
		int count=0;
		for(String ss:list3)
		{
		System.out.println(list3[count++].toString());
		}
		
	}
}
