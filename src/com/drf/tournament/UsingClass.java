package com.drf.tournament;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingClass {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;


		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		String url="http://tournamentsdev.drf.com";
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement Login=driver.findElement(By.xpath(".//*[@id='ng-app']/body/div[1]/div/div/div/ul/li[1]/a"));
		Login.click();
		

	}

}
