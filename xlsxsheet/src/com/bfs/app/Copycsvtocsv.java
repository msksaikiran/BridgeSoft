package com.bfs.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copycsvtocsv {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
    
		 File of=new File("F:\\Bridgesoft\\task1.csv");
	     InputStream foos=new FileInputStream(of);
	     File f=new File("F:\\Bridgesoft\\task4.csv");
	     f.createNewFile();
	     OutputStream oos=new  FileOutputStream(f);
	     
	     byte[] buffer=new byte[1024];
	     int length;
	     while((length=foos.read(buffer))>0){
	    	 oos.write(buffer,0,length);
	    	 System.out.println("copied sucessfully...");
	     }
	     foos.close();
	     oos.close();
	}

}





		/*
		 * FileReader f1=new FileReader("F:\\Bridgesoft\\task1.csv");
		 * BufferedReader br=new BufferedReader(f1);
		 * 
		 * FileWriter f2=new FileWriter("F:\\Bridgesoft\\task2.csv"); 
		 * String verify; 
		 * while((verify=br.readLine())!=null)
		 *  { f2.write(verify);
		 * System.out.println("copied sucessfully..."); 
		 * } br.close();
		 * f2.close();
		 */
	
