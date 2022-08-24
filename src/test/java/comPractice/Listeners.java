package comPractice;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	public static WebDriver driver;
	public void onTestFailure(ITestResult result) {

		Random ran = new Random();
		int random = ran.nextInt(5);
		Date d = new Date();
		String d1 = d.toString();
		System.out.println("=======DONE=======");
		String testName = result.getMethod().getMethodName();
		System.out.println(testName);
		EventFiringWebDriver ts = new EventFiringWebDriver(driver);
//		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File dstFile = new File("./screenshot/"+testName+random+".png");
		try {
			FileUtils.copyFile(srcFile, dstFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
