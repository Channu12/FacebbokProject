package com.fb.login;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.trent.genericutility.BaseClass;

public class Loggin extends BaseClass{
	@Parameters({"BROWSER"})
	
	@Test(groups = "Smoke")
	public void loginByNoTest()
	{
		System.out.println("======Successfully Logged In By No.======");
	}
	@Test
	public void LogoutTest()
	{
		System.out.println("======Successfully Logged Out======");
	}
	@Test
	public void logInByMailTest()
	{
		System.out.println("======Successfully Logged In By Mail======");
	}
	@Test
	public void logInByMailAndMNoTest()
	{
		System.out.println("======Successfully Logged In By Mail======");
		
	}
	
}
