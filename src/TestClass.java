import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.record.formula.functions.Row;

import jxl.Cell;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class TestClass {

	public static void main(String[] args) throws JXLException, IOException {
		
		TestClass DT = new TestClass();
		DT.readExcel();
	}

	public void readExcel() throws JXLException, IOException
	{
		String FilePath = "D:\\SeleniumWorkspace\\Tournaments\\Reshma.xls";
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
		
		
		
		Cell cell;
		String CellGetContent = sh.getCell(0,0).getContents();
		System.out.println(CellGetContent);
		

		/*for(int i = 0 ; i <= rows ; i++)
		{
			System.out.print("\n value of i   :" +i);
			for(int j=1 ;j <=cols ;j++)
			{
				cell =sh.getCell(i,j).getContents();
				System.out.print("\n value of j  :" +j);
				data=sh.getCell(i, j).getContents();
				System.out.print("\n"+ data);
			}
			System.out.print("\n");
			*/
			
	
		
		
		}
		
	}
	

