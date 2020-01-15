package org.bridgesoft.app;



	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Map;
	import java.util.Scanner;
	public class map3 {
		static String stringValue="";
		static String fnameValue=null,lnameValue=null,mnameValue=null;
		static List<Map<String,String>> arrayList= new ArrayList<>();
		static Map<String,String> hashMap=null;
		static String more="";
		static String mails="";
		public static void mailMethod()
		{
			do{
			hashMap=new HashMap<>();
			Scanner scanner=new Scanner(System.in);
			System.out.print("enter firstName: ");
			fnameValue=scanner.next();
			System.out.print("enter lastName: ");
			lnameValue=scanner.next();
			System.out.print("enter middleName: ");
			mnameValue=scanner.next();
			hashMap.put("fnameValue", fnameValue);
			hashMap.put("lnameValue", lnameValue);
			hashMap.put("mnameValue", mnameValue);
			arrayList.add(hashMap);
			System.out.println("want to continue enter 'Y': ");
			more = scanner.next();
			}
			while(more.equalsIgnoreCase("y"));
		}
		
		public static void main(String[] args) {
			
			mailMethod();
			Iterator iterator = arrayList.iterator();
			while(iterator.hasNext())
			{
				hashMap = (Map) iterator.next();
				mails += "["+hashMap.get("fnameValue")+"."+hashMap.get("lnameValue")+"."+hashMap.get("mnameValue")+"]"+hashMap.get("fnameValue")+"."+hashMap.get("lnameValue")+"."+hashMap.get("mnameValue")+"@gmail.com"+";";
			}
			System.out.println(mails);
			
	}
	}

