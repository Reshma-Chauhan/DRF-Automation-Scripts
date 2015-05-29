package com.drf.tournament;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoMarquee {
	
	private static final String WebDriver = null;
	
	private static WebDriver driver;
	AdminLogin loginToApp =new AdminLogin();  
	
	@BeforeTest
	
	public void openBrowser()
	{
	
	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	//String url="http://tournamentsdev.drf.com/";
	String url ="http://tournamentsadmindev.drf.com/tournaments/";
	//String url="http://dev-drftournaments.weboapps.com/tournaments";
	driver.get(url);
	driver.manage().window().maximize();
	
	}
	@Test
	public void creatMarqueeLink() throws BiffException, InterruptedException, IOException
	{
		
		
		System.out.print("Create Marquee before login \n");		
		loginToApp.Login(driver);
		Thread.sleep(1000);
		System.out.print("Create Marquee after login\n");
		Thread.sleep(1000);
		
	}
	
	
	@Test
	public void methodFORMarquee() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='ng-app']/body/div[3]/div[2]/section/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.linkText("Create New")).click();
		System.out.print("Create Marquee \n");
		Thread.sleep(1500);
		WebElement Marquee=driver.findElement(By.xpath(".//*[@id='ng-app']/body/div[3]/div[2]/section/div[2]/div/a"));
		Marquee.click();
		Thread.sleep(1000);

		System.out.print("Hello..........");
		WebElement MarqueeTitle = driver.findElement(By.name("title"));
		MarqueeTitle.sendKeys("Title for marquee");
		WebElement HeadLine = driver.findElement(By.name("headline"));
		driver.findElement(By.name("shortInformation")).sendKeys("Marquee Information");
		HeadLine.sendKeys("This is a HeadLine");
		
		WebElement upload=driver.findElement(By.id("marqueeimage"));
		upload.sendKeys("C://Users//Admin//Downloads//banner");
		Select priority = new Select(driver.findElement(By.id("slide_priority")));
		priority.selectByValue("2");
		driver.findElement(By.xpath(".//*[@id='ng-app']/body/div[3]/div[2]/section/div[2]/form/div[3]/input")).click();
		Thread.sleep(500);
		System.out.println("Before create button ");
		driver.findElement(By.className("btn ")).click();
		driver.findElement(By.xpath(".//*[@id='ng-app']/body/div[3]/div[2]/section/div[2]/form/div[3]/input")).click();
		System.out.println("After create button is clicked");
	}
	

	

	
	
}
