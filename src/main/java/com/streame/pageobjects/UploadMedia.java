package com.streame.pageobjects;

import static org.testng.Assert.assertEquals;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

public class UploadMedia {
	public WebDriver driver;
	public By Title =By.id("upload-title");
	public By Description =By.id("upload-description");
	public By Kind =By.cssSelector("div.placeholder");
	public By Genre =By.xpath("//advanced-select[@id='upload-genres']/ng-select/div/div/input");

	
	public UploadMedia(WebDriver driver) {
		this.driver = driver;
	}
	public static void setClipBoardData(String string){
        StringSelection stringselect = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselect, null);
    }
	public void enterImage () throws Exception {
		MediaImage("C:\\Users\\dmarroquin\\Pictures\\Camera Roll\\casita.jpg");
		System.out.println("Image Selected");
	}
	
	public static void MediaImage(String Image){
        try{
            setClipBoardData(Image);
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
	
	public void Cropper() throws Exception {
		driver.switchTo().activeElement();
	    assertEquals(driver.findElement(By.cssSelector("h4.modal-title")).getText(), "Crop the image");
	    assertEquals(driver.findElement(By.cssSelector("button.btn.btn-secondary")).getText(), "OK");
	    assertEquals(driver.findElement(By.xpath("(//button[@type='button'])[9]")).getText(), "Cancel");
	    assertEquals(driver.findElement(By.cssSelector("cropper-modal > div.container > div.modal-header > button.close")).getText(), "×");
	    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
	    driver.switchTo().activeElement();
	}
	
	public void SidebarScroll() {
		WebElement element = driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[4]/label"));
		Coordinates coordinate = ((Locatable)element).getCoordinates();
		coordinate.inViewPort();
	}
	
	
	
}
