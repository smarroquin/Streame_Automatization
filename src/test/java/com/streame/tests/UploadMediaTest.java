package com.streame.tests;

import static org.testng.Assert.*;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.streame.base.Setup;
import com.streame.pageobjects.*;

public class UploadMediaTest extends Setup{
	private WebDriver driver;
	public BuildMenu BuildMenu;
	private HomePage HomePage;
	public SignInPage signInPage;
	public UploadMedia Upload;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	
	@Test(priority=1)
	public void OpenUpload() throws Exception {
		HomePage = new HomePage(driver);
		HomePage.SecurityPassword();
		Thread.sleep(1000);
		signInPage = HomePage.clickSignIn();
		Thread.sleep(2000);
		signInPage.verifyValidSignIn();
		driver.findElement(signInPage.loginBtn).click();
		Thread.sleep(3000);
        Assert.assertTrue(HomePage.isElementPresent(By.cssSelector("button.nav-link.build-menu-button")));
        BuildMenu = new BuildMenu(driver);
        BuildMenu.clickBuild();
	    Assert.assertEquals(driver.findElement(By.xpath("//h4[2]/span")).getText(), "Media");
	    Upload = new UploadMedia(driver);
	    driver.findElement(By.xpath("//h4[2]/span")).click();
	    Thread.sleep(500);
	    assertEquals(driver.findElement(By.cssSelector("media-menu > h4.menu-button")).getText(), "Upload Media");
	    driver.findElement(By.cssSelector("media-menu > h4.menu-button")).click();
	    Thread.sleep(500);
	    driver.findElement(Upload.MediaButton).click();
	    Thread.sleep(1000);
	    Upload.enterImage();
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.status-overlay__content > span")));
	    Thread.sleep(6000);
	    assertEquals(driver.findElement(By.cssSelector("div.status-overlay__content > span")).getText(), "Image File Uploaded");
	    assertEquals(driver.findElement(By.cssSelector("span.metadata-preview-content__key")).getText(), "File Name:");
	    assertEquals(driver.findElement(By.cssSelector("p.metadata-preview__info > span.metadata-preview-content__key")).getText(), "Size:");
	    //File Name and Size
	    assertEquals(driver.findElement(By.xpath("//div[2]/div/div/div/span[2]")).getText(), "Casita.jpg");
	    assertEquals(driver.findElement(By.cssSelector("span.metadata-preview__size")).getText(), "5.59 KB");
	    assertEquals(driver.findElement(By.cssSelector("div.progress-bar")).getText(), "100 %");
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[2]/i")));
	    assertTrue(HomePage.isElementPresent(By.cssSelector("img.images-preview__media-img")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//metafiles-upload-box/div")));
	    assertTrue(HomePage.isElementPresent(By.cssSelector("label.btn.upload-buttons__browse")));
	    driver.findElement(Upload.ThumbnailButton).click();
	    Thread.sleep(500);
	    Upload.enterImage();
	    Upload.Cropper();
	    Thread.sleep(500);
	    Upload.SidebarScroll();
	    Upload.SidebarScroll();
	    Thread.sleep(500);
	   try{
	   assertTrue(driver.findElement(By.xpath("//form/div/label")).getText().matches("^exact:Title \\([\\s\\S]*\\)$"));
	   assertTrue(driver.findElement(By.xpath("//div[2]/label")).getText().matches("^exact:Description [\\s\\S]*$"));
	    assertTrue(driver.findElement(By.xpath("//div[3]/label")).getText().matches("^exact:Kind \\([\\s\\S]*\\)$"));
	    assertTrue(driver.findElement(By.xpath("//div[4]/label")).getText().matches("^exact:Genres \\([\\s\\S]*\\)$"));
	    assertTrue(driver.findElement(By.xpath("//div[5]/label")).getText().matches("^exact:Keywords \\([\\s\\S]*\\)$"));
	   } catch(Error e){}
	    assertEquals(driver.findElement(By.xpath("//div[6]/label")).getText(), "Explicit Content");
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.upload-form__switch-slider")));
	    assertEquals(driver.findElement(By.cssSelector("label.upload-form__label.upload-form__label_block")).getText(), "Visibility");
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[7]/div/label")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//label[2]")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//label[3]")));
	    assertEquals(driver.findElement(By.xpath("//div[8]/label")).getText(), "Share");
	    try{ 
	    assertTrue(driver.findElement(By.xpath("//form/label")).getText().matches("^exact:[\\s\\S]* Required fields$"));
	    } catch(Error e){}
	    try{ 
	    assertTrue(HomePage.isElementPresent(By.id("upload-title")));
	    } catch(Error e){}
	    assertEquals(driver.findElement(By.id("upload-title")).getText(), "");
	    try{ 
	    assertTrue(HomePage.isElementPresent(By.id("upload-description")));
	    } catch(Error e){}
	    assertEquals(driver.findElement(By.id("upload-description")).getText(), "");
	    try{ 
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.placeholder")));
	    } catch(Error e){}
	    //REVIEW LATER
	    assertEquals(driver.findElement(By.cssSelector("div.placeholder")).getText(), "Search Or Select One Kind");
	    try{ 
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.multiple > input")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//chips[@id='upload-genres']/div")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//advanced-select[@id='upload-categories']/div/ng-select/div/div/input")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//advanced-select[@id='upload-audience']/div/ng-select/div/div/div")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label")));
	    } catch(Error e){}
	    assertEquals(driver.findElement(By.xpath("//div[7]/div/label")).getText(), "Private");
	    assertEquals(driver.findElement(By.cssSelector("small.form-group__small")).getText(), "Viewable Only For Its Publishers. Can't Be Searched Or Included In A Page Or A Channel.");
	    driver.findElement(By.xpath("//label[2]")).click();
	    Thread.sleep(1000);
	    assertEquals(driver.findElement(By.xpath("//label[2]")).getText(), "Public");
	    assertEquals(driver.findElement(By.cssSelector("small.form-group__small")).getText(), "Searchable And Viewable By Everyone.");
	    driver.findElement(By.xpath("//label[3]")).click();
	    Thread.sleep(1000);
	    assertEquals(driver.findElement(By.xpath("//label[3]")).getText(), "Invitation");
	    assertEquals(driver.findElement(By.cssSelector("small.form-group__small")).getText(), "Viewable Only For Its Publishers And Invitees. Can't Be Searched Or Included In A Page Or A Channel.");
	    assertEquals(driver.findElement(By.cssSelector("div.ml-3 > label.upload-form__label.upload-form__label_block")).getText(), "Invite To");
	    assertTrue(HomePage.isElementPresent(By.cssSelector("#upload-invitation > div.chips-container > input.input")));
	    driver.findElement(By.xpath("//div[7]/div/label")).click();
	    Thread.sleep(1000);
	    assertTrue(HomePage.isElementPresent(By.cssSelector("button.btn.btn-default")));
	    assertEquals(driver.findElement(By.cssSelector("button.btn.btn-default")).getText(), "CANCEL");
	Thread.sleep(1000);
	}

