package Streame.Test_UI;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.datatransfer.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test002_Register {

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
	  //Register only look and feel  
	  @Test
	  public void Create_Account_Look_Feel() throws Exception {
	      driver.get(baseUrl + "/playground");
	      Thread.sleep(2000);
	      //Security  password
	      Alert alert=driver.switchTo().alert();
	      driver.switchTo().alert().sendKeys("v*2$5X0e41US");
	      alert.accept();
	      Thread.sleep(2000);
	      assertTrue(isElementPresent(By.cssSelector("img[alt=\"Streame logo\"]")));
	      Thread.sleep(5000);
	      assertTrue(isElementPresent(By.linkText("DISCOVER")));
	      Thread.sleep(3000);
	      assertTrue(isElementPresent(By.id("navbar-comp__langMenu")));
	      driver.findElement(By.cssSelector("option[value=\"en\"]")).click();
	      Thread.sleep(1000);
	      assertTrue(isElementPresent(By.id("navbar-comp__login-link")));
	      assertTrue(isElementPresent(By.id("navbar-comp__register-link")));
	      assertEquals(driver.findElement(By.id("navbar-comp__register-link")).getText(), "CREATE ACCOUNT");
	      driver.findElement(By.id("navbar-comp__register-link")).click();
	      Thread.sleep(2000);
	      assertTrue(isElementPresent(By.cssSelector("div.modal-header")));
	      assertTrue(isElementPresent(By.id("register-comp")));
	      assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Create your account. Now for free.");
	      assertTrue(isElementPresent(By.id("register-comp__first-name")));
	      assertTrue(isElementPresent(By.id("register-comp__last-name")));
	      assertTrue(isElementPresent(By.id("register-comp__email")));
	      assertTrue(isElementPresent(By.name("dp")));
	      assertTrue(isElementPresent(By.xpath("//div[@id='register-comp']/form/div[5]/div/div/div/label")));
	      assertEquals(driver.findElement(By.id("register-comp__display-name")).getText(), "");
	      assertTrue(isElementPresent(By.id("register-comp__display-name")));
	      assertTrue(isElementPresent(By.id("register-comp__url")));
	      assertTrue(isElementPresent(By.id("register-comp__address")));
	      assertTrue(isElementPresent(By.id("register-comp__country")));
	      assertTrue(isElementPresent(By.id("register-comp__city")));
	      driver.findElement(By.id("register-comp")).sendKeys(Keys.ARROW_DOWN);
	      driver.findElement(By.id("register-comp")).sendKeys(Keys.ARROW_DOWN);
	      assertTrue(isElementPresent(By.id("register-comp__zipcode")));
	      assertTrue(isElementPresent(By.cssSelector("span.make-drag-overlay.avatar-inherit")));
	      assertTrue(isElementPresent(By.id("register-comp__password")));
	      assertTrue(isElementPresent(By.id("register-comp__confirm-password")));
	      assertTrue(isElementPresent(By.cssSelector("button.close")));
	      driver.findElement(By.cssSelector("button.close")).click();
	      assertTrue(isElementPresent(By.id("navbarSupportedContent")));
	    }
	  //Register successfully without image
	  @Test
	  public void Create_Account_Successfully_WO_Image() throws Exception {
		    driver.get(baseUrl + "/playground");
		    Thread.sleep(2000);
	        //Security  password
	        Alert alert=driver.switchTo().alert();
	        driver.switchTo().alert().sendKeys("v*2$5X0e41US");
	        alert.accept();
	        Thread.sleep(2000);
	        driver.findElement(By.cssSelector("option[value=\"en\"]")).click();
		    driver.findElement(By.id("navbar-comp__register-link")).click();
		    driver.findElement(By.id("register-comp__first-name")).clear();
		    driver.findElement(By.id("register-comp__first-name")).sendKeys("Denisse");
		    driver.findElement(By.id("register-comp__last-name")).clear();
		    driver.findElement(By.id("register-comp__last-name")).sendKeys("Marroquin");
		    driver.findElement(By.id("register-comp__email")).clear();
		    driver.findElement(By.id("register-comp__email")).sendKeys("denissita1401@hotmail.com");
		    driver.findElement(By.cssSelector("i.fa.fa-calendar")).click();
		    //DatePicker
		    driver.findElement(By.name("dp")).clear();
		    driver.findElement(By.name("dp")).sendKeys("1985-11-03");
		    driver.findElement(By.cssSelector("div.input-group-addon")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("register-comp__gender-1")).click();
		    driver.findElement(By.id("register-comp__display-name")).clear();
		    driver.findElement(By.id("register-comp__display-name")).sendKeys("Denisse32");
		    driver.findElement(By.id("register-comp__url")).clear();
		    driver.findElement(By.id("register-comp__url")).sendKeys("Denisse32");
		    driver.findElement(By.id("register-comp__address")).clear();
		    driver.findElement(By.id("register-comp__address")).sendKeys("Calle Los Olivos 215");
		    driver.findElement(By.id("register-comp__city")).clear();
		    driver.findElement(By.id("register-comp__city")).sendKeys("Lima");
		    driver.findElement(By.id("register-comp__country")).clear();
		    driver.findElement(By.id("register-comp__country")).sendKeys("Peru");
		    driver.findElement(By.id("register-comp__zipcode")).clear();
		    driver.findElement(By.id("register-comp__zipcode")).sendKeys("27");
		    driver.findElement(By.id("register-comp__password")).clear();
		    driver.findElement(By.id("register-comp__password")).sendKeys("Pruebas01$");
		    driver.findElement(By.id("register-comp__confirm-password")).clear();
		    driver.findElement(By.id("register-comp__confirm-password")).sendKeys("Pruebas01$");
		    assertFalse(isElementPresent(By.cssSelector("div.alert.alert-danger")));
	  }
	  //Register successfully with image
	  @Test
	  public void Create_Account_Successfully_W_Image() throws Exception {
		    driver.get(baseUrl + "/playground");
		    Thread.sleep(2000);
	        //Security  password
	        Alert alert=driver.switchTo().alert();
	        driver.switchTo().alert().sendKeys("v*2$5X0e41US");
	        alert.accept();
	        Thread.sleep(2000);
	        driver.findElement(By.cssSelector("option[value=\"en\"]")).click();
		    driver.findElement(By.id("navbar-comp__register-link")).click();
		    driver.findElement(By.id("register-comp__first-name")).clear();
		    driver.findElement(By.id("register-comp__first-name")).sendKeys("Denisse");
		    driver.findElement(By.id("register-comp__last-name")).clear();
		    driver.findElement(By.id("register-comp__last-name")).sendKeys("Marroquin");
		    driver.findElement(By.id("register-comp__email")).clear();
		    driver.findElement(By.id("register-comp__email")).sendKeys("denissita1401@hotmail.com");
		    driver.findElement(By.cssSelector("i.fa.fa-calendar")).click();
		    //DatePicker
		    driver.findElement(By.name("dp")).clear();
		    driver.findElement(By.name("dp")).sendKeys("1985-11-03");
		    driver.findElement(By.cssSelector("div.input-group-addon")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("register-comp__gender-1")).click();
		    driver.findElement(By.id("register-comp__display-name")).clear();
		    driver.findElement(By.id("register-comp__display-name")).sendKeys("Denisse32");
		    driver.findElement(By.id("register-comp__url")).clear();
		    driver.findElement(By.id("register-comp__url")).sendKeys("Denisse32");
		    driver.findElement(By.id("register-comp__address")).clear();
		    driver.findElement(By.id("register-comp__address")).sendKeys("Calle Los Olivos 215");
		    driver.findElement(By.id("register-comp__city")).clear();
		    driver.findElement(By.id("register-comp__city")).sendKeys("Lima");
		    driver.findElement(By.id("register-comp__country")).clear();
		    driver.findElement(By.id("register-comp__country")).sendKeys("Peru");
		    driver.findElement(By.id("register-comp__zipcode")).clear();
		    driver.findElement(By.id("register-comp__zipcode")).sendKeys("27");
		    //Upload an image picture.
		    assertTrue(isElementPresent(By.cssSelector("span.make-drag-overlay.avatar-inherit")));
		    assertEquals(driver.findElement(By.cssSelector("span.make-drag-overlay.avatar-inherit")).getText(), "");
		    driver.findElement(By.cssSelector("span.make-drag-overlay.avatar-inherit")).click();
		    uploadImage("C:\\Users\\dmarroquin\\Pictures\\Camera Roll\\IMG_20160601_091341.jpg");
		    Thread.sleep(500);
		    driver.switchTo().activeElement();
		    assertTrue(isElementPresent(By.cssSelector("cropper-modal > div.container > div.modal-header")));
		    assertEquals(driver.findElement(By.cssSelector("h4.modal-title")).getText(), "Recortar la imagen");
		    assertTrue(isElementPresent(By.cssSelector("canvas")));
		    assertTrue(isElementPresent(By.cssSelector("button.btn.btn-secondary")));
		    assertEquals(driver.findElement(By.cssSelector("button.btn.btn-secondary")).getText(), "Cancel");
		    assertTrue(isElementPresent(By.xpath("(//button[@type='button'])[5]")));
		    assertEquals(driver.findElement(By.xpath("(//button[@type='button'])[5]")).getText(), "Ok");
		    assertTrue(isElementPresent(By.cssSelector("cropper-modal > div.container > div.modal-header > button.close")));
		    assertEquals(driver.findElement(By.cssSelector("cropper-modal > div.container > div.modal-header > button.close")).getText(), "×");
		    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		    driver.switchTo().activeElement();
		    assertTrue(isElementPresent(By.cssSelector("span.make-drag-overlay.avatar-inherit")));
		    driver.findElement(By.id("register-comp__password")).clear();
		    driver.findElement(By.id("register-comp__password")).sendKeys("Pruebas01$");
		    driver.findElement(By.id("register-comp__confirm-password")).clear();
		    driver.findElement(By.id("register-comp__confirm-password")).sendKeys("Pruebas01$");
		    assertFalse(isElementPresent(By.cssSelector("div.alert.alert-danger")));
	  }
	  //Register Validations Messages
	  @Test
	  public void Create_Account_Validation_Message() throws Exception{
		    driver.get(baseUrl + "/playground");
		    Thread.sleep(2000);
	        //Security  password
	        Alert alert=driver.switchTo().alert();
	        driver.switchTo().alert().sendKeys("v*2$5X0e41US");
	        alert.accept();
	        Thread.sleep(2000);
	        driver.findElement(By.cssSelector("option[value=\"en\"]")).click(); 
	        Thread.sleep(2000);
	  }
	  ////REQUIRED CLASS FOR UPLOAD IMAGE
	  //StringSelection class used for copy and paste operations.
	  public static void setClipBoardData(String string){
		        //Copying the path of the file to the clipboard 
		          //StringSelection class used for copy and paste operations.
		          StringSelection stringselect = new StringSelection(string);//Putting the path of the image to upload
		          Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselect, null);
		      }
	  //Setting clipboard with image location           
	  public static void uploadImage(String imagelocation){
		        try{
		            //Setting clipboard with image location
		            setClipBoardData(imagelocation);
		          //Some sleep time to detect the window popup
		            Thread.sleep(500);
		            //native key strokes for CTRL, V and ENTER keys
		            Robot robot =  new Robot();
		            robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
		            robot.keyPress(java.awt.event.KeyEvent.VK_V);
		            robot.keyRelease(java.awt.event.KeyEvent.VK_V);
		            robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
		          //To Click on the "Open" button to upload files
		            robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		            robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		            robot.delay(1000);
		        } catch (Exception exp) {
		            exp.printStackTrace();
		        }
	  
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
