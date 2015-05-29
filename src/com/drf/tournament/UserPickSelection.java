package com.drf.tournament;

import java.io.IOException;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class UserPickSelection {

	

	private static WebDriver driver;
	
		LoginClass loginToApp =new LoginClass();  
		
		@BeforeTest
		
		public void openBrowser()
		{
			
		/*	System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
		    driver = new InternetExplorerDriver();	*/
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		String url="http://tournamentsdev.drf.com/tournaments";
	//	String url="http://dev-drftournaments.weboapps.com/tournaments";
		driver.get(url);
		driver.manage().window().maximize();
		
		}
		

		@Test
		public void Logintotourey() throws InterruptedException, IOException, BiffException
		{
				loginToApp.Login(driver);
				Thread.sleep(6000);
			
			//For Entring
			
		
				System.out.println("After Login\n");						
				List<WebElement> Tournaments = driver.findElements(By.xpath(".//*[@id='allTournaments']/ul/li"));
				System.out.println("no of tournaments are " + Tournaments.size());
			//	driver.findElement(By.xpath(".//*[@id='allTournaments']/ul/li[2]/div/div[2]/div[1]/div[3]/a")).click();
		//		driver.findElement(By.linkText("Confirm Entry")).click();
				Thread.sleep(1000);
			//	System.out.println("confirmed before making entry");
				
				for(int i=2;i<= Tournaments.size();i++)	
				{
	
					System.out.println("Inside for loop\n");
					Thread.sleep(6000);
					//driver.findElement(By.xpath(".//*[@id='allTournaments']/ul/li[2]/div/div[2]/div[1]/div[3]/a")).click();
					
					String type=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/section/div[1]/div/div/div[1]/ul/li["+i+"]/div/div[2]/div[1]/div[3]/a")).getText();
					Thread.sleep(1000);
					System.out.println("value of EnterLink is"+ type);
					if(type=="Enter" || type.equals("Enter"))
					{
						System.out.println("1: Inside if method");
						driver.findElement(By.xpath(".//*[@id='allTournaments']/ul/li["+i+"]/div/div[2]/div[1]/div[3]/a")).click();
						
						driver.findElement(By.linkText("Confirm Entry")).click();
						Thread.sleep(2000);
						System.out.println("confirmed before making entry");
						pickSelection();
						break;
					}
					else if(type=="Closed" || type.equals("Closed"))
					{
						System.out.println("Inside Else if closed loop");
						
					}
						
					else
					{
						System.out.println("Inside Else(Add/Edit) loop");
						Thread.sleep(5000);
													
						driver.findElement(By.xpath(".//*[@id='allTournaments']/ul/li["+i+"]/div/div[2]/div[1]/div[3]/a")).click();
						pickSelection();
						break;
					}
					
		
		
						
				}
			
		
	
		}




		


		private void pickSelection() throws InterruptedException
		{
			System.out.println("Inside pick selection method\n");														
			Thread.sleep(5000);
			List<WebElement> tracks = driver.findElements(By.xpath(".//*[@id='mCSB_1']/div[1]/ul/li"));
			Thread.sleep(1000);
			int trackcount = tracks.size();
			System.out.println("no of tracks in tournament are" +trackcount);
			for (int i=1;i<=tracks.size();i++)
			{
				System.out.println("value of i is" + i);
				driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/section/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[1]/ul/li["+i+"]")).click();
				Thread.sleep(1000);
				List<WebElement> radio = driver.findElements(By.id("showEntries"));
				System.out.println("no of radio buttons are\t"+ radio.size());
			//	radio.get(1).click();
				Thread.sleep(500);
				radio.get(1).click();
				Thread.sleep(1000);
			}
			
			driver.findElement(By.id("submitPicks")).click();
	
			
			
			
		}
		

}