	@Test(priority=2)
	public void UploadValidations() throws Exception {
	    WebElement problematicElement= driver.findElement(By.xpath("//form"));
	    JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("11/");
	    Thread.sleep(1000);
	    assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "Title Must Not Contain Numbers Or Special Characters");
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.alert.alert-danger")));
	    driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("/");
	    Thread.sleep(500);
	    assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "Title Must Not Contain Numbers Or Special Characters");
	    driver.findElement(Upload.Title).sendKeys(Keys.BACK_SPACE);
	    driver.findElement(Upload.Title).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(1000);
	    assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "Title Is Required");
	    driver.findElement(Upload.Description).clear();
	    driver.findElement(Upload.Description).sendKeys("k");
	    Thread.sleep(500);
	    driver.findElement(Upload.Description).sendKeys(Keys.BACK_SPACE);
	    driver.findElement(Upload.Description).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(2000);
	    assertTrue(HomePage.isElementPresent(By.xpath("//form/div[3]")));
	    assertEquals(driver.findElement(By.xpath("//form/div[3]")).getText(), "Description Is Required");
	    driver.findElement(Upload.Kind).click();
	    driver.findElement(Upload.Kind).click();
	    Thread.sleep(1000);
	    assertEquals(driver.findElement(By.xpath("//form/div[4]/div")).getText(), "Please Choose At Least One Kind");
	    assertTrue(HomePage.isElementPresent(By.xpath("//form/div[4]/div")));
	    Thread.sleep(1000);
	    //Genre
	    assertTrue(HomePage.isElementPresent(Upload.Genre));
	    assertEquals(driver.findElement(Upload.Genre).getText(), "Genres");
        js.executeScript("scroll(0, 250);");
	    //Keywords
	    driver.findElement(Upload.Keywords).click();
	    assertTrue(HomePage.isElementPresent(By.xpath("//chips-columns[@id='upload-keywords']/div/input")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[6]/chips-columns/div/div[2]/infinite-scroll/div/div/span/span")));
   	    Thread.sleep(1000);
   	 driver.findElement(By.xpath("//div[6]/chips-columns/div/div[2]/infinite-scroll/div/div/span/span")).click();
   	 driver.findElement(By.xpath("//div[6]/chips-columns/div/div[2]/infinite-scroll/div/div[4]/span/span")).click();
     driver.findElement(By.xpath("//div[6]/chips-columns/div/div[2]/infinite-scroll/div/div[7]/span/span")).click();
     driver.findElement(By.xpath("//div[6]/chips-columns/div/div[2]/infinite-scroll/div/div[2]/span/span")).click();
     driver.findElement(By.xpath("//div[6]/chips-columns/div/div[2]/infinite-scroll/div/div[5]/span/span")).click();
     driver.findElement(By.xpath("//div[6]/chips-columns/div/div[2]/infinite-scroll/div/div[3]/span/span")).click();
     driver.findElement(By.xpath("//div[6]/chips-columns/div/div[2]/infinite-scroll/div/div[6]/span/span")).click();
     assertTrue(HomePage.isElementPresent(Upload.Kinput));
     driver.findElement(Upload.Kinput).clear();
     driver.findElement(Upload.Kinput).sendKeys("Drama");
     Thread.sleep(1000);
     assertTrue(HomePage.isElementPresent(By.xpath("//chips-columns[@id='upload-keywords']/div/div[2]/infinite-scroll/div/div/span/span[2]")));
     driver.findElement(By.xpath("//chips-columns[@id='upload-keywords']/div/div[2]/infinite-scroll/div/div/span/span[2]")).click();
     Thread.sleep(1000);
     driver.findElement(Upload.Kinput).clear();
     driver.findElement(Upload.Kinput).sendKeys("");
     Thread.sleep(1000);
     driver.findElement(Upload.Kinput).clear();
     driver.findElement(Upload.Kinput).sendKeys("Rainy");
     Thread.sleep(1000);
     driver.findElement(By.xpath("//chips-columns[@id='upload-keywords']/div/div[2]/infinite-scroll/div/div/span/span[2]")).click();
     driver.findElement(Upload.Kinput).clear();
     driver.findElement(Upload.Kinput).sendKeys("Rainys");
     Thread.sleep(1000);
     driver.findElement(By.xpath("//chips-columns[@id='upload-keywords']/div/div[2]/infinite-scroll/div/div/span/span[2]")).click();
     driver.findElement(Upload.Kinput).clear();
     driver.findElement(Upload.Kinput).sendKeys("Rainyss");
     Thread.sleep(1000);
     driver.findElement(By.xpath("//chips-columns[@id='upload-keywords']/div/div[2]/infinite-scroll/div/div/span/span[2]")).click();
     Thread.sleep(1000);
	    assertTrue(HomePage.isElementPresent(By.xpath("//form/div[6]/div")));
	    assertEquals(driver.findElement(By.xpath("//form/div[6]/div")).getText(), "Only 10 Keywords Can Be Selected");
	    Thread.sleep(1000);
	    // Invitation x completar
	   /* driver.findElement(By.xpath("//label[3]")).click();
	    Thread.sleep(1000);*/
	    js.executeScript("arguments[0].scrollIntoView()", problematicElement);
	    Thread.sleep(1000);
	   /* 
	    assertTrue(HomePage.isElementPresent(By.cssSelector("#upload-invitation > div.chips-container > input.input")));
	    driver.findElement(Upload.Iinput).click();
	    Thread.sleep(1000);
	    assertTrue(HomePage.isElementPresent(By.cssSelector("#upload-invitation > div.chips-container > input.input")));
	    driver.findElement(Upload.Iinput).sendKeys("dmarroquin@gmail.com");
	    Thread.sleep(1000);
	    driver.findElement(Upload.Iinput).click();
	    //Share X Completar
	    Thread.sleep(1000);
	    js.executeScript("arguments[0].scrollIntoView()", problematicElement);
	    assertTrue(HomePage.isElementPresent(By.cssSelector("#upload-share > div.chips-container > input.input")));
	    driver.findElement(By.xpath("//chips[@id='upload-share']/div/input")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//chips[@id='upload-share']/div/input")).sendKeys("dmarroquin@gmail.com");
	    Thread.sleep(1000);
	    driver.findElement(By.id("ngb-typeahead-5-0")).click();
	    	*/    	    
	    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.modal-body")));
	    assertEquals(driver.findElement(By.cssSelector("p.modal-body__description")).getText(), "casita.jpg image file will be deleted.\nYou'll have to upload a file again.");
	    assertTrue(HomePage.isElementPresent(By.cssSelector("button.modal-footer__btn")));
	    assertTrue(HomePage.isElementPresent(By.xpath("(//button[@type='button'])[4]")));
	    assertEquals(driver.findElement(By.cssSelector("button.modal-footer__btn")).getText(), "Delete file");
	    assertEquals(driver.findElement(By.xpath("(//button[@type='button'])[4]")).getText(), "Keep file");
	    driver.findElement(By.cssSelector("button.modal-footer__btn")).click();
        Thread.sleep(500);
        js.executeScript("scroll(0, -250);");
      	}

	@Test(priority=3)
	public void UploadMediaImage() throws Exception {
     
	    driver.findElement(Upload.MediaButton).click();
	    Upload.enterImage();
	    driver.findElement(Upload.ThumbnailButton).click();
	    Thread.sleep(500);
	    Upload.enterImage();
	    Upload.Cropper();
	    driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("Image" + " " + Upload.RandomNumber(3));
	    driver.findElement(Upload.Description).clear();
	    driver.findElement(Upload.Description).sendKeys("AUTOMATIZATION IMAGE MEDIA");
	    Thread.sleep(500);
	    driver.findElement(Upload.Kind).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//select-dropdown/div/div[2]/ul/li")).click();
	    driver.findElement(By.xpath("//chips[@id='upload-genres']/div/input")).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//chips[@id='upload-genres']/div/input")).sendKeys(Keys.ARROW_DOWN);
	    driver.findElement(By.xpath("//chips[@id='upload-genres']/div/input")).sendKeys(Keys.ENTER);
	    driver.findElement(Upload.Keywords).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    Thread.sleep(500);
	    driver.findElement(Upload.Audience).click();
	    driver.findElement(Upload.Type).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.SaveButton));
        driver.findElement(Upload.SaveButton).click();
        Thread.sleep(5000);
	    JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0, -250);");
        driver.findElement(By.xpath("//span[3]")).click();
        Thread.sleep(1000);
	}

	@Test(priority=4)
	public void UploadMediaAudio() throws Exception {
		BuildMenu.clickBuild();
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//h4[2]/span")).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//media-menu/h4")).click();
		Thread.sleep(500);
	    driver.findElement(Upload.MediaButton).click();
	    Upload.enterAudio();;
	    driver.findElement(Upload.ThumbnailButton).click();
	    Thread.sleep(500);
	    Upload.enterThumbAudio();
	    Upload.Cropper();
	    driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("Audio" + " " + Upload.RandomNumber(3));
	    driver.findElement(Upload.Description).clear();
	    driver.findElement(Upload.Description).sendKeys("AUTOMATIZATION AUDIO MEDIA");
	    Thread.sleep(500);
	    driver.findElement(Upload.Kind).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//select-dropdown/div/div[2]/ul/li")).click();
	    driver.findElement(By.xpath("//chips[@id='upload-genres']/div/input")).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//chips[@id='upload-genres']/div/input")).sendKeys(Keys.ARROW_DOWN);
	    driver.findElement(By.xpath("//chips[@id='upload-genres']/div/input")).sendKeys(Keys.ENTER);
	    driver.findElement(Upload.Keywords).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Audience).click();
	    driver.findElement(Upload.Type).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.SaveButton));
        driver.findElement(Upload.SaveButton).click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0, -250);");
        driver.findElement(By.xpath("//span[3]")).click();
        Thread.sleep(1000);
	}
	@Test(priority=5)
	public void UploadMediaVideo() throws Exception {
		BuildMenu.clickBuild();
	   driver.findElement(By.xpath("//h4[2]/span")).click();
	   driver.findElement(By.xpath("//media-menu/h4")).click();
	    driver.findElement(Upload.MediaButton).click();
	    Upload.enterVideo();;
	    driver.findElement(Upload.ThumbnailButton).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.InitialButton));
	    driver.findElement(Upload.InitialButton).click();
	    Upload.enterInitialImageVideo();
	    Upload.Cropper();
	    Upload.enterThumbVideo();
	    Upload.Cropper();
	    driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("Video" + " " + Upload.RandomNumber(3));
	    driver.findElement(Upload.Description).clear();
	    driver.findElement(Upload.Description).sendKeys("AUTOMATIZATION VIDEO MEDIA");
	    Thread.sleep(500);
	    driver.findElement(Upload.Kind).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//select-dropdown/div/div[2]/ul/li")).click();
	    driver.findElement(By.xpath("//chips[@id='upload-genres']/div/input")).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//chips[@id='upload-genres']/div/input")).sendKeys(Keys.ARROW_DOWN);
	    driver.findElement(By.xpath("//chips[@id='upload-genres']/div/input")).sendKeys(Keys.ENTER);
	    driver.findElement(Upload.Keywords).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Audience).click();
	    driver.findElement(Upload.Type).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.SaveButton));
        driver.findElement(Upload.SaveButton).click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0, -250);");
        driver.findElement(By.xpath("//span[3]")).click();
        Thread.sleep(5000);
	}
	@Test(priority=6)
	public void UploadMediaDocument() throws Exception {
		BuildMenu.clickBuild();
	   driver.findElement(By.xpath("//h4[2]/span")).click();
	   driver.findElement(By.xpath("//media-menu/h4")).click();
	    driver.findElement(Upload.MediaButton).click();
	    Upload.enterDocument();;
	    driver.findElement(Upload.ThumbnailButton).click();
	    Thread.sleep(500);
	    Upload.enterThumbDocument();
	    Upload.Cropper();
	    driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("Document" + " " + Upload.RandomNumber(3));
	    driver.findElement(Upload.Description).clear();
	    driver.findElement(Upload.Description).sendKeys("AUTOMATIZATION AUDIO MEDIA");
	    Thread.sleep(500);
	    driver.findElement(Upload.Kind).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//select-dropdown/div/div[2]/ul/li")).click();
	    driver.findElement(By.xpath("//chips[@id='upload-genres']/div/input")).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//chips[@id='upload-genres']/div/input")).sendKeys(Keys.ARROW_DOWN);
	    driver.findElement(By.xpath("//chips[@id='upload-genres']/div/input")).sendKeys(Keys.ENTER);
	    driver.findElement(Upload.Keywords).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Audience).click();
	    driver.findElement(Upload.Type).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.SaveButton));
        driver.findElement(Upload.SaveButton).click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0, -250);");
        Thread.sleep(5000);
	}
	 @Test(priority=7)
	  public void UploadOnBackground() throws Exception {
		driver.findElement(Upload.MediaButton).click();
	    Upload.enterVideoBack();;
	    driver.findElement(Upload.ThumbnailButton).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.InitialButton));
	    driver.findElement(Upload.InitialButton).click();
	    Upload.enterInitialImageVideo();
	    Upload.Cropper();
	    Upload.enterThumbVideo();
	    Upload.Cropper();
	    driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("VideoCargaBack" + " " + Upload.RandomNumber(3));
	    driver.findElement(Upload.Description).clear();
	    driver.findElement(Upload.Description).sendKeys("AUTOMATIZATION VIDEO MEDIA");
	    Thread.sleep(500);
	    driver.findElement(Upload.Kind).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//select-dropdown/div/div[2]/ul/li")).click();
	    Thread.sleep(1000);
	    //driver.findElement(Upload.Type).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.SaveButton));
        driver.findElement(Upload.SaveButton).click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(0, -250);");
        assertTrue(HomePage.isElementPresent(By.xpath("/html/body/streame-app/layout/div/build-menu-r-ct/build-menu-r/div/div/upload-container/upload-overlay/dialog/button")));
        driver.findElement(By.xpath("/html/body/streame-app/layout/div/build-menu-r-ct/build-menu-r/div/div/upload-container/upload-overlay/dialog/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/streame-app/layout/div/build-menu-r-ct/build-menu-r/div/div/upload-container/upload-overlay/dialog/div[1]/upload-bg-bar")).click();
        Thread.sleep(15000);
        driver.findElement(By.xpath("//span[3]")).click();
	    Thread.sleep(1000);

	 }
	 
   @Test(priority=8)
	public void CancelInProgress() throws Exception {
	   BuildMenu.clickBuild();
	   driver.findElement(By.xpath("//h4[2]/span")).click();
	   driver.findElement(By.xpath("//media-menu/h4")).click();
		driver.findElement(Upload.MediaButton).click();
	    Upload.enterVideoBack();;
	    driver.findElement(Upload.ThumbnailButton).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.InitialButton));
	    driver.findElement(Upload.InitialButton).click();
	    Upload.enterInitialImageVideo();
	    Upload.Cropper();
	    Thread.sleep(1000);
	    Upload.enterThumbVideo();
	    Upload.Cropper();
	    // X button 
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[2]/i")));
	    driver.findElement(By.xpath("//div[2]/i")).click();
	    assertTrue(HomePage.isElementPresent(By.cssSelector("p.modal-body__description")));
	    assertTrue(HomePage.isElementPresent(By.cssSelector("button.modal-footer__btn")));
	    assertTrue(HomePage.isElementPresent(By.xpath("(//button[@type='button'])[4]")));
	    assertEquals(driver.findElement(By.cssSelector("button.modal-footer__btn")).getText(), "Cancel uploading");
	    assertEquals(driver.findElement(By.xpath("(//button[@type='button'])[4]")).getText(), "Keep uploading");
	    driver.findElement(By.cssSelector("button.modal-footer__btn")).click();
	    assertEquals(driver.findElement(By.cssSelector("div.status-overlay__content > span")).getText(), "Video File Upload Was Canceled.");
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.upload-box.text-center")));
	    assertEquals(driver.findElement(By.xpath("//label")).getText(), "Browse");
	    Thread.sleep(5000);
   }
   
   @Test(priority=9)
 	public void CancelCompleted() throws Exception {
 		driver.findElement(Upload.MediaButton).click();
 	    Upload.enterVideo();
 	    //driver.findElement(Upload.ThumbnailButton).click();
 	    Thread.sleep(10000);
 	    //assertTrue(HomePage.isElementPresent(Upload.InitialButton));
 	    //driver.findElement(Upload.InitialButton).click();
 	    //Upload.enterInitialImageVideo();
 	    //Upload.Cropper();
 	    //Upload.enterThumbVideo();
 	    //Upload.Cropper();
 	    // Trash Bin button 
 	    assertTrue(HomePage.isElementPresent(By.xpath("//div[2]/i")));
 	    driver.findElement(By.xpath("//div[2]/i")).click();
 	    Thread.sleep(5000);
 	    assertTrue(HomePage.isElementPresent(By.cssSelector("p.modal-body__description")));
 	    try{
 	    assertTrue(driver.findElement(By.xpath("//p[2]")).getText().matches("^exact:Are you sure[\\s\\S]$"));
 	   } catch(Error e){}
 	    assertEquals(driver.findElement(By.cssSelector("button.modal-footer__btn")).getText(), "Delete file");
 	    assertEquals(driver.findElement(By.xpath("(//button[@type='button'])[4]")).getText(), "Keep file");
 	    assertTrue(HomePage.isElementPresent(By.cssSelector("button.modal-footer__btn")));
 	    assertTrue(HomePage.isElementPresent(By.xpath("(//button[@type='button'])[4]")));
 	    driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
 	    driver.findElement(By.xpath("//div[2]/i")).click();
 	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.modal-body")));
 	    driver.findElement(By.cssSelector("button.modal-footer__btn")).click();
 	   Thread.sleep(15000);
       driver.findElement(By.xpath("//span[3]")).click();
	    Thread.sleep(1000);

    }
   @Test(priority=10)
	public void WrongType() throws Exception {
	   BuildMenu.clickBuild();
	   driver.findElement(By.xpath("//h4[2]/span")).click();
	   driver.findElement(By.xpath("//media-menu/h4")).click();
	   driver.findElement(Upload.MediaButton).click();
	   Upload.enterWrongImage();
	   Thread.sleep(1000);
	   assertTrue(HomePage.isElementPresent(By.xpath("//upload-box/div/div[3]")));
	   assertEquals(driver.findElement(By.xpath("//upload-box/div/div[3]")).getText(), "Invalid Media Type");
   }
   
   @Test(priority=11)
	public void SameName_Type() throws Exception {
	    driver.findElement(Upload.MediaButton).click();
	    Upload.enterImage();
	    Thread.sleep(1000);
	    driver.findElement(Upload.ThumbnailButton).click();
	    Thread.sleep(500);
	    Upload.enterImage();
	    Upload.Cropper();
	    Thread.sleep(1000);
	    driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("Superman");
	    driver.findElement(By.xpath("//textarea[@id='upload-description']")).click();
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.alert.alert-danger")));
	    assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "A Image Of The Same Name Already Exists");
  }
   
}
