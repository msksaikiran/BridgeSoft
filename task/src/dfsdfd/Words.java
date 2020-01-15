package dfsdfd;

import java.io.BufferedReader;

import java.io.FileReader;

import java.util.Scanner;



public class Words {

	public static void main(String[] args) throws Exception {
		System.out.println("entre the path");
		/*Scanner scan=new Scanner(new FileReader("F:\\sir\\file2.txt"));
		//Scanner scan=new Scanner(new FileReader(scan.next()));
		int count=0;
		while(scan.hasNext())
		{
			String s=scan.next();
			//if(s.equals("welcome"))
			if(s.contentEquals("welcome"))
			count++;
			
			System.out.println(s);
		}*/
		
	
		BufferedReader reader= new BufferedReader(new FileReader("F:\\sir\\file2.txt"));
		//String data = reader.readLine();
		
		
		int flage=0;
		int count=0;
		String data;
		while((data=reader.readLine())!=null)
		{
			System.out.println(data);
			//data.toCharArray();
			String[] ch = data.split(" ");
			
			for(int i=0;i<ch.length;i++)
			{
			if(ch[i].equalsIgnoreCase("welcome"))
			count++;
			System.out.println(count+"="+ch[i]);
			
			}
		}
			
		//scan.close();
		System.out.println("no. of words:"+count);
		//System.out.println("no. of spaces:"+flage);
	}
}
