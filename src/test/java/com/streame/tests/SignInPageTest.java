package com.streame.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.streame.base.Setup;
import com.streame.pageobjects.HomePage;
import com.streame.pageobjects.SignInPage;


public class SignInPageTest extends Setup{
	
	private WebDriver driver;
	private SignInPage signInPage;
	private HomePage HomePage;
	
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
		
	@Test
	public void verifySignInFunction() {
		System.out.println("Sign In functionality details...");
		HomePage = new HomePage(driver);
		signInPage = HomePage.clickSignIn();
		Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
		Assert.assertTrue(signInPage.verifySignInPageText(), "Page text not matching");
		Assert.assertTrue(signInPage.verifySignIn(), "Unable to sign in");

	}

}
