package com.crm.trent.genericutility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

/**
 * It contains all Reusable Actions of Webdriver
 * @author User
 *
 */
public class WebDriverUtility {
	/**
	 * It is an implicitly wait Always wait for Element in DOM document and release the control if element is available
	 * @param driver
	 */
	public void waitForElementDOM(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * It is an Explicitly wait Always wait for page to be loaded and available in GUI
	 * @param driver
	 * @param partialPageURL
	 */
	public void waitForPage(WebDriver driver , String partialPageURL) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlContains(partialPageURL));
	}
	/**
	 * It is an Explicitly wait Always wait for Page to be loaded and available in GUI
	 * @param driver
	 * @param partialPageURL
	 */
	public void waitForElement(WebDriver driver , WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * It is used to Switch Any Window, based on Window Title
	 * @param driver
	 * @param partialWindowTitle 
	 */
	public void switchToWindow(WebDriver driver , String partialWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext())
		{
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * It is used to switch alert window and click on OK button
	 * @param driver
	 */
	public void switchToWindowAndAccept(WebDriver driver , String expectedMsg)
	{
		Alert alt = driver.switchTo().alert();
		if(alt.getText().trim().equalsIgnoreCase(expectedMsg.trim()))
		{
			System.out.println("Alert Message is Verified");
		}
		else
		{
			System.out.println("Alert Message is not verified");
		}
		alt.accept();
	}
	/**
	 * It is used to Switch to Alert Window and click on Cancel button
	 * @param driver
	 */
	public void sitchToAlertWindowAndCacel(WebDriver driver , String expectedMsg)
	{
		Alert alt = driver.switchTo().alert(); 
		if(alt.getText().equals(expectedMsg))
		{
			System.out.println("Alert Message is Verified");
		}
		else
		{
			System.out.println("Alert Message is not Verified");
		}
		alt.dismiss();
	}
	/**
	 * It is used to Switch to Frame Window, based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver , int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * It is used to Switch to Frame Window based on if or name attribute 
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver , String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}
	/**
	 * It is used to to select the value from the dropdown based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * It is used to select the value from the dropdown based on value/option available in GUI
	 * @param element
	 * @param value
	 */
	public void select(WebElement element , String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * Used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement( WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * Used to Right Click on Specified Element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver , String javaScript)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript(javaScript, null);
	}
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count = 0;
		while(count<20)
		{
			try
			{
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * Pass enter Key appertain in to Browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

}
