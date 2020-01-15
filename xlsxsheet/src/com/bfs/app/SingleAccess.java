package com.bfs.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SingleAccess {
	public static void main(String[] args) throws IOException {
		
    Scanner scan=new Scanner(System.in);
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
	String rows;
	while((rows=reader.readLine())!=null)
	{
	String[] aa = rows.split(",");
	String Fst = aa[0];
	String Fvst = aa[5];
	if(access.equals(Fvst))
	{
	 a1.add(Fst); 
	}
    }
	System.out.println(a1);
	
	scan.close();
	reader.close();
}
	
	}

