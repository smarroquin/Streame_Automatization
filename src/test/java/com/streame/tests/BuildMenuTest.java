package com.streame.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.streame.pageobjects.SignInPage;
import com.streame.base.Setup;
import com.streame.pageobjects.HomePage;
import com.streame.pageobjects.BuildMenu;

public class BuildMenuTest  extends Setup {

	
	private WebDriver driver;
	public BuildMenu BuildMenu;
	private HomePage HomePage;
	public SignInPage signInPage;

	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}

	@Test(priority=1)
	public void verifyBuild() throws Exception {
		
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
		Thread.sleep(1000);
		Assert.assertTrue(HomePage.isElementPresent(By.linkText("Stage")));
	    Assert.assertEquals(driver.findElement(By.linkText("Stage")).getText(), "Stage");
	    Assert.assertTrue(HomePage.isElementPresent(By.xpath("//h4[2]/span")));
	    Assert.assertEquals(driver.findElement(By.xpath("//h4[2]/span")).getText(), "Media");
	    Assert.assertTrue(HomePage.isElementPresent(By.xpath("//h4[3]/span")));
	    Assert.assertEquals(driver.findElement(By.xpath("//h4[3]/span")).getText(), "Pages");
	    Assert.assertTrue(HomePage.isElementPresent(By.xpath("//h4[4]/span")));
	    Assert.assertEquals(driver.findElement(By.xpath("//h4[4]/span")).getText(), "Channels");
	    Assert.assertTrue(HomePage.isElementPresent(By.xpath("//h4[5]/span")));
	    Assert.assertEquals(driver.findElement(By.xpath("//h4[5]/span")).getText(), "Showcases");
	}
	
	@Test(priority=2)
	public void MediaBuild() throws Exception {
		Assert.assertTrue(HomePage.isElementPresent(By.xpath("//h4[2]/span")));
	    driver.findElement(By.xpath("//h4[2]/span")).click();
	    Thread.sleep(1000);
	    assertEquals(driver.findElement(By.xpath("//h4[2]/span")).getText(), "Media");
	    Thread.sleep(1000);
	    assertTrue(HomePage.isElementPresent(By.xpath("//accordion-arrow/span")));
	    Thread.sleep(1000);
	    assertTrue(HomePage.isElementPresent(By.xpath("//media-menu/h4")));
	    assertEquals(driver.findElement(By.xpath("//media-menu/h4")).getText(), "Upload Media");
	    assertTrue(HomePage.isElementPresent(By.xpath("//a/span")));
	    assertEquals(driver.findElement(By.xpath("//a/span")).getText(), "View All");
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[3]/h4")));
	    assertEquals(driver.findElement(By.xpath("//div[3]/h4")).getText(), "Image");
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[4]/h4")));
	    assertEquals(driver.findElement(By.xpath("//div[4]/h4")).getText(), "Audio");
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[5]/h4")));
	    assertEquals(driver.findElement(By.xpath("//div[5]/h4")).getText(), "Video");
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[6]/h4")));
	    assertEquals(driver.findElement(By.xpath("//div[6]/h4")).getText(), "Document");
	    driver.findElement(By.xpath("//h4[2]/span")).click();
	    Thread.sleep(500);
	}
	@Test(priority=3)
	public void PageBuild() throws Exception {
		assertTrue(HomePage.isElementPresent(By.xpath("//h4[3]/span")));
		assertEquals(driver.findElement(By.xpath("//h4[3]/span")).getText(), "Pages");
	    driver.findElement(By.xpath("//h4[3]/span")).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(By.xpath("//page-menu/h4")));
	    assertEquals(driver.findElement(By.xpath("//page-menu/h4")).getText(), "Create Page");
	    assertTrue(HomePage.isElementPresent(By.xpath("//a/span")));
	    assertEquals(driver.findElement(By.xpath("//a/span")).getText(), "View All");
	    driver.findElement(By.xpath("//h4[3]/span")).click();
	  
	}
	
	@Test(priority=4)
	public void ChannelBuild() throws Exception {
		assertTrue(HomePage.isElementPresent(By.xpath("//h4[4]/span")));
		    driver.findElement(By.xpath("//h4[4]/span")).click();
		    assertTrue(HomePage.isElementPresent(By.xpath("//channel-menu/h4")));
		    assertEquals(driver.findElement(By.xpath("//channel-menu/h4")).getText(), "Create Channel");
		    assertTrue(HomePage.isElementPresent(By.xpath("//a/span")));
		    assertEquals(driver.findElement(By.xpath("//a/span")).getText(), "View All");
		    assertTrue(HomePage.isElementPresent(By.xpath("//input")));
		    driver.findElement(By.xpath("//h4[4]/span")).click();

	}
	@Test(priority=5)
	public void ShowcasesBuild() throws Exception {
		assertTrue(HomePage.isElementPresent(By.xpath("//h4[5]/span")));
	    assertEquals(driver.findElement(By.xpath("//h4[5]/span")).getText(), "Showcases");
	    driver.findElement(By.xpath("//h4[5]/span")).click();
	    driver.findElement(By.xpath("//h4[5]/span")).click();
	}
}
	
