package comPractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(comPractice.Listeners.class)
public class Screenshot extends comPractice.Listeners{
	
	@Test
	public void takePic1()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		Assert.assertEquals("a", "b");
	}
}
