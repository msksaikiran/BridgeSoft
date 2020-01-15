package com.bfs.app;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xlsxwrite {
	public static void main(String[] args) 
		{ 
		// Blank workbook 
		XSSFWorkbook workbook = new XSSFWorkbook();
		System.out.println("workbook== " + workbook);
		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet();

		// This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "ID", "NAME", "LASTNAME" });
		data.put("2", new Object[] { 1, "sai", "M" });
		data.put("3", new Object[] { 2, "kiran", "S" });
		data.put("4", new Object[] { 3, "chanaverra", "P" });
		data.put("5", new Object[] { 4, "swetha", "k" });

		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		System.out.println(keyset);
		int rownum = 0;
		for (String key : keyset) {
		// this creates a new row in the sheet
		Row row = sheet.createRow(rownum++);
		System.out.println("rows:"+row);
		
		Object[] objArr = data.get(key);
		System.out.println(objArr);
		int cellnum = 0;
		for (Object obj : objArr) {
		// this line creates a cell in the next column of that row
		Cell cell = row.createCell(cellnum++);
		if (obj instanceof String)
		cell.setCellValue((String) obj);
		else if (obj instanceof Integer)
		cell.setCellValue((Integer) obj);
			}
		}
		try {
			// this Writes the workbook gfgcontribute
			FileOutputStream out = new FileOutputStream(new File("F:\\file\\s.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}


