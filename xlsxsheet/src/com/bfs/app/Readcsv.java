package com.bfs.app;

import java.io.BufferedReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Readcsv {
	
	public static void main(String[] args) {
	String[] s2=null;
	BufferedReader csvReader;
	String row;
	Map<String,ArrayList<String>> m1=new LinkedHashMap<>();
	try {
		
		csvReader = new BufferedReader(new FileReader("F:\\Bridgesoft\\ACME finance.csv"));
	
		while ((row = csvReader.readLine()) != null) {
		   s2=row.split(",");
		   //aa=csvtoArraylist(row);
			ArrayList<String> a1=new ArrayList<>();
			if(row!=null)
			{
				String[] splitdata=row.split(",");
				
				for(int i=0;i<splitdata.length;i++)
				{
					if(!(splitdata[i]==null)||!(splitdata[i].length()==0))
						a1.add(splitdata[i]);
				}
				
			}System.out.println("araylist values:"+a1);
		    m1.put(s2[0], a1);
		    
		    
		}//System.out.println(m1);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
	
	/*private static ArrayList<String> csvtoArraylist(String line) {
		// TODO Auto-generated method stub
		ArrayList<String> a1=new ArrayList<>();
		if(line!=null)
		{
			String[] splitdata=line.split("\\s*, \\s*");
			
			for(int i=0;i<splitdata.length;i++)
			{
				if(!(splitdata[i]==null)||!(splitdata[i].length()==0))
					a1.add(splitdata[i]);
			}
			
		} //System.out.println("data from Arraylist:"+a1);
		return a1;
	}
	
}
	
		/*int count=0;
		do {
		System.out.println("enter 1 to search element");
		System.out.println("enter 2 to now the details from map");
		System.out.println("enter your choice");
		int choice=scan.nextInt();
		
		switch(choice)
		{
		
		case 1:searchele();
		       count++;
		break;
		case 2:mapdeatils();
		       count++;
		break;
		}
		System.out.println("enter 1 to continue");
		System.out.println("enter 0 to exit");
		int choice2=scan.nextInt();
		switch(choice2)
		{
		case 1:continue;
		       
		case 0:System.exit(0);
		       break;
		}
		}while(count>=1);
		
		 System.out.println("key value:"+m1.keySet()+"\n");
		
		csvReader.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static void searchele()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the key to be search");
		String n=scan.next();
		ArrayList<String> as=m1.get(n);
		//System.out.println(header[0]+"="+as);
		Object[] o1=as.toArray();
		for(int i=0;i<o1.length;i++)
		{
		System.out.println(header[i]+"=="+as);
		}
		
	}
	
	public static void mapdeatils()
	{
		m1.forEach((k,v)->System.out.println("key:"+k+"\t"+"values:"+v));
		System.out.println("using for each");
		for(Map.Entry<String, ArrayList<String>> value:m1.entrySet())
	    {
	    	System.out.println("key:"+value.getKey());
	    	System.err.println("values:"+value.getValue());
	    }
	}*/

	

