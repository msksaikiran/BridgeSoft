package com.bfs.app;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CopyCsvtoXlsx {
	public static void main(String[] args) {
		String[] s2 = null;
		BufferedReader csvReader;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the destination path");
		String path = scan.next();

		try {
			FileOutputStream fos = new FileOutputStream(path + ".xlsx");
			csvReader = new BufferedReader(new FileReader("F:\\Bridgesoft\\notepad\\ACME finance.csv"));

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet();
			int count = 0;
			// getting the values
			String row;
			while ((row = csvReader.readLine()) != null) {
				s2 = row.split(",");
				Row row1 = sheet.createRow(++count);
				int column = 0;
				for (String r : s2) {
					// creating the columns
					Cell cell = row1.createCell(++column);
					// setting the values to each cell
					cell.setCellValue(r);
				}
				column = 0;

			}
			workbook.write(fos);

			System.out.println("file created.......");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
