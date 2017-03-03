package Streame.Firefox;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.datatransfer.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test003_Login {

      private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\dmarroquin\\Documents\\QA\\Selenium_tools\\geckodriver.exe" );
	    driver = new FirefoxDriver();
	    baseUrl = "http://qa.streame.com";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  //Look and Feel
	  @Test
	  public void Login_Look_Feel() throws Exception{
	  driver.get(baseUrl + "/playground");
	    Thread.sleep(2000);
      //Security  password
      Alert alert=driver.switchTo().alert();
      driver.switchTo().alert().sendKeys("v*2$5X0e41US");
      alert.accept();
      Thread.sleep(2000);
      driver.findElement(By.cssSelector("option[value=\"en\"]")).click();
      Thread.sleep(1000);
      assertTrue(isElementPresent(By.id("navbar-comp__login-link")));
      assertEquals(driver.findElement(By.id("navbar-comp__login-link")).getText(), "SIGN IN");
      driver.findElement(By.id("navbar-comp__login-link")).click();
      Thread.sleep(1000);
      assertTrue(isElementPresent(By.cssSelector("div.modal-body")));
      assertEquals(driver.findElement(By.cssSelector("h2.modal-title")).getText(), "Welcome");
      assertTrue(isElementPresent(By.id("login_comp__close-button")));
      assertEquals(driver.findElement(By.id("login_comp__close-button")).getText(), "×");
      assertTrue(isElementPresent(By.id("login-comp__username")));
      assertEquals(driver.findElement(By.id("login-comp__username")).getText(), "");
      assertTrue(isElementPresent(By.id("login-comp__password")));
      assertEquals(driver.findElement(By.id("login-comp__password")).getText(), "");
      assertTrue(isElementPresent(By.cssSelector("label")));
      assertEquals(driver.findElement(By.cssSelector("label")).getText(), "Remember me");
      driver.findElement(By.id("login_comp__close-button")).click();
      assertTrue(isElementPresent(By.id("navbarSupportedContent")));
	  }
	  
	  @AfterClass(alwaysRun = true)
      public void tearDown() throws Exception {
	      driver.quit();
	      String verificationErrorString = verificationErrors.toString();
	      if (!"".equals(verificationErrorString)) {
	        fail(verificationErrorString);
	      }
	    }

	  private boolean isElementPresent(By by) {
	      try {
	        driver.findElement(by);
	        return true;
	      } catch (NoSuchElementException e) {
	        return false;
	      }
	    }

	  private boolean isAlertPresent() {
	      try {
	        driver.switchTo().alert();
	        return true;
	      } catch (NoAlertPresentException e) {
	        return false;
	      }
	    }

	  private String closeAlertAndGetItsText() {
		    try {
		        Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        if (acceptNextAlert) {
		          alert.accept();
		        } else {
		          alert.dismiss();
		        }
		        return alertText;
		      } finally {
		        acceptNextAlert = true;
		      }
	    }

}