package com.streame.tests;

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
        Assert.assertTrue(HomePage.isElementPresent(By.id("buildMenu")));
        BuildMenu = new BuildMenu(driver);
        BuildMenu.clickBuild();
		Thread.sleep(1000);
		Assert.assertTrue(HomePage.isElementPresent(By.cssSelector("li > div > div")));
		Assert.assertTrue(HomePage.isElementPresent(By.linkText("Stage")));
	    Assert.assertEquals(driver.findElement(By.linkText("Stage")).getText(), "Stage");
	    Assert.assertTrue(HomePage.isElementPresent(By.cssSelector("label.nav-link.menu__label")));
	    Assert.assertEquals(driver.findElement(By.cssSelector("label.nav-link.menu__label")).getText(), "Media");
	    Assert.assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div/dynamic-tree-menu/ul/li[3]/div/div/label")));
	    Assert.assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div/dynamic-tree-menu/ul/li[3]/div/div/label")));
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div/dynamic-tree-menu/ul/li[3]/div/div/label")).getText(), "Pages");
	    Assert.assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div/dynamic-tree-menu/ul/li[4]/div/div/label")));
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div/dynamic-tree-menu/ul/li[4]/div/div/label")).getText(), "Channels");
	    Assert.assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div/dynamic-tree-menu/ul/li[5]/div/div/label")));
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div/dynamic-tree-menu/ul/li[5]/div/div/label")).getText(), "Showcases");
	}
	
	@Test(priority=2)
	public void MediaBuild() throws Exception {
		Assert.assertTrue(HomePage.isElementPresent(By.cssSelector("label.nav-link.menu__label")));
	    driver.findElement(By.id("media")).click();
	    Thread.sleep(1000);
	    Assert.assertEquals(driver.findElement(By.cssSelector("label.nav-link.menu__label")).getText(), "Media");
	    Thread.sleep(1000);
	    Assert.assertTrue(HomePage.isElementPresent(By.cssSelector("li > div > a.nav-link")));
	    Thread.sleep(1000);
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div/dynamic-tree-menu/ul/li[2]/div/dynamic-tree-menu/ul/li/div/a")).getText(), "Upload media");
	    Assert.assertTrue(HomePage.isElementPresent(By.xpath("//input[@type='text']")));
	    Assert.assertTrue(HomePage.isElementPresent(By.cssSelector("nav-item.text-center > a.nav-link")));
	    Assert.assertTrue(HomePage.isElementPresent(By.cssSelector("build-finder > dynamic-tree-menu > ul.tree > li > div > div.menu > label.nav-link.menu__label")));
	    Assert.assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div/dynamic-tree-menu/ul/li[2]/div/dynamic-tree-menu/ul/li[3]/div/div/dynamic-component/find-container/build-finder/dynamic-tree-menu/ul/li[2]/div/div/label")));
	    Assert.assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div/dynamic-tree-menu/ul/li[2]/div/dynamic-tree-menu/ul/li[3]/div/div/dynamic-component/find-container/build-finder/dynamic-tree-menu/ul/li[3]/div/div/label")));
	    Assert.assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div/dynamic-tree-menu/ul/li[2]/div/dynamic-tree-menu/ul/li[3]/div/div/dynamic-component/find-container/build-finder/dynamic-tree-menu/ul/li[4]/div/div/label")));
	}
	@Test(priority=3)
	public void PageBuild() throws Exception {
	
	}
}
	
