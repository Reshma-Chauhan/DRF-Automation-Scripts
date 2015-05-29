package com.drf.tournament;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.runners.model.TestClass;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ReadExcel {
	

	

	public void  fileread() throws BiffException, IOException
	{	

		System.out.println("1: Hellooooooo");	
		String FilePath = "D:\\SeleniumWorkspace\\Tournaments\\Tracks.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		String data;

				//TO get the access to the sheet
				Sheet sh = wb.getSheet("Sheet1");

				// To get the number of rows present in sheet
				int rows = sh.getRows();
				System.out.println(rows);

				// To get the number of columns present in sheet
				int cols = sh.getColumns();
				System.out.println(cols);
				
				for(int i=0; i < rows ;i++)
				{
					for(int j=0 ;j< cols;j++)
					{
					data = sh.getCell(j, i).getContents();
					System.out.println("\n" + data);
					}
					System.out.println("\n value of i" + i);
				}
		
				//data =sh.getCell(j,i).getContents();
				
				
				
	}
	
	public static void main(String args[]) throws BiffException, IOException
	{
		ReadExcel DT = new ReadExcel();
		DT.fileread();
	}
}
