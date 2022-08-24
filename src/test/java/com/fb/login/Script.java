package com.fb.login;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.fb.login.Listeners.class)
public class Script extends BaseClass {
	@Test
	public void takePic1()
	{
		driver.get("http://www.youtube.com");
		Assert.assertEquals("a", "b");
	}
}
