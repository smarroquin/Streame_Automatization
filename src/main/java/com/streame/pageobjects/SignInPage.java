package com.streame.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	
	private WebDriver driver;
	
	private By headerPageText = By.cssSelector("h2.modal-title");
	private By loginLink = By.id("navbar-comp__login-link");
	public By emailTextBox = By.id("login-comp__username");
	public By passwordTextBox = By.id("login-comp__password");
	public By loginBtn = By.id("login-comp__submit");
	private By closeLink =By.id("login_comp__close-button");
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getSignInPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public boolean verifySignInPageTitle() {
		WebElement element = driver.findElement(headerPageText);
		String pageText = element.getText();
		String expectedPageTitle = "Welcome";
		return pageText.contains(expectedPageTitle);
	}
	
	public boolean verifyClosePage() {
		WebElement element = driver.findElement(closeLink);
		String closePage  = element.getText();
		String expectedClosePage = "×";
		return closePage.contains(expectedClosePage);
	}
			
		public void verifySignIn() {
			enterUserName("dmarroquin");
			enterPassword("Deni1402$");
			 System.out.println("Wrong credentials");
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
			WebElement signInBtn = driver.findElement(loginLink);
			if(signInBtn.isDisplayed())
				signInBtn.click();
		}
			
		public void selectCheckbox(WebElement Checkbox) {
			try {
	            if (Checkbox.isSelected()) {
	               System.out.println("Checkbox: " + Checkbox + "is already selected");
	            } else {
	            	// Select the checkbox
	            	Checkbox.click();
	            }
	        } catch (Exception e) {
	        	System.out.println("Unable to select the checkbox: " + Checkbox);
	        }
			
		}
		public void checkRemember(){
			
			WebElement Checkbox = driver.findElement(By.id("login-comp__remember-me"));
			new WebDriverWait(driver, 1000).until(ExpectedConditions.visibilityOf(Checkbox));
			selectCheckbox(Checkbox);
		}
		public void verifyValidSignIn() {
			enterUserName("denissita1402@hotmail.com");
			enterPassword("Passw0rd!");
			 System.out.println("Valid credentials");
			
		}
		
}