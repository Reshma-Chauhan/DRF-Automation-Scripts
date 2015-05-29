package com.drf.tournament;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class CallingExl {
	
	
	

	public String CallExcel() throws BiffException, IOException {
		// TODO Auto-generated method stub
		System.out.println("1: Hellooooooo");	
		String FilePath = "D:\\SeleniumWorkspace\\Tournaments\\Tracks.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		String data;
		int i=0,j=0;
				//TO get the access to the sheet
				Sheet sh = wb.getSheet("Sheet1");

				// To get the number of rows present in sheet
				int rows = sh.getRows();
				System.out.println(rows);

				// To get the number of columns present in sheet
				int cols = sh.getColumns();
				System.out.println(cols);
				
				
				data =sh.getCell(0,i).getContents();
				i++ ; j++;
				
				return data;
	}

	
	public String CallRace() throws BiffException, IOException {
		// TODO Auto-generated method stub
		System.out.println("1: Hellooooooo");	
		String FilePath = "D:\\SeleniumWorkspace\\Tournaments\\Tracks.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		String raceNumber;
		int i=0,j=0;
				//TO get the access to the sheet
				Sheet sh = wb.getSheet("Sheet1");

				// To get the number of rows present in sheet
				int rows = sh.getRows();
				System.out.println(rows);

				// To get the number of columns present in sheet
				int cols = sh.getColumns();
				System.out.println(cols);
				
				
				raceNumber =sh.getCell(1,i).getContents();
				i++;j++;
				return raceNumber;
	}


}
