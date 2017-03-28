package com.streame.pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CreateAccountPage {
	
	private WebDriver driver;
	private HomePage HomePage;
	public By headerPageTxt = By.cssSelector("h2");
	public By FirstNameTxt = By.id("register-comp__first-name");
	public By LastNameTxt = By.id("register-comp__last-name");
	public By emailTxt = By.id("register-comp__email");
	public By dateOfBirth = By.cssSelector("i.fa.fa-calendar");
	public By Gender =By.xpath("//div[@id='register-comp']/form/div[5]/div/div/div/label");
	public By displayNameTxt = By.id("register-comp__display-name");
	public By HandleTxt = By.id("register-comp__url");
	public By AddressTxt = By.id("register-comp__address");
	public By Avatar = By.cssSelector("span.make-drag-overlay.avatar-inherit");
	public By PasswordTxt = By.id("register-comp__password");
	public By confPasswordTxt = By.id("register-comp__confirm-password");
	public By RegisterBtn = By.id("");
	public  By closeBtn =By.cssSelector("button.close");
	
	public CreateAccountPage(WebDriver driver) {
		this.driver=driver;
	}
		
	public boolean verifyCreateAccountPageText() {
		WebElement element = driver.findElement(headerPageTxt);
		String pageText ="Create your account. Now for free.";
		return element.getText().contains(pageText);
	}
	
	public void enterFirstName(String FirstName) {
		WebElement firstNameTxtBox = driver.findElement(FirstNameTxt);
		if(firstNameTxtBox.isDisplayed())
			firstNameTxtBox.clear();
			firstNameTxtBox.sendKeys(FirstName);
	}
	
	public void enterLastName(String LastName) {
		WebElement lastNameTxtBox = driver.findElement(LastNameTxt);
		if(lastNameTxtBox.isDisplayed())
			lastNameTxtBox.sendKeys(LastName);
	}

	public void enterEmail(String email) {
		WebElement emailTxtBox = driver.findElement(emailTxt);
		if(emailTxtBox.isDisplayed())
			emailTxtBox.sendKeys(email);
	}
	
	public void enterDateOfBirth(String dateBirth) {
		WebElement dateBirthBox = driver.findElement(dateOfBirth);
		if(dateBirthBox.isDisplayed())
			dateBirthBox.sendKeys(dateBirth);
	}
	
	public void enterGender (String gender) {
		WebElement genderBox = driver.findElement(Gender);
		if(genderBox.isDisplayed())
			genderBox.sendKeys(gender);
	}
	
	public void enterDisplayName(String DisplayName) {
		WebElement displayNameTxtBox = driver.findElement(displayNameTxt);
		if(displayNameTxtBox.isDisplayed())
			displayNameTxtBox.sendKeys(DisplayName);
	}
	
	public void enterHandle(String Handle) {
		WebElement HandleTxtBox = driver.findElement(HandleTxt);
		if(HandleTxtBox.isDisplayed())
			HandleTxtBox.sendKeys(Handle);
	}
	
	public void enterAddress(String address) {
		WebElement addressTxtBox = driver.findElement(AddressTxt);
		if(addressTxtBox.isDisplayed())
			addressTxtBox.sendKeys(address);
	}
	
	public void enterFailedAvatar () throws Exception {
		uploadImage("C:\\Users\\dmarroquin\\Documents\\Resumen.odt");
		Thread.sleep(500);
	}
	
	public void enterPassword(String password) {
		WebElement passwordTxtBox = driver.findElement(PasswordTxt);
		if(passwordTxtBox.isDisplayed())
			passwordTxtBox.sendKeys(password);
	}
	
	public void enterConfPassword(String confPassword) {
		WebElement confPasswrodTxtBox = driver.findElement(confPasswordTxt);
		if(confPasswrodTxtBox.isDisplayed())
			confPasswrodTxtBox.sendKeys(confPassword);
	}
		
	public void Page_Down(){

	    JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("window.scrollBy(0,350)", "");

	}
	
	public void Page_up(){

	    JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("window.scrollBy(0,-250)", "");

	}

	public boolean verifyClosePage() {
		WebElement element = driver.findElement(closeBtn);
		String closePage  = element.getText();
		String expectedClosePage = "×";
		return closePage.contains(expectedClosePage);
	}
	
	public static void setClipBoardData(String string){
          StringSelection stringselect = new StringSelection(string);
          Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselect, null);
      }
	
	public static void uploadImage(String imagelocation){
        try{
            setClipBoardData(imagelocation);
            Thread.sleep(500);
            Robot robot =  new Robot();
            robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
            robot.keyPress(java.awt.event.KeyEvent.VK_V);
            robot.keyRelease(java.awt.event.KeyEvent.VK_V);
            robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
            robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
            robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
            robot.delay(1000);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
	}
	
}
