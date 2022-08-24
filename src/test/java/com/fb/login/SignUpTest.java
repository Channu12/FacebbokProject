package com.fb.login;

import org.testng.annotations.Test;

public class SignUpTest {

	@Test
	public void signUpByNo()
	{
		System.out.println("======Successfully Signed Out By No.======");
	}
	@Test
	public void signUpByName()
	{
		System.out.println("======Successfully Signed Out By Name======");
	}
	@Test(groups = "Smoke")
	public void signUpByEmail()
	{
		System.out.println("======Successfully Signed Out By Email======");
	}
}
