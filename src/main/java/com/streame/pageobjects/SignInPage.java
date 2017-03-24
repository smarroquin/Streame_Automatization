package com.streame.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	
	private WebDriver driver;
	
	private By headerPageText = By.cssSelector(".hidden-small");
	private By createAccountLink = By.id("link-signup");
	private By emailTextBox = By.id("login-comp__username");
	private By passwordTextBox = By.id("login-comp__password");
	private By loginBtn = By.id("navbar-comp__login-link");
	private By errorMsgTxt = By.id("errormsg_0_Passwd");
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getSignInPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public boolean verifySignInPageTitle() {
		String expectedTitle = "Welcome";
		return getSignInPageTitle().contains(expectedTitle);
	}
	
	public boolean verifySignInPageText() {
		WebElement element = driver.findElement(headerPageText);
		String pageText = element.getText();
		String expectedPageText = "Welcome";
		return pageText.contains(expectedPageText);
	}
		public CreateAccountPage clickonCreateAnAccount() {
			WebElement element=driver.findElement(createAccountLink);
			if(element.isDisplayed()||element.isEnabled())
				element.click();
			return new CreateAccountPage(driver);
	}
		
		public boolean verifySignIn() {
			enterUserName("dmarroquin@belatrixsf.com");
			enterPassword("Deni1402$");
			clickOnSignIn();
			return getErrorMessage().contains("incorrect");
		}
		
		public void enterUserName(String userName) {
			WebElement emailTxtBox = driver.findElement(emailTextBox);
			if(emailTxtBox.isDisplayed())
				emailTxtBox.sendKeys(userName);
		}
		
		public void enterPassword(String password) {
			WebElement passwordTxtBox = driver.findElement(passwordTextBox);
			if(passwordTxtBox.isDisplayed())
				passwordTxtBox.sendKeys(password);
		}
		
		public void clickOnSignIn() {
			WebElement signInBtn = driver.findElement(loginBtn);
			if(signInBtn.isDisplayed())
				signInBtn.click();
		}
		
		public String getErrorMessage() {
			String strErrorMsg = null;
			WebElement errorMsg = driver.findElement(errorMsgTxt);
			if(errorMsg.isDisplayed()&&errorMsg.isEnabled())
				strErrorMsg = errorMsg.getText();
			return strErrorMsg;
		}
	
		
}
