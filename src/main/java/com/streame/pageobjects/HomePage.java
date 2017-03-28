package com.streame.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
	
	protected WebDriver driver;
	private By signInLink = By.linkText("SIGN IN");
	private By createAccountLink = By.linkText("CREATE ACCOUNT");

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public SignInPage clickSignIn() {
		System.out.println("sign in...");
		WebElement signInLinkElement=driver.findElement(signInLink);
		if(signInLinkElement.isDisplayed()||signInLinkElement.isEnabled())
			signInLinkElement.click();
		else System.out.println("Element not found");
		return new SignInPage(driver);
	}
		
	public CreateAccountPage clickonCreateAnAccount() {
		WebElement element=driver.findElement(createAccountLink);
		if(element.isDisplayed()||element.isEnabled())
			element.click();
		else System.out.println("Element not found");
		return new CreateAccountPage(driver);
}
	public void SecurityPassword() {
		//Security  password
		  Alert alert=driver.switchTo().alert();
		  driver.switchTo().alert().sendKeys("v*2$5X0e41US");
		  alert.accept();
			}
	
	public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
			
	public boolean verifyHomePageTitle() {
		String expectedPageTitle="Streame";
		return getPageTitle().contains(expectedPageTitle);
	}
		
	public void verifyNavOnEN() {
		Select Language = new Select(driver.findElement(By.id("navbar-comp__langMenu")));
		Language.selectByIndex(0);
		driver.findElement(By.cssSelector("option[value=\"en\"]")).click();	
	}
	public void verifyNavOnES() throws Exception {
		Select Language = new Select(driver.findElement(By.id("navbar-comp__langMenu")));
		Language.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("option[value=\"es\"]")).click();
	}
	public boolean isElementPresent(By by) {
	    try {
	    	driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	

}
