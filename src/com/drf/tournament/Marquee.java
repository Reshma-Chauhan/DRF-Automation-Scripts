package com.drf.tournament;

import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Marquee {
	

	WebDriver driver;
	Workbook wb = null;
	
	@BeforeTest
	public void login()
	{
	AutoTournament at = new AutoTournament();
	at.openBrowser();
	}
	
	
	@Test
	public void CreateMarquee() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement creat = driver.findElement(By.linkText("Create New"));
		creat.click();
		WebElement MarqueeTitle = driver.findElement(By.xpath(".ng-pristine.ng-invalid.ng-invalid-required.ng-valid-minlength"));
		MarqueeTitle.sendKeys("Title for marquee");
		WebElement HeadLine = driver.findElement(By.name("headline"));
		HeadLine.sendKeys("This is a HeadLine");
	}

}
