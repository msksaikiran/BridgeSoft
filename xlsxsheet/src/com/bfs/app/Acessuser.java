package com.bfs.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Acessuser {

	private static String rows;
	static String list ;
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		System.out.println("enter 1 reading the data from csv file");
		System.out.println("enter 2 for single access");
		System.out.println("enter 3 to now username on multiple access");
		System.out.println("enter 4 to know the access based on key");
		System.out.println("enter 5 for to now complete details fo user");
		System.out.println("enter 6 to know the key of inactive&Access");
		System.out.println("enter 7 to write the data from csv to xslx");
		
		int choice=scan.nextInt();
		switch(choice)
		{
		case 1:CsvtoArraylist();
		break;
		case 2:getId();	
		break;
		case 3:multipleAcess();
		break;
		case 4:System.out.println("enter the id ");
		       String s=scan.next();
			   Map<String, List<String>> map = groupmbr1(s);
			   System.out.println(map);
		break;
		case 5:completedetails();
		break;
		case 6:inActivenaccess();
		break;
		case 7:csvtoxlsx();
		break;
		}
		
	}
	
	private static void getId() throws IOException 
	{
		
		System.out.println("enter the acess");
		String access=scan.next();
		//String access2=scan.next();
		ArrayList<String> aaa= new ArrayList<>();
		Set<String> a1=new LinkedHashSet<String>(aaa) ;
		
		File file = new File("F:\\Bridgesoft\\notepad\\ACME finance.csv");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		//reading the header
		reader.readLine();
		//reading the footer
		while((rows=reader.readLine())!=null)
		{
		String[] aa = rows.split(",");
		String Fst = aa[0];
		String Fvst = aa[5];
		if(access.equals(Fvst))
		{
		 a1.add(Fst); 
		}else {
			System.out.println("invalid grpmvr");
			break;
		}
		
	}
		System.out.println(a1);
	}
	static String Fst;
	private static void multipleAcess() throws IOException 
	{
		System.out.println("enter the acess");
		String access=scan.next();
		System.out.println("enter the access2");
		String access2=scan.next();
		Set<String> a1=new LinkedHashSet<String>() ;
		Set<String> a2=new LinkedHashSet<String>() ;
		//Set<String> a3=new LinkedHashSet<String>() ;
		
		File file = new File("F:\\Bridgesoft\\notepad\\ACME finance.csv");
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(file));
		//reading the header
		reader.readLine();
		//reading the footer
		while((rows=reader.readLine())!=null)
		{
		String[] aa = rows.split(",");
		String Fst = aa[6];
		String Fvst = aa[5];
		
		if(access.equals(Fvst))
		{
		 a1.add(Fst); 
		 //a3.add(Fst);
		}else {
			System.out.println("invalid grpmvr");
			break;
		}
		
		if(access2.equals(Fvst))
		{
			a2.add(Fst);
			
		} else {
			System.out.println("invalid grpmvr");
			break;
		}
		}
		a1.retainAll(a2);
		System.out.println(access+":id="+a1);
		//System.out.println(access+":id="+a3);
	    //System.out.println(access2+":id="+a2);
	    //System.out.println("Araaylist:"+a4);
		
	}
	
	public static void completedetails() throws IOException {
		String row = null;
		ArrayList<String> aa;
		BufferedReader csvfile;
		String s;
		String[] s2;
		Map<String, ArrayList<String>> m1 = new LinkedHashMap<>();
		Map<String, Object> m2 = new LinkedHashMap<>();

		try {
			csvfile = new BufferedReader(new FileReader("F:\\Bridgesoft\\ACME finance.csv"));
			// seperating the header
			s = csvfile.readLine();
			String[] header1 = s.split(",");
			// getting the values
			while ((row = csvfile.readLine()) != null) { // reading the file line-by-line
				s2 = row.split(",");
				aa = csvtoArraylist(s2);
				m1.put(s2[0], aa);
			}
			System.out.println("enter the key to be search");
			String n = scan.next();
			
			if ((m1.get(n)) != null) {

				ArrayList<String> a1 = m1.get(n);
				Map<String, List<String>> grpmvr = groupmbr1(n);
				String sq = grpmvr.toString();
				a1.remove(5);
				a1.add(5, sq);
				m2.put(n, a1);
				//System.out.println(m2);

			} else {
				System.out.println("record not found");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//scan.close();
		//return a1;
	}
	
	public static Map<String, List<String>> groupmbr1(String n) throws IOException {
		
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
		//System.out.println("cjcxjdcjhdcjhd:"+as);
		m4.put(n, as);
		//System.out.println(m4);
		csvfile1.close();
		
		return m4;
	}
	public static void inActivenaccess() throws IOException
	{
		    String Fst;
			System.out.println("enter the acess");
			String access=scan.next();
			System.out.println("enter the access2");
			String access2=scan.next();
			Set<String> a1=new LinkedHashSet<String>() ;
			Set<String> a2=new LinkedHashSet<String>() ;
			Set<String> a3=new LinkedHashSet<String>() ;
			ArrayList<String> a4=new ArrayList<>();
			File file = new File("F:\\Bridgesoft\\notepad\\ACME finance.csv");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			//reading the header
			reader.readLine();
			String rows;
			//reading the footer
			while((rows=reader.readLine())!=null)
			{
			String[] aa = rows.split(",");
			Fst = aa[4];
			String Fvst = aa[5];
			String idlst=aa[0];
			
			if(access.equals(Fst))
			{
			 a1.add(idlst); 
			 a3.add(idlst);
			}
			if(access2.equals(Fvst))
			{
				a2.add(idlst);	
			} 
			}
			a1.retainAll(a2);
			System.out.println("id="+a1);
			//System.out.println(access+":id="+a3);
		    System.out.println(access2+":id="+a2);
		    //System.out.println("Araaylist:"+a4);
			
		}
	
	
	private static ArrayList<String> csvtoArraylist(String[] line) {
		// TODO Auto-generated method stub
		ArrayList<String> a1 = new ArrayList<>();
		if (line != null) {
			for (int i = 0; i < line.length; i++) {
				if (!(line[i] == null) || !(line[i].length() == 0))

					a1.add(line[i]);
			}

		} System.out.println("data from Arraylist:"+a1);
		return a1;
	}

	public static void CsvtoArraylist() {
		String[] s2 = null;
		BufferedReader csv;
		String row;
		Map<String, ArrayList<String>> m1 = new LinkedHashMap<>();
		try {
			//System.out.println("enter the path");
            
			csv = new BufferedReader(new FileReader("F:\\Bridgesoft\\ACME finance.csv"));

			while ((row = csv.readLine()) != null) {
				s2 = row.split(",");
				ArrayList<String> a1 = new ArrayList<>();
				if (row != null) {
					String[] splitdata = row.split(",");

					for (int i = 0; i < splitdata.length; i++) {
						if (!(splitdata[i] == null) || !(splitdata[i].length() == 0))
							a1.add(splitdata[i]);
					}

				}
				System.out.println("araylist values:" + a1);
				m1.put(s2[0], a1);

			} // System.out.println(m1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void csvtoxlsx() {
    	String[] s2=null;
		BufferedReader csvReader;
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the destination path");
		String path=scan.next();
		System.out.println("enter the source path");
		String path2=scan.next();
		try {
			FileOutputStream fos=new FileOutputStream(path+".xlsx");
			csvReader = new BufferedReader(new FileReader(path2+".csv"));
			
		    Workbook workbook= new XSSFWorkbook();
		    org.apache.poi.ss.usermodel.Sheet sheet=workbook.createSheet();
		    int count=0;
		    //getting the values
			String row;
			while ((row = csvReader.readLine()) != null) {
			    s2=row.split(",");
			   Row row1=sheet.createRow(++count);
			   int column=0;
			   for(String r:s2)
			   {
				   //creating the columns
				   Cell cell=row1.createCell(++column);
				   //setting the values to each cell
				   cell.setCellValue(r);
			   }
			   column=0;
			  
			} workbook.write(fos);
			
			System.out.println("file created.......");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
	
