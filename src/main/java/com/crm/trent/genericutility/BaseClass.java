package com.crm.trent.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Facebook.ObjectRepositoty.LoginOrSignUpPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver = null;
	
	DataBaseUtility dLib = new DataBaseUtility();
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	@Parameters({"BROWSER"})
	
	@BeforeSuite(groups = "Smoke")
	public void conBS() {
		System.out.println("======dB Connected======");
	}
	
	@BeforeClass
	public void conBC(String BROWSER) {
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
	}
	
	@BeforeMethod
	public void conBM() {
		System.out.println("=====Login====");
	}
	@AfterMethod
	public void conAM()
	{
		System.out.println("=====Logout=======");
	}
	@AfterClass
	public void conAC()
	{
		driver.quit();
	}
	@AfterSuite
	public void conAS()
	{
		System.out.println("======dB Closed======");
	}
}
