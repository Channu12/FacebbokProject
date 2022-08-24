package com.Facebook.ObjectRepositoty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUpPage {
	
	WebDriver driver;
	
	public LoginOrSignUpPage(WebDriver d)
	{
		driver = d;
		PageFactory.initElements(driver , this);
	}
	
	@FindBy(name = "email")
	private WebElement emailField;
	
	@FindBy(name = "pass")
	private WebElement passField;
	
	@FindBy(name = "login")
	private WebElement loginBtn;

	
	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPassField() {
		return passField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToApp(String email , String pwd)
	{
		emailField.sendKeys(email);
		passField.sendKeys(pwd);
		loginBtn.click();
	}
}
