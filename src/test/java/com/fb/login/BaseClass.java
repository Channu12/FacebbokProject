package com.fb.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	@BeforeMethod
	public void configBM()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	@AfterMethod
	public void configAM()
	{
		driver.quit();
	}
}
