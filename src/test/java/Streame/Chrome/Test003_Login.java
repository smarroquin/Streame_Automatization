package Streame.Chrome;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.datatransfer.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class Test003_Login {

      private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dmarroquin\\Documents\\QA\\Selenium_tools\\chromedriver.exe");
	    driver = new ChromeDriver();
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
	  //Login Successfully
	  @Test
	  public void Login_Successfully() throws Exception{
	  driver.get(baseUrl + "/playground");
	    Thread.sleep(2000);
      //Security  password
      Alert alert=driver.switchTo().alert();
      driver.switchTo().alert().sendKeys("v*2$5X0e41US");
      alert.accept();
      Thread.sleep(2000);
      driver.findElement(By.cssSelector("option[value=\"en\"]")).click();
      Thread.sleep(1000);
      driver.findElement(By.id("navbar-comp__login-link")).click();
      assertTrue(isElementPresent(By.id("login-comp__username")));
      assertEquals(driver.findElement(By.id("login-comp__username")).getText(), "");
      driver.findElement(By.id("login-comp__username")).clear();
      driver.findElement(By.id("login-comp__username")).sendKeys("dmarroquin@belatrixsf.com");
      assertTrue(isElementPresent(By.id("login-comp__password")));
      assertEquals(driver.findElement(By.id("login-comp__password")).getText(), "");
      driver.findElement(By.id("login-comp__password")).clear();
      driver.findElement(By.id("login-comp__password")).sendKeys("Deni1402$");
      assertTrue(isElementPresent(By.id("login-comp__submit")));
      assertEquals(driver.findElement(By.id("login-comp__submit")).getText(), "SIGN IN");
      driver.findElement(By.id("login-comp__submit")).click();
      Thread.sleep(5000);
      assertTrue(isElementPresent(By.linkText("PLAYGROUND")));
      assertEquals(driver.findElement(By.linkText("PLAYGROUND")).getText(), "PLAYGROUND");
      assertTrue(isElementPresent(By.id("navbar-comp__logout-link")));
      assertEquals(driver.findElement(By.id("navbar-comp__logout-link")).getText(), "LOGOUT");
      assertTrue(isElementPresent(By.id("buildDropDown")));
      assertEquals(driver.findElement(By.id("buildDropDown")).getText(), "BUILD");
      assertTrue(isElementPresent(By.xpath("//div[@id='navbarSupportedContent']/div/ul/li[4]/div")));
      assertTrue(isElementPresent(By.cssSelector("div.profile-image-xs")));
      driver.findElement(By.linkText("PLAYGROUND")).click();
      Thread.sleep(2000);
      assertTrue(isElementPresent(By.linkText("HOME")));
      assertEquals(driver.findElement(By.linkText("HOME")).getText(), "HOME");
      assertTrue(isElementPresent(By.linkText("Stage")));
      assertEquals(driver.findElement(By.linkText("Stage")).getText(), "Stage");
      assertTrue(isElementPresent(By.linkText("Components Map")));
      assertEquals(driver.findElement(By.linkText("Components Map")).getText(), "Components Map");
      assertTrue(isElementPresent(By.linkText("Drag and drop")));
      assertEquals(driver.findElement(By.linkText("Drag and drop")).getText(), "Drag and drop");
      assertTrue(isElementPresent(By.linkText("Ng2-File-Upload")));
      assertEquals(driver.findElement(By.linkText("Ng2-File-Upload")).getText(), "Ng2-File-Upload");
      assertTrue(isElementPresent(By.linkText("Angular-progress-http upload")));
      assertEquals(driver.findElement(By.linkText("Angular-progress-http upload")).getText(), "Angular-progress-http upload");
      assertTrue(isElementPresent(By.linkText("Crop")));
      assertEquals(driver.findElement(By.linkText("Crop")).getText(), "Crop");
      assertTrue(isElementPresent(By.linkText("UPLOAD")));
      assertEquals(driver.findElement(By.linkText("UPLOAD")).getText(), "UPLOAD");
      assertTrue(isElementPresent(By.linkText("SIDEBAR")));
      assertEquals(driver.findElement(By.linkText("SIDEBAR")).getText(), "SIDEBAR");
      assertTrue(isElementPresent(By.linkText("Comments")));
      assertEquals(driver.findElement(By.linkText("Comments")).getText(), "Comments");
      driver.findElement(By.linkText("PLAYGROUND")).click();
      driver.findElement(By.id("buildDropDown")).click();
      Thread.sleep(2000);
      assertTrue(isElementPresent(By.linkText("STAGE")));
      assertEquals(driver.findElement(By.linkText("STAGE")).getText(), "STAGE");
      assertTrue(isElementPresent(By.linkText("UPLOAD MEDIA")));
      assertEquals(driver.findElement(By.linkText("UPLOAD MEDIA")).getText(), "UPLOAD MEDIA");
      assertTrue(isElementPresent(By.linkText("CREATE PAGE")));
      assertEquals(driver.findElement(By.linkText("CREATE PAGE")).getText(), "CREATE PAGE");
      assertTrue(isElementPresent(By.linkText("SETTINGS")));
      assertEquals(driver.findElement(By.linkText("SETTINGS")).getText(), "SETTINGS");
      driver.findElement(By.id("buildDropDown")).click();
      driver.findElement(By.id("navbar-comp__logout-link")).click();
      assertTrue(isElementPresent(By.id("navbar-comp__login-link")));
      
	  }
	  //Login failed
	  @Test
	  public void Login_Failed() throws Exception{
	  driver.get(baseUrl + "/playground");
	    Thread.sleep(2000);
      //Security  password
      Alert alert=driver.switchTo().alert();
      driver.switchTo().alert().sendKeys("v*2$5X0e41US");
      alert.accept();
      Thread.sleep(2000);
      driver.findElement(By.cssSelector("option[value=\"en\"]")).click();
      Thread.sleep(1000);
      driver.findElement(By.id("navbar-comp__login-link")).click();
      Thread.sleep(500);
      driver.findElement(By.id("login-comp__username")).clear();
      driver.findElement(By.id("login-comp__username")).sendKeys("dmarroquin@belatrixsf");
      driver.findElement(By.id("login-comp__password")).clear();
      driver.findElement(By.id("login-comp__password")).sendKeys("Deni1402$");
      driver.findElement(By.id("login-comp__submit")).click();
      assertTrue(isElementPresent(By.cssSelector("div.toast-title")));
      assertEquals(driver.findElement(By.cssSelector("div.toast-message")).getText(), "Login Fails!");
      Thread.sleep(1000);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__username")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.cssSelector("div.modal-body")).click();
      assertTrue(isElementPresent(By.cssSelector("div.alert.alert-danger")));
      assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "Email is required for login");
      driver.findElement(By.id("login-comp__password")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__password")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__password")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__password")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__password")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__password")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__password")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__password")).sendKeys(Keys.BACK_SPACE);
      driver.findElement(By.id("login-comp__password")).sendKeys(Keys.BACK_SPACE);
      assertTrue(isElementPresent(By.xpath("//div[@id='login-comp']/div[2]/form/div[2]/div")));
      assertEquals(driver.findElement(By.xpath("//div[@id='login-comp']/div[2]/form/div[2]/div")).getText(), "Password is required for login");
     
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