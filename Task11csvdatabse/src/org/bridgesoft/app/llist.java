package org.bridgesoft.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class llist {
	static String[] header1;
	static Map<String, ArrayList<String>> m1 = new LinkedHashMap<>();
	static Map<String, Object> m2 = new LinkedHashMap<>();
	static String n;

	public static void main(String[] args) throws IOException {
		//System.out.println();
		//m1();
		groupmbr1();
		
	}
public static void m1()
{
		String row = null;
		ArrayList<String> aa;
		BufferedReader csvfile;
		String s;
		//String n;
		Scanner scan = new Scanner(System.in);

		try {
			csvfile = new BufferedReader(new FileReader("F:\\Bridgesoft\\ACME finance.csv"));
			// seperating the header
			s = csvfile.readLine();
			header1 = s.split(",");
			// getting the values
			
			while ((row = csvfile.readLine()) != null) { // reading the file line-by-line
				String[] s2 = row.split(",");
				aa = csvtoArraylist(s2);
				m1.put(n, aa);
				
				aa.remove(5);
				//m2.put(n, aa);
				//System.out.println(m2);
				System.out.println("removed"+aa);
			}List<String> grpmvr = groupmbr1();
			String[] sq = String.join("/", grpmvr).split("/");
			ArrayList<String> a1=new ArrayList<>();
			int count=0;
			for(String sqs:sq)
			{
			
			//a1.add(5, sq[count++]);
			}
			//System.out.println("liar a1:"+a1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//scan.close();
	}
	

	public static List<String> groupmbr1() throws IOException {
		BufferedReader csvfile1 = new BufferedReader(new FileReader("F:\\Bridgesoft\\ACME finance.csv"));
		// reading the header value
		String sp = csvfile1.readLine();
		String[] header = sp.split(",");
		// reading the body value
		String rowss;
		Map<String, List<String>> mm = new LinkedHashMap<>();
		Map<String, String> m4 = new LinkedHashMap<>();
		List<String> aa4 = new ArrayList<>();
		List<String> a1 = new ArrayList<>();
		while ((rowss = csvfile1.readLine()) != null) { // reading the file line-by-line
			String[] s1 = rowss.split(",");
			
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
		}
        Collection<String> list = m4.values();
		
		String list2 = String.join("/", list);
		a1.add(list2);
		//System.out.println("gfdgfdgfdg"+String.join("/", a1));
		System.out.println("list2:"+list2);
		System.out.println(mm);
		
		return a1;
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
