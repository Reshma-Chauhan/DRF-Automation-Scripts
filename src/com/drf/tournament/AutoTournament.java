package com.drf.tournament;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.crypto.SealedObject;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoTournament {


	
		private static WebDriver driver;
	//	private static WebDriver driver;
		Workbook wb = null;
		Sheet s;
		String Track1 = "Aqueduct";
		String Track2 = "Fair Grounds";
		String trackName,raceNumber;
		AdminLogin loginToApp =new AdminLogin();  
		
		@BeforeTest
		public void openBrowser()
		{
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		String url ="http://tournamentsadmindev.drf.com/tournaments/";
		driver.get(url);
		driver.manage().window().maximize();
		
		}
		

		@Test
		public void Logintotourey() throws InterruptedException, IOException, BiffException
		{
			loginToApp.Login(driver);
			
		}
		@Test
		public void createTournament() throws InterruptedException, BiffException, IOException
		{
				Thread.sleep(8000);
			 System.out.println("About to click on create new link");
			 System.out.println(driver.getCurrentUrl().toString());
			
			 
			 String trn = driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/div[3]/div[2]/section/div/div[2]/h2")).getText();
			 
			 System.out.println("Strin is " + trn);
			 driver.findElement(By.linkText("Create New")).click();
			 Thread.sleep(10000);
		//	 driver.findElement(By.xpath("/html/body/div[3]/div[2]/section/div/div[2]/div[2]/a/i")).click();
		//	 System.out.println("Clicked on create new link");
			
	/*		WebElement CreateTour=driver.findElement(By.xpath(".//*[@id='ng-app']/body/div[3]/div[2]/section/div/div[2]/div[2]/a"));
			CreateTour.click();
			*/
			
			/*WebElement Public=driver.findElement(By.id("showEntries"));
			CreateTour.click();*/
			
			Thread.sleep(1900);
			driver.findElement(By.name("tournament_name")).sendKeys("Let's Play");
			driver.findElement(By.name("summary")).sendKeys("This tournament is for testing");

			
//***********************************Selecting start date from date picker*************************************
				
		
			/*driver.findElement(By.name("start_date")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/div[16]/div[1]/div[2]/table/tbody/tr[5]/td[3]")).click();*/
			
			
			
			Thread.sleep(5000);
	//Date selection 		
			driver.findElement(By.name("start_date")).click();
			
			
			List<WebElement> Rows=driver.findElements(By.xpath("/html/body/div[6]/div[1]/div[2]/table/tbody/tr"));
			System.out.println("value of <tr> is "+ Rows.size());
			
			for(int i=1;i<=Rows.size();i++)
			{
				System.out.println("value of i is"+ i );
				Thread.sleep(500);
				List<WebElement> cols=driver.findElements(By.xpath("/html/body/div[6]/div[1]/div[2]/table/tbody/tr["+i+"]/td"));
			//	System.out.println("value of <td> is "+ cols.size());
				for (int j=1; j<=cols.size();j++)
				{
					System.out.println("value of j is "+ j );
					
					//WebElement day=datePicker.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/table/tbody/tr["+i+"]/td["+j+"]"));
					
					String tddate = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/table/tbody/tr["+i+"]/td["+j+"]/div")).getText();
					System.out.println("date is tdate :"+tddate);
					if (tddate.equals("30"))
					{
						System.out.println("inside if loop");
						Thread.sleep(500);
						System.out.print("value of i :" +i );
						System.out.println("value of j is : "+ j );
						WebElement button =driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/table/tbody/tr[5]/td[7]/div"));
					//	WebElement button =driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/table/tbody/tr["+i+"]/td["+j+"]/div"));
						button.click();
						Thread.sleep(500);
						break;
					
					}
					Thread.sleep(300);
				}
	
				
							
			
			
//***********************************Selecting start date from date picker*************************************			
			
		   
			System.out.println("Before CallExcel");
			 
		//	CallExcel();
			
			System.out.println("Again In Main");
			
			
			driver.findElement(By.name("fee")).sendKeys("0");
			driver.findElement(By.xpath(".//*[@id='ng-app']/body/div[3]/div[2]/form/section/div[2]/div[2]/div[3]/ul/li[2]/div[2]/input")).sendKeys("3");
		//	driver.findElement(By.xpath(".//*[@id='ng-app']/body/div[3]/div[2]/form/section/div[2]/div[2]/div[3]/ul/li[3]/div/input")).sendKeys("1");
			driver.findElement(By.name("prizeDollar")).sendKeys("20");
			driver.findElement(By.name("prizeSpecial")).sendKeys("iphone 5");
	
//Deadline date selction
			
			
			Thread.sleep(800);
			driver.findElement(By.name("deadlineDate")).click();
			List<WebElement> RowsDeadline=driver.findElements(By.xpath("/html/body/div[6]/div[1]/div[2]/table/tbody/tr"));
			System.out.println("value of <tr> is "+ Rows.size());
			
			for(int k=1;k<=RowsDeadline.size();k++)
			{
			//	System.out.println("inside 1st for loop which for <TR>");
				Thread.sleep(500);
				List<WebElement> colsDeadline=driver.findElements(By.xpath("/html/body/div[7]/div[1]/div[2]/table/tbody/tr["+i+"]/td"));
				System.out.println("value of <td> is "+ cols.size());
				for (int m=1; m<=colsDeadline.size();m++)
				{
					System.out.println("inside 1st for loop which for <TD>");
					
					String tddate1 = driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/table/tbody/tr["+k+"]/td["+m+"]/div")).getText();
					System.out.println("date is tdate :"+tddate1);
					if (tddate1.equals("29"))
					{
						System.out.println("inside if loop");
						Thread.sleep(500);						
						 WebElement button=driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/table/tbody/tr["+k+"]/td["+m+"]/div"));
						 button.click();
						
						break;
					
					}
					Thread.sleep(300);
										
				}
			}
				List<WebElement> time=driver.findElements(By.xpath("/html/body/div[7]/div[2]/div/div/div"));
				
				for(int l=0;l<=time.size();l++)
				{
					String time_in_min = driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div["+l+"]")).getText();
					
					System.out.println("time is is tdate :"+time_in_min);
					if (time_in_min.equals("12:00"))
					{
						System.out.println("inside if loop");
						driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div["+l+"]")).click();
						Thread.sleep(500);
						break;
					
					}
					Thread.sleep(300);
				
				
			
			
			}

		
			
			
			
			Thread.sleep(5000);
			
		//	driver.findElement(By.xpath("/html/body/div[9]/div[1]/div[2]/table/tbody/tr[4]/td[4]")).click();
			Thread.sleep(3000);
			
	//		driver.findElement(By.xpath(".//*[@id='ng-app']/body/div[9]/div[2]/div/div[1]/div[60]")).click();
					Thread.sleep(2000);
			WebElement submit=driver.findElement(By.className("btn "));
	//		submit.click(); 
		
			
			}	
			}
	

		
		
	
		
		
		public void CallExcel() throws BiffException, IOException, InterruptedException
		{
			
			
			System.out.println("1: Hellooooooo");	
			String FilePath = "D:\\SeleniumWorkspace\\Tournaments\\Tracks1.xls";
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
					
					
					for(int i=0; i <5 ;i++)
					{
						
						trackName = sh.getCell(0,i).getContents();
						System.out.println("\n" + trackName);
						raceNumber = sh.getCell(1, i).getContents();
						System.out.println("\n" + raceNumber);
						
						System.out.print("Before PrintExcel");
						printExcel();
						System.out.print("After printExcel");
						
					}
					
					Thread.sleep(5000);
					
			
			
					
		}
		
		
		public void printExcel() throws BiffException, IOException, InterruptedException {
			
			
			
			System.out.print("Inside PrintExcel");
			WebElement tracks=driver.findElement(By.name("track"));
			Select elements= new Select(tracks);
			elements.selectByVisibleText(trackName);
			Thread.sleep(500);
			WebElement races = driver.findElement(By.xpath(".//*[@id='ng-app']/body/div[3]/div[2]/form/section/div[2]/div[2]/div[2]/ul/li[4]/div[2]/select"));
			Select elements1= new Select(races);
			Thread.sleep(500);
			elements1.selectByVisibleText(raceNumber);
			Thread.sleep(1000);
			driver.findElement(By.linkText("Add New")).click();
			
			Thread.sleep(5000);
			System.out.print("Outside PrintExcel");
			
			
			
		}
		
		
		
}

