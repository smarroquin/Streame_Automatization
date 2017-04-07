package com.streame.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.streame.base.Setup;
import com.streame.pageobjects.HomePage;
import com.streame.pageobjects.CreateAccountPage;


public class CreateAccountPageTest extends Setup{
	
	private WebDriver driver;
	private HomePage HomePage;
	private CreateAccountPage createAccountPage;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test(priority=1)
	public void verifyCreateAnAccounPage() throws Exception {
		
			System.out.println("Create Account without information...");
			HomePage = new HomePage(driver);
			HomePage.SecurityPassword();
			createAccountPage = HomePage.clickonCreateAnAccount();
			Thread.sleep(1000);
			createAccountPage.verifyCreateAccountPageText();
			Assert.assertTrue(HomePage.isElementPresent(createAccountPage.FirstNameTxt));
			Assert.assertTrue(HomePage.isElementPresent(createAccountPage.LastNameTxt));
			Assert.assertTrue(HomePage.isElementPresent(createAccountPage.emailTxt));
			Assert.assertTrue(HomePage.isElementPresent(createAccountPage.dateOfBirth));
			Assert.assertTrue(HomePage.isElementPresent(createAccountPage.Gender));
			Assert.assertTrue(HomePage.isElementPresent(createAccountPage.displayNameTxt));
			Assert.assertTrue(HomePage.isElementPresent(createAccountPage.HandleTxt));
			createAccountPage.Page_Down();
			Assert.assertTrue(HomePage.isElementPresent(createAccountPage.AddressTxt));
			Assert.assertTrue(HomePage.isElementPresent(createAccountPage.Avatar));
			Assert.assertTrue(HomePage.isElementPresent(createAccountPage.PasswordTxt));
			Assert.assertTrue(HomePage.isElementPresent(createAccountPage.confPasswordTxt));
			/*createAccountPage.Page_up();
			createAccountPage.verifyClosePage();
			driver.findElement(createAccountPage.closeBtn).click();*/
	}
	
