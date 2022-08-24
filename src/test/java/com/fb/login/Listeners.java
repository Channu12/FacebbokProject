package com.fb.login;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener {

	public void onTestFailure(ITestResult result) {

		String mName = result.getMethod().getMethodName();

		EventFiringWebDriver ts = new EventFiringWebDriver(driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+mName+".jpg");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	

}
