package dfsdfd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class CountingTheWordsInFile {
	
	public static void main(String[] args) throws Exception {
         Scanner scan=new Scanner(System.in);
		long time1 = System.currentTimeMillis();
		System.out.println(time1);
		try{
		BufferedReader reader = new BufferedReader(new FileReader("F:\\sir\\file2.txt"));
		
		int count = 0;
		String data;
		
		for (String s : args) {
			System.out.println(s);
		}
		while ((data = reader.readLine()) != null) {
			String[] ch = data.split(" ");

			for (int i = 0; i < ch.length; i++) {
				// if(ch[i].equalsIgnoreCase("welcome"))
				if (ch[i].equalsIgnoreCase(args[1])) {
					count++;
				}
			}
		}
		
		System.out.println("no. of words in the given file:" + count);
		long time2=System.currentTimeMillis();
		System.out.println(time2-time1);
		reader.close();
		}catch(Exception ae){
			System.out.println("enter the word first and proper file name");
		}
		
	}
	
	
}
