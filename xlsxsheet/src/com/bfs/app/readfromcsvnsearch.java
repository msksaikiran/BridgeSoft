package com.bfs.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class readfromcsvnsearch {
	static String[] header1;
	static Map<String, ArrayList<String>> m1 = new LinkedHashMap<>();
	static Map<String, Object> m2 = new LinkedHashMap<>();
	static String n;

	public static void main(String[] args) {
		//System.out.println();

		String row = null;
		ArrayList<String> aa;
		BufferedReader csvfile;
		String s;
		String[] s2;
		Scanner scan = new Scanner(System.in);

		try {
			csvfile = new BufferedReader(new FileReader("F:\\Bridgesoft\\ACME finance.csv"));
			// seperating the header
			s = csvfile.readLine();
			header1 = s.split(",");
			// getting the values
			while ((row = csvfile.readLine()) != null) { // reading the file line-by-line
				s2 = row.split(",");
				aa = csvtoArraylist(s2);
				m1.put(s2[0], aa);
			}
			System.out.println("enter the key to be search");
			n = scan.next();
			
			if ((m1.get(n)) != null) {

				ArrayList<String> a1 = m1.get(n);
				List<String> grpmvr = groupmbr1(n);
				String sq = grpmvr.toString();
				a1.remove(5);
				a1.add(5, sq);
				m2.put(n, a1);
				System.out.println(m2);

			} else {
				System.out.println("record not found");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//scan.close();
	}

	public static List<String> groupmbr1(String asp) throws IOException {
		BufferedReader csvfile1 = new BufferedReader(new FileReader("F:\\Bridgesoft\\ACME finance.csv"));
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
		//System.out.println("cjcxjdcjhdcjhd:"+as);
		m4.put(n, as);
		System.out.println(m4);
		csvfile1.close();
		
		return as;
	}

	private static ArrayList<String> csvtoArraylist(String[] line) {
		// TODO Auto-generated method stub
		ArrayList<String> a1 = new ArrayList<>();
		if (line != null) {
			for (int i = 0; i < line.length; i++) {
				if (!(line[i] == null) || !(line[i].length() == 0))

					a1.add(header1[i] + "=" + line[i]);
			}

		} // System.out.println("data from Arraylist:"+a1);
		return a1;
	}

}
