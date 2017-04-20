package com.streame.tests;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.streame.base.Setup;
import com.streame.pageobjects.HomePage;

public class HomePageTest extends Setup {
	
private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test(priority=1)
	public void verifyLoadHomePage() throws Exception {
		System.out.println("Streame Home page test...");
		HomePage HomePage = new HomePage(driver);
		 Thread.sleep(2000);
		HomePage.SecurityPassword();
		 Thread.sleep(2000);
		 Assert.assertTrue(HomePage.verifyHomePageTitle(), "Streame");
		 assertEquals(driver.findElement(By.cssSelector("img[alt=\"Streame logo\"]")).getText(), "");
         assertEquals(driver.findElement(By.cssSelector("img.home-page-banner__image")).getText(), "");
		 assertEquals(driver.findElement(By.cssSelector("h1.col-sm-12.home-page-favorites-title")).getText(), "My Latest Favorites");
		}
	@Test(priority=2)
	public void verifyNavEN () throws Exception {
		System.out.println("Nav Bar on EN test...");
		HomePage HomePage = new HomePage(driver);
		 Thread.sleep(2000);
		 HomePage.verifyNavOnEN();
		 assertEquals(driver.findElement(By.id("navbar-comp__login-link")).getText(),"SIGN IN");
		 assertEquals(driver.findElement(By.id("navbar-comp__register-link")).getText(), "CREATE ACCOUNT");
			}
	
	@Test(priority=3)
	public void verifyNavES () throws Exception {
		System.out.println("Nav Bar on ES test...");
		HomePage HomePage = new HomePage(driver);
		 Thread.sleep(2000);
		 HomePage.verifyNavOnES();
		 Thread.sleep(1000);
		assertEquals(driver.findElement(By.id("navbar-comp__login-link")).getText(),"INGRESAR");
		 assertEquals(driver.findElement(By.id("navbar-comp__register-link")).getText(), "CREAR CUENTA");
		 driver.close();
		}
	
}