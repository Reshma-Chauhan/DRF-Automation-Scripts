package com.drf.tournament;

import java.io.IOException;

import jxl.read.biff.BiffException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginClass {
	
	 

	public static void Login(WebDriver driver) throws InterruptedException, BiffException, IOException
	{
				
		System.out.println("1:Login button clicked");
		WebElement Login=driver.findElement(By.xpath(".//*[@id='ng-app']/body/div[1]/div/div/div/ul/li[1]/a"));
		Login.click();
		Thread.sleep(5000);
		WebElement username=driver.findElement(By.id("username"));
	//	username.clear();
		username.sendKeys("sucheta.dekate@weboniselab.com");
		WebElement password=driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("webo6186");
		//WebElement button=driver.findElement(By.className("btn "));
		driver.findElement(By.xpath("html/body/div[2]/div[3]/aside/div/form/ul/li[4]/input")).click();
	//	button.click();
		System.out.println("Login button clicked");
		Thread.sleep(15000);
		System.out.print("1::::::::::fgdfhrwetguryeuryertuyertueryt");
		
		
		
	}
}
