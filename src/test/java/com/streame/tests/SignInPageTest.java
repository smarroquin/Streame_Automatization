package com.streame.tests;

import org.openqa.selenium.By;
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
		
	@Test(priority=1)
	public void verifySignInEmpty() throws Exception {
		System.out.println("Sign In without information...");
		HomePage = new HomePage(driver);
		HomePage.SecurityPassword();
		Thread.sleep(1000);
		signInPage = HomePage.clickSignIn();
		Thread.sleep(2000);
		Assert.assertTrue(signInPage.verifySignInPageTitle(), "Welcome");
		Assert.assertTrue(signInPage.verifyClosePage(), "x");
		Assert.assertTrue(HomePage.isElementPresent(By.id("login-comp__username")));
		Assert.assertTrue(HomePage.isElementPresent(By.xpath("/html/body/ngb-modal-window/div/div/login/div/div[2]/form/div[1]/label")));
		Assert.assertTrue(HomePage.isElementPresent(By.id("login-comp__password")));
		Assert.assertTrue(HomePage.isElementPresent(By.xpath("/html/body/ngb-modal-window/div/div/login/div/div[2]/form/div[2]/label")));
		Assert.assertTrue(HomePage.isElementPresent(By.id("login-comp__remember-me")));
		signInPage.checkRemember();
		Thread.sleep(500);
		Assert.assertEquals(driver.findElement(By.id("login-comp__remember-me")).getAttribute("value"), "on");
		//Assert.assertEquals(driver.findElement(By.cssSelector("css=div.checkbox > label")).getText(), "Remember me");
		driver.findElement(By.id("login-comp__password")).click();
		driver.findElement(By.id("login-comp__username")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "Email address is required");
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='login-comp']/div[2]/form/div[2]/div")).getText(), "Password is required");
	    driver.findElement(By.id("login_comp__close-button")).click();
	    Thread.sleep(1000);
	}
		
	@Test(priority=2)
	public void verifySignInFailed() throws Exception {
		System.out.println("Sign In failed...");
		HomePage = new HomePage(driver);
		Thread.sleep(1000);
		signInPage = HomePage.clickSignIn();
		signInPage.verifySignIn();
		Assert.assertTrue(HomePage.isElementPresent(By.id("login-comp__submit")));
		driver.findElement(By.id("login-comp__submit")).click();
		driver.findElement(By.id("login_comp__close-button")).click();
		driver.findElement(By.id("navbar-comp__discover-link")).click();
	    Thread.sleep(5000);
	}
	
	@Test(priority=3)
	public void verifySignInSucessfully() throws Exception {
		System.out.println("Sign In sucessfully...");
		HomePage = new HomePage(driver);
		Thread.sleep(1000);
		signInPage = HomePage.clickSignIn();
		signInPage.verifyValidSignIn();
		driver.findElement(signInPage.loginBtn).click();
		Thread.sleep(2000);
		Assert.assertTrue(HomePage.isElementPresent(By.linkText("PLAYGROUND")));
	    Assert.assertEquals(driver.findElement(By.linkText("PLAYGROUND")).getText(), "PLAYGROUND");
	    Assert.assertTrue(HomePage.isElementPresent(By.id("navbar-comp__logout-link")));
	    Assert.assertEquals(driver.findElement(By.id("navbar-comp__logout-link")).getText(), "LOGOUT");
	    Assert.assertTrue(HomePage.isElementPresent(By.id("buildDropDown")));
	    Assert.assertEquals(driver.findElement(By.id("buildDropDown")).getText(), "BUILD");
	    Assert.assertTrue(HomePage.isElementPresent(By.cssSelector("div.profile-image-xs")));
	    Assert.assertEquals(driver.findElement(By.cssSelector("div.profile-image-xs")).getText(), "");
	}

}