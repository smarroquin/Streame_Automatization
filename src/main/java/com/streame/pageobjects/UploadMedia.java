package com.streame.pageobjects;

import static org.testng.Assert.assertEquals;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

public class UploadMedia {
	public WebDriver driver;
	public By Title =By.id("upload-title");
	public By Description =By.id("upload-description");
	public By Kind =By.cssSelector("div.placeholder");
	public By Genre =By.xpath("//div[5]/label");
    public By MediaButton=By.cssSelector("label.btn.upload-buttons__browse");
    public By ThumbnailButton= By.cssSelector("label.btn.upload-buttons__browse");
    public By InitialButton = By.xpath("//metafiles-upload-box[2]/div/div[2]/div/label");
    public By Keywords=By.xpath("(//input[@type='text'])[3]");
	public By Audience = By.cssSelector("div.upload-form__switch-slider");
    public By Type= By.xpath("//div[7]/div/label");
    public By SaveButton=By.xpath("//button[@type='submit']");
    public By Kinput= By.xpath("//chips[@id='upload-keywords']/div/input");
    public By Iinput= By.xpath("//chips[@id='upload-invitation']/div/input");
    
    
	public UploadMedia(WebDriver driver) {
		this.driver = driver;
	}
	public static void setClipBoardData(String string){
        StringSelection stringselect = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselect, null);
    }
	public void enterImage () throws Exception {
		MediaFile("C:\\Users\\dmarroquin\\Pictures\\Camera Roll\\casita.jpg");
		System.out.println("Image Selected");
	}
	public void enterAudio () throws Exception {
		MediaFile("C:\\Users\\dmarroquin\\Videos\\example.aac");
	}
	
	public void enterWrongImage () throws Exception {
		MediaFile("C:\\Users\\dmarroquin\\Pictures\\Camera Roll\\large.bmp");
	}
	
	public void enterThumbAudio () throws Exception {
		MediaFile("C:\\Users\\dmarroquin\\Pictures\\Camera Roll\\org.png");
	}
	public void enterVideo () throws Exception {
		MediaFile("C:\\Users\\dmarroquin\\Videos\\toy_plane_liftoff.avi");
	}

	public void enterInitialImageVideo () throws Exception{
	    MediaFile("C:\\Users\\dmarroquin\\Pictures\\Camera Roll\\org.png");
	}	
	
	public void enterThumbVideo () throws Exception {
		MediaFile("C:\\Users\\dmarroquin\\Pictures\\Camera Roll\\Piura.jpg");
	}

	public void enterVideoBack () throws Exception {
		MediaFile("C:\\Users\\dmarroquin\\Videos\\Shaman King Capitulo 35 Audio Latino.3g2");
	}
	public void enterDocument () throws Exception {
		MediaFile("C:\\Users\\dmarroquin\\Documents\\Plan Base 2016.pdf");
	}
	public void enterThumbDocument () throws Exception {
		MediaFile("C:\\Users\\dmarroquin\\Pictures\\Camera Roll\\org.png");
	}
	public static void MediaFile(String Media){
        try{
            setClipBoardData(Media);
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
	    assertEquals(driver.findElement(By.xpath("(//button[@type='button'])[7]")).getText(), "Cancel");
	    assertEquals(driver.findElement(By.cssSelector("cropper-modal > div.container > div.modal-header > button.close")).getText(), "×");
	    driver.findElement(By.cssSelector("button.btn.btn-secondary")).click();
	    driver.switchTo().activeElement();
	}
	
	public void SidebarScroll() {
		WebElement element = driver.findElement(By.xpath("//form"));
		Coordinates coordinate = ((Locatable)element).getCoordinates();
		coordinate.inViewPort();
	}
	
	public String RandomNumber(int length){
	    return RandomStringUtils.randomNumeric(length);
	} 
	

	
}