	@Test(priority=2)
	public void verifyValidationsPage() throws Exception {
		driver.findElement(createAccountPage.FirstNameTxt).click();
		driver.findElement(createAccountPage.LastNameTxt).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(),  "First Name is required");
		driver.findElement(createAccountPage.emailTxt).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[2]/div/div")).getText(), "Last Name is required");
		driver.findElement(createAccountPage.displayNameTxt).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[3]/div/div")).getText(), "Email is required");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[3]/div/div[2]")).getText(), "Please enter a valid email address");
		driver.findElement(createAccountPage.HandleTxt).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[4]/div/div")).getText(), "Date of Birth is required");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[5]/div/div[2]")).getText(), "Gender is required");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[6]/div/div")).getText(), "Display Name must contain between 3 and 35 characters");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[7]/div/div")).getText(), "Handle is required");
		driver.findElement(createAccountPage.AddressTxt).click();
		driver.findElement(createAccountPage.PasswordTxt).click();
		createAccountPage.Page_Down();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.location-input > div.alert.alert-danger")).getText(), "Address is required");
		createAccountPage.verifyClosePage();
		driver.findElement(createAccountPage.closeBtn).click();	
		Thread.sleep(500);
	}
	
	@Test(priority=3)
	public void verifyFirstName() throws Exception {
		createAccountPage = HomePage.clickonCreateAnAccount();
		driver.findElement(createAccountPage.FirstNameTxt).clear();
		createAccountPage.enterFirstName("#$%&%$#");
		driver.findElement(createAccountPage.LastNameTxt).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "First Name must not contain numbers or special characters");
		driver.findElement(createAccountPage.FirstNameTxt).clear();
		createAccountPage.enterFirstName("11111111");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "First Name must not contain numbers or special characters");
		driver.findElement(createAccountPage.FirstNameTxt).clear();
		createAccountPage.enterFirstName("Denisse21");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "First Name must not contain numbers or special characters");
		driver.findElement(createAccountPage.FirstNameTxt).clear();
		createAccountPage.enterFirstName("Denisse#$%");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "First Name must not contain numbers or special characters");
		driver.findElement(createAccountPage.FirstNameTxt).clear();
		createAccountPage.enterFirstName("Denisse");
	}
	
	@Test(priority=4)
    public void verifyLastName() throws Exception {
	
	createAccountPage.enterLastName("#$%&%$#");
	Thread.sleep(500);
	driver.findElement(createAccountPage.emailTxt).click();
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[2]/div/div")).getText(), "Last Name must not contain numbers or special characters");
	Thread.sleep(500);
	driver.findElement(createAccountPage.LastNameTxt).clear();
	createAccountPage.enterLastName("11111111");
	Thread.sleep(500);
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[2]/div/div")).getText(), "Last Name must not contain numbers or special characters");
	driver.findElement(createAccountPage.LastNameTxt).clear();
	createAccountPage.enterLastName("Marroquin1224");
	Thread.sleep(500);
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[2]/div/div")).getText(), "Last Name must not contain numbers or special characters");
	driver.findElement(createAccountPage.LastNameTxt).clear();
	createAccountPage.enterLastName("Marroquin#&$");
	Thread.sleep(500);
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[2]/div/div")).getText(), "Last Name must not contain numbers or special characters");
	}
	
	@Test(priority=5)
    public void verifyEmail() throws Exception {
	createAccountPage.Page_Down();
	createAccountPage.enterEmail("#$%&%$#");
	Thread.sleep(500);
	driver.findElement(createAccountPage.displayNameTxt).click();
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[3]/div/div")).getText(), "Please enter a valid email address");
	Thread.sleep(500);
	driver.findElement(createAccountPage.emailTxt).clear();
	createAccountPage.enterEmail("11111111");
	Thread.sleep(500);
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[3]/div/div")).getText(), "Please enter a valid email address");
	driver.findElement(createAccountPage.emailTxt).clear();
	createAccountPage.enterEmail("denissita1402");
	Thread.sleep(500);
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[3]/div/div")).getText(), "Please enter a valid email address");
	driver.findElement(createAccountPage.emailTxt).clear();
	createAccountPage.enterEmail("denissita1402@");
	Thread.sleep(500);
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[3]/div/div")).getText(), "Please enter a valid email address");
	/*driver.findElement(createAccountPage.emailTxt).clear();
	createAccountPage.enterEmail("denissita1402@hotmail");
	Thread.sleep(1000);
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[3]/div/div")).getText(), "Please enter a valid email address");
	*/driver.findElement(createAccountPage.emailTxt).clear();
	createAccountPage.enterEmail("denissita1402.hotmail.com");
	Thread.sleep(500);
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[3]/div/div")).getText(), "Please enter a valid email address");
	Thread.sleep(500);
	}
	
	@Test(priority=6)
    public void verifyFailedAvatar() throws Exception {
	createAccountPage.Page_Down();
	driver.findElement(createAccountPage.Avatar).click();
	createAccountPage.enterFailedAvatar();
	Thread.sleep(500);
    Assert.assertEquals(driver.findElement(By.cssSelector("edit-avatar.edit-avatar > div.alert.alert-danger")).getText(), "Select a valid image type");
    Thread.sleep(500);
	}
	
	@Test(priority=7)
    public void verifyPassword() throws Exception {
	createAccountPage.Page_Down();	
	driver.findElement(createAccountPage.PasswordTxt).click();
	driver.findElement(createAccountPage.PasswordTxt).clear();
	createAccountPage.enterPassword("den1402$");	
    Assert.assertEquals(driver.findElement(By.cssSelector("div.password-input > div.alert.alert-danger")).getText(), "Confirm Password does not match Password.");
    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[10]/div/div")).getText(), "Password must contain at least one uppercase and lowercase letter.");
	driver.findElement(createAccountPage.PasswordTxt).clear();
	createAccountPage.enterPassword("Deni");
    Assert.assertEquals(driver.findElement(By.cssSelector("div.password-input > div.alert.alert-danger")).getText(), "Confirm Password does not match Password.");
    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[10]/div/div")).getText(), "Password must contain at least one special character.");
    driver.findElement(createAccountPage.PasswordTxt).sendKeys(Keys.BACK_SPACE);
    driver.findElement(createAccountPage.PasswordTxt).sendKeys(Keys.BACK_SPACE);
    driver.findElement(createAccountPage.PasswordTxt).sendKeys(Keys.BACK_SPACE);
    driver.findElement(createAccountPage.PasswordTxt).sendKeys(Keys.BACK_SPACE);
    Assert.assertEquals(driver.findElement(By.cssSelector("div.password-input > div.alert.alert-danger")).getText(), "Password is required");
    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[10]/div/div")).getText(), "Password must begin with a letter or number.");
    driver.findElement(createAccountPage.PasswordTxt).clear();
	createAccountPage.enterPassword("Deni$$");
    Assert.assertEquals(driver.findElement(By.cssSelector("div.password-input > div.alert.alert-danger")).getText(), "Confirm Password does not match Password.");
    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[10]/div/div")).getText(), "Password must have at least 8 characters");
    driver.findElement(createAccountPage.PasswordTxt).clear();
	createAccountPage.enterPassword("Denissi$");
    Assert.assertEquals(driver.findElement(By.cssSelector("div.password-input > div.alert.alert-danger")).getText(), "Confirm Password does not match Password.");
    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[10]/div/div")).getText(), "Password must contain at least one numerical character");
    driver.findElement(createAccountPage.PasswordTxt).clear();
	createAccountPage.enterPassword("&Deni");
    Assert.assertEquals(driver.findElement(By.cssSelector("div.password-input > div.alert.alert-danger")).getText(), "Confirm Password does not match Password.");
    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[10]/div/div")).getText(), "Password must begin with a letter or number.");
    driver.findElement(createAccountPage.PasswordTxt).clear();
	createAccountPage.enterPassword("Denisse");
	Thread.sleep(1000);
    Assert.assertEquals(driver.findElement(By.cssSelector("div.password-input > div.alert.alert-danger")).getText(), "Confirm Password does not match Password.");
    Assert.assertEquals(driver.findElement(By.xpath("//div[@id='register-comp']/form/div[10]/div/div")).getText(), "Password cannot equal first, last or display names");
    Thread.sleep(500);
    createAccountPage.verifyClosePage();
	driver.findElement(createAccountPage.closeBtn).click();	
	Thread.sleep(500);
	}
	
    @Test(priority=8)
    public void verifySuccessAccount() throws Exception {
    	createAccountPage = HomePage.clickonCreateAnAccount();
    	Thread.sleep(500);
    	driver.findElement(createAccountPage.FirstNameTxt).clear();
		createAccountPage.enterFirstName("Denisse");
		driver.findElement(createAccountPage.LastNameTxt).clear();
		createAccountPage.enterLastName("Marroquin");
		driver.findElement(createAccountPage.emailTxt).clear();
		createAccountPage.enterEmail("dmarroquin@gmail.com");
		createAccountPage.enterDateOfBirth();
		driver.findElement(By.xpath("//div[@id='register-comp']/form/div[5]/div/div/div/label")).click();
		driver.findElement(createAccountPage.displayNameTxt).clear();
		createAccountPage.enterDisplayName("Dmarroquin");
		driver.findElement(createAccountPage.HandleTxt).clear();
		createAccountPage.enterHandle("Dmarroquin");
		driver.findElement(createAccountPage.AddressTxt).clear();
		createAccountPage.enterAddress("Calle Los Olivos 215, San Isidro 15073, Perú");
		driver.findElement(createAccountPage.PasswordTxt).clear();
		createAccountPage.enterPassword("Deni1402$");
		driver.findElement(createAccountPage.confPasswordTxt).clear();
		createAccountPage.enterConfPassword("Deni1402$");
		
    }
}