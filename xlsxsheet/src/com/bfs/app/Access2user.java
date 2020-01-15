package com.bfs.app;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
	import java.util.Map;
	import java.util.Scanner;
import java.util.Set;


	public class Access2user {
		static String[] header1 ;
		private static String rows;
		static String list ;
		static String lst;
		static Scanner scan=new Scanner(System.in);

		public static void main(String[] args) throws Exception {
			File file = new File("F:\\Bridgesoft\\ACME finance.csv");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			//reading the header
			String header = reader.readLine();
			header1 = header.split(",");
			//reading the footer
			System.out.println("enter 1 for single access");
			System.out.println("enter 2 for multiple access");
			System.out.println("enter 4 to know multipleacess");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:getId();	
			break;
			case 2:multipleAcess();
			break;
			case 4:groupmbr1();
			}
		}
		private static void getId() throws IOException 
		{
			System.out.println("enter the 1st access");
			String access=scan.next();
			//System.out.println("enter the 2nd access");
			//String access2=scan.next();
			File file = new File("F:\\Bridgesoft\\ACME finance.csv");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			//reading the header
			String header = reader.readLine();
			header1 = header.split(",");
			//reading the footer
			while((rows=reader.readLine())!=null)
		
	      	{
			String[] aa = rows.split(",");
			//ArrayList<String> sdsf = csvtoArraylist(aa);//Arrays.toString--to display array details
			
			ArrayList<String> lsts = csvtoArraylist(aa);
			ArrayList<String> a= new ArrayList<>();
			String[] s12= lsts.toString().split(",");
			//System.out.println(Arrays.toString(s12));
			list=s12[5];
			lst=s12[0].toString();
			a.add(list);
			String s1 = a.toString();
			//String s1 = list.toString();
			System.out.println("listeeee::"+s1);
			//Map<String,List<String>> m1=new LinkedHashMap<>();
			Map<String,ArrayList<String>> m2=new LinkedHashMap<>();
			//String[] aa = rows.split(",");
			//list=arraList2(aa);
			//m1.put(access, list);
			
			//list.toString().split(",");
			//String[] s22 = s1.split(",");
			//System.out.println("dcssssfd"+ ""+Arrays.toString(s22));
			ArrayList<String> aaa= new ArrayList<>();
			//String dds = s22[0];
			//String dd = s22[5].toString();
			//System.out.println("8888888"+dd);
			if(access.equals(s1))
			{
			 System.out.println("djkejeiouewew"+lst);
			 //aaa.add(lst); 	
			}
			/*else if(access2.equals(s1))
			{
				System.out.println(lst);
			}*/
			//m2.put(access, aaa);
			//String[] ss = aaa.toString().split("[]");
			//System.out.println(aaa);
			//System.out.println(m2);
		}
		}
		
		private static void multipleAcess() throws IOException 
		{
			System.out.println("enter the 1st access");
			String access=scan.next();
			System.out.println("enter the 2nd access");
			String access2=scan.next();
			File file = new File("F:\\Bridgesoft\\ACME finance.csv");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			//reading the header
			String header = reader.readLine();
			header1 = header.split(",");
			//reading the footer
			String s1;
			while((rows=reader.readLine())!=null)
		
	      	{
			String[] aa = rows.split(",");
			//ArrayList<String> sdsf = csvtoArraylist(aa);//Arrays.toString--to display array details
			//list = arrylist(aa);
			//lst=arraList2(aa);
			ArrayList<String> lsts = csvtoArraylist(aa);
			String[] s12= lsts.toString().split(",");
			list=s12[5];
			lst=s12[0].toString();
			s1 = list.toString();
			
			ArrayList<String> aaa= new ArrayList<>();
			Set<String> as=new LinkedHashSet<>();
			if(access.equals(s1))
			{
				
			  //System.out.println(lst);
			 as.add(lst); 	
			}
			/*else if(access2.equals(s1))
			{
				System.out.println(lst);
			}*/
			//m2.put(access, aaa);
			//String[] ss = aaa.toString().split("[]");
			System.out.println(as);
			//System.out.println(m2);
		}
		}
		
		public static List<String> groupmbr1() throws IOException {
			System.out.println("enter the empid");
			String n=scan.next();
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

						a1.add(line[i]);
				}

			} // System.out.println("data from Arraylist:"+a1);
			return a1;
		}
	}
