package com.streame.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
        Assert.assertTrue(HomePage.isElementPresent(By.cssSelector("button.nav-link.build-menu-button")));
        BuildMenu = new BuildMenu(driver);
        BuildMenu.clickBuild();
        ChannelPage = new ChannelPage(driver);
        assertTrue(HomePage.isElementPresent(By.xpath("//h4[4]/span")));
        assertEquals(driver.findElement(By.xpath("//h4[4]/span")).getText(), "Channels");
        driver.findElement(By.xpath("//h4[4]/span")).click();
        Thread.sleep(1000);
        assertTrue(HomePage.isElementPresent(ChannelPage.createLink));
        assertEquals(driver.findElement(ChannelPage.createLink).getText(), "Create Channel");
        driver.findElement(ChannelPage.createLink).click();
        Thread.sleep(1000);
        assertEquals(driver.findElement(By.cssSelector("span.menu-button__title")).getText(), "Create Channel");
        try{
        assertEquals(driver.findElement(By.cssSelector("label.create-channel__label")).getText(), "URL:\n Streame.com/Denissita/");
        }catch(Error e){};
        assertTrue(HomePage.isElementPresent(By.id("title")));
        assertEquals(driver.findElement(By.xpath("(//button[@type='button'])[2]")).getText(), "Cancel");
        driver.findElement(ChannelPage.slug).clear();
	    driver.findElement(ChannelPage.slug).sendKeys("Slug" + ChannelPage.RandomNumber(3));
        assertEquals(driver.findElement(By.xpath("//button[@type='submit']")).getText(), "OK");
      Thread.sleep(1000);
	}
	
	
	@Test(priority=2)
	public void SlugValidations() throws Exception {
		driver.findElement(ChannelPage.slug).clear();
		driver.findElement(ChannelPage.slug).sendKeys("Slug" + " " + ChannelPage.RandomNumber(3));
		driver.findElement(By.xpath("//form/div[2]")).click();
		Thread.sleep(3000);
		assertTrue(HomePage.isElementPresent(By.xpath("//form/div[3]")));
	    assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "The Channel's URL May Not Contain Spaces Or Special Characters");
	    driver.findElement(ChannelPage.slug).clear();
		driver.findElement(ChannelPage.slug).sendKeys("Slug&/");
		assertTrue(HomePage.isElementPresent(By.cssSelector("div.alert.alert-danger")));
	    assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "The Channel's URL May Not Contain Spaces Or Special Characters");
	    driver.findElement(By.id("title")).clear();
	    driver.findElement(By.id("title")).sendKeys("Denisse");
	    Thread.sleep(1000);
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.alert.alert-danger")));
	    assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "URL Already Exists");
		
	}
	@Test(priority=3)
	public void EditChannel() throws Exception {
		
	}
	
	@Test(priority=4)
	public void ViewChannel() throws Exception {
		
	}
}
