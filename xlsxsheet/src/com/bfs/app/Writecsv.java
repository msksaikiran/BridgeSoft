package com.bfs.app;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Writecsv{

		public static void main(String[] args) throws ClassNotFoundException, IOException {
			
			/*Scanner sc = new Scanner(System.in);
			System.out.println("enter the emp name");
			String s1=sc.nextLine();
			System.out.println("enter the emp Address");
			String s2= sc.nextLine();
			System.out.println("enter the empId");
			int s3=sc.nextInt();
			Employee e1 = new Employee(s1, s2, s3);
			//BufferedReader br=new BufferedReader(e1);
			File f1=new File("F:\\file\\objData.csv");
	        f1.createNewFile();
			OutputStream fos=new FileOutputStream(f1);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			/*Serializable verify;
			while((verify=e1.getClass())!=null)
			{
				f1.write(verify);
			}
			oos.writeObject(e1);
			//System.out.println(e1);
			oos.flush();
			fos.close();
			oos.close();
			sc.close();*/
			
		FileWriter csvWriter = new FileWriter("F:\\file\\ne3.csv");
		csvWriter.append("Name");
		csvWriter.append(",");
		csvWriter.append("Middle");
		csvWriter.append(",");
		csvWriter.append("LastName");
		csvWriter.append("\n");

		List<List<String>> rows = Arrays.asList(
				Arrays.asList("sai", "kiran", "M"),
				Arrays.asList("channa", "verra", "P"), 
				Arrays.asList("Siva", "teja", "V"));
		for (List<String> rowData : rows) {
			csvWriter.append(String.join(",", rowData));
			csvWriter.append("\n");
		}
		System.out.println("Details sucessfully stored...");
		csvWriter.flush();
		csvWriter.close();
	}
}


