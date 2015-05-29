package com.drf.tournament;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLogin {

	public static void Login(WebDriver driver) throws InterruptedException, BiffException, IOException
	{
				
		System.out.println("1:Login button clicked");
		Thread.sleep(5000);
		WebElement username=driver.findElement(By.name("userName"));
	//	username.clear();
		username.sendKeys("admin");

		WebElement password=driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("admin");
		WebElement button=driver.findElement(By.className("btn "));
		button.click();
		System.out.println("Login button clicked");
		Thread.sleep(15000);


	}
}
	
