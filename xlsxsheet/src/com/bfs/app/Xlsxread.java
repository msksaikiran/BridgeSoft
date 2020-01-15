package com.bfs.app;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xlsxread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        try
		        {
		            FileInputStream file = new FileInputStream(new File("F:\\file\\bridgesol.xlsx"));
		 
		            //Create Workbook instance holding reference to .xlsx file
		            XSSFWorkbook workbook = new XSSFWorkbook(file);
		 
		            //Get first desired sheet from the workbook
		            XSSFSheet sheet = workbook.getSheetAt(0);
		 
		            //Iterate through each rows one by one
		            Iterator<Row> rowIterator = sheet.iterator();
		            while (rowIterator.hasNext())
		            {
		                Row row = rowIterator.next();
		                //System.out.print(row);
		                //For each row, iterate through all the columns
		                Iterator<Cell> cellIterator = row.iterator();
		                 
		                while (cellIterator.hasNext())
		                {
		                    Cell cell = cellIterator.next();
		                    System.out.print(cell+"\t");
		                    //Check the cell type and format accordingly
		                    /*switch (cell.getCellType())
		                    {
		                        case  NUMERIC:
		                            System.out.print(cell.getNumericCellValue() + "\t\t");
		                            break;
		                        case STRING:
		                            System.out.print(cell.getStringCellValue() + "\t\t");
		                            break;
		                    }*/
		                }
		                System.out.print("\n");
		                }
		           System.out.println("using extended for");
		            for(Row k: sheet)
		            {
		            for(Cell c:k){
		            	System.out.print(c+"\t");
		            }
		            	System.out.println();
		            }
		            file.close();
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
		    }
	}


