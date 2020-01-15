package org.bridgesoft.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class mappp2 {
	static String[] mails;
public static void main(String[] args) {
    
    try(Scanner scan=new Scanner(System.in)){
    System.out.println("enter the no of maps");
    int maps=scan.nextInt();
    Map<String,String> hashmap=new LinkedHashMap<>();
    ArrayList<String> list=new ArrayList<>();
    //String.join(",", list);
    for(int i=1;i<=maps;i++)
    {
    	System.out.println("enter the First name:");
    	String firstvalue=scan.next();
    	System.out.println("enter the Last name:");
    	String Lastnamevalue=scan.next();
    	System.out.println("enter the middel name:");
    	String middlename=scan.next();
    	hashmap.put("fnameValue", firstvalue);
		hashmap.put("lnameValue", Lastnamevalue);
		hashmap.put("mnameValue", middlename);
		Collection<String> values1 = hashmap.values();
		String string = String.join(".", values1).replaceAll("&quot;", "");;
		System.out.println(string);
	    list.add(string);  
    } 
    
   String arr[]= String.join(",", list).split(",");
   for(int k=0;k<arr.length;k++)
   {
	   String ss="["+list.get(k)+"]"+arr[k]+"@gmail.com;";
	   System.out.print(ss);
   }
  }
    catch(Exception ae){
    System.out.println("enter the valid names");	
    }
}
}
