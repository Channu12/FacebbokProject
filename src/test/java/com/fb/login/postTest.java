package com.fb.login;

import org.testng.annotations.Test;

import com.crm.trent.genericutility.BaseClass;

public class postTest extends BaseClass {

	@Test
	public void postPicTest()
	{
		System.out.println("======Successfully Posted Pic======");
	}
	@Test(groups = "Smoke")
	public void postVideoTest()
	{
		System.out.println("======Successfully Posted Video======");
	}
	@Test
	public void postAudioTest()
	{
		System.out.println("======Successfully Posted Audio======");
	}
}
