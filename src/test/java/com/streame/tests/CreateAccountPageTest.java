package com.streame.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.streame.base.Setup;

import com.streame.pageobjects.HomePage;
import com.streame.pageobjects.CreateAccountPage;
import com.streame.pageobjects.SignInPage;


public class CreateAccountPageTest extends Setup{
	
	private WebDriver driver;
	private SignInPage signInPage;
	private HomePage HomePage;
	private CreateAccountPage createAccountPage;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test
	public void verifyCreateAnAccounPage() {
		System.out.println("Create An Account page test...");
		HomePage = new HomePage(driver);
		signInPage = HomePage.clickSignIn();
		createAccountPage = signInPage.clickonCreateAnAccount();
		Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
		Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");
	}
	
	public void verifySignInFunction() {
		
	}
		
	

}
