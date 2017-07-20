package com.streame.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.streame.base.Setup;
import com.streame.pageobjects.*;


public class ChannelPageTest extends Setup{
	private WebDriver driver;
	public HomePage HomePage;
	public ChannelPage ChannelPage;
	public SignInPage signInPage;
	public BuildMenu BuildMenu;

	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	
	@Test(priority=1)
	public void CreateChannel() throws Exception {
		HomePage = new HomePage(driver);
		HomePage.SecurityPassword();
		Thread.sleep(1000);
		signInPage = HomePage.clickSignIn();
		Thread.sleep(2000);
		signInPage.verifyValidSignIn();
		driver.findElement(signInPage.loginBtn).click();
		Thread.sleep(2000);
        Assert.assertTrue(HomePage.isElementPresent(By.id("buildMenu")));
        BuildMenu = new BuildMenu(driver);
        BuildMenu.clickBuild();
        ChannelPage = new ChannelPage(driver);

	}
	
	
	@Test(priority=2)
	public void ChannelValidations() throws Exception {
		
	}
	@Test(priority=3)
	public void EditChannel() throws Exception {
		
	}
	
	@Test(priority=4)
	public void ViewChannel() throws Exception {
		
	}
}
