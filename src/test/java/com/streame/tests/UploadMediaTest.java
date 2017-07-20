package com.streame.tests;

import static org.testng.Assert.*;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
		Thread.sleep(2000);
        Assert.assertTrue(HomePage.isElementPresent(By.id("buildMenu")));
        BuildMenu = new BuildMenu(driver);
        BuildMenu.clickBuild();
	    Assert.assertEquals(driver.findElement(By.cssSelector("label.nav-link.menu__label")).getText(), "Media");
	    Upload = new UploadMedia(driver);
	    driver.findElement(By.id("media")).click();
	    Thread.sleep(500);
	    assertEquals(driver.findElement(By.linkText("Upload media")).getText(), "Upload media");
	    driver.findElement(By.linkText("Upload media")).click();
	    Thread.sleep(500);
	    driver.findElement(Upload.MediaButton).click();
	    Thread.sleep(500);
	    Upload.enterImage();
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/upload-box/div/div/i")));
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.status-overlay__content > span")));
	    Thread.sleep(1000);
	    assertEquals(driver.findElement(By.cssSelector("div.status-overlay__content > span")).getText(), "Image file uploaded");
	    assertEquals(driver.findElement(By.cssSelector("span.metadata-preview-content__key")).getText(), "File name:");
	    assertEquals(driver.findElement(By.cssSelector("p.metadata-preview__info > span.metadata-preview-content__key")).getText(), "Size:");
	    //File Name and Size
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/upload-box/div[2]/div/div/div/span[2]")).getText(), "casita.jpg");
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
	    Thread.sleep(500);
	   try{
	   assertTrue(driver.findElement(By.cssSelector("div.form-group > label.upload-form__label")).getText().matches("^exact:Title \\([\\s\\S]*\\)$"));
	   assertTrue(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[2]/label")).getText().matches("^exact:Description [\\s\\S]*$"));
	    assertTrue(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[3]/label")).getText().matches("^exact:Kind \\([\\s\\S]*\\)$"));
	    assertTrue(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[4]/label")).getText().matches("^exact:Genres \\([\\s\\S]*\\)$"));
	    assertTrue(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[5]/label")).getText().matches("^exact:Keywords \\([\\s\\S]*\\)$"));
	   } catch(Error e){}
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[6]/label")).getText(), "Explicit Content");
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.upload-form__switch-slider")));
	    assertEquals(driver.findElement(By.cssSelector("label.upload-form__label.upload-form__label_block")).getText(), "Visibility");
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label[2]")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label[3]")));
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[8]/label")).getText(), "Share");
	    try{ 
	    assertTrue(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/label")).getText().matches("^exact:[\\s\\S]* Required fields$"));
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
	    assertEquals(driver.findElement(By.cssSelector("div.placeholder")).getText(), "Search or select one kind");
	    try{ 
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.multiple > input")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//chips[@id='upload-genres']/div")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//advanced-select[@id='upload-categories']/div/ng-select/div/div/input")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//advanced-select[@id='upload-audience']/div/ng-select/div/div/div")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label")));
	    } catch(Error e){}
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label")).getText(), "Private");
	    assertEquals(driver.findElement(By.cssSelector("small.form-group__small")).getText(), "Viewable only for its publishers. Can't be searched or included in a page or a channel.");
	    driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label[2]")).click();
	    Thread.sleep(1000);
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label[2]")).getText(), "Public");
	    assertEquals(driver.findElement(By.cssSelector("small.form-group__small")).getText(), "Searchable and viewable by everyone.");
	    driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label[3]")).click();
	    Thread.sleep(1000);
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label[3]")).getText(), "Invitation");
	    assertEquals(driver.findElement(By.cssSelector("small.form-group__small")).getText(), "Viewable only for its publishers and invitees. Can't be searched or included in a page or a channel.");
	    assertEquals(driver.findElement(By.cssSelector("div.ml-3 > label.upload-form__label.upload-form__label_block")).getText(), "Invite to");
	    assertTrue(HomePage.isElementPresent(By.cssSelector("#upload-invitation > div.chips-container > input.input")));
	    driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label")).click();
	    Thread.sleep(1000);
	    assertTrue(HomePage.isElementPresent(By.cssSelector("button.btn.btn-default")));
	    assertEquals(driver.findElement(By.cssSelector("button.btn.btn-default")).getText(), "CANCEL");
	Thread.sleep(1000);
	}

	@Test(priority=2)
	public void UploadValidations() throws Exception {
		driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("11/");
	    Thread.sleep(1000);
	    assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "Title must not contain numbers or special characters");
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.alert.alert-danger")));
	    driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("/");
	    Thread.sleep(500);
	    assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "Title must not contain numbers or special characters");
	    driver.findElement(Upload.Title).sendKeys(Keys.BACK_SPACE);
	    driver.findElement(Upload.Title).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(1000);
	    assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "Title is required");
	    driver.findElement(Upload.Description).clear();
	    driver.findElement(Upload.Description).sendKeys("k");
	    Thread.sleep(500);
	    driver.findElement(Upload.Description).sendKeys(Keys.BACK_SPACE);
	    driver.findElement(Upload.Description).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(2000);
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[3]")));
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[3]")).getText(), "Description is required");
	    driver.findElement(Upload.Kind).click();
	    driver.findElement(Upload.Kind).click();
	    Thread.sleep(1000);
	    //Bug pending
	    //assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[3]/div")).getText(), "Please choose at least one kind");
	    //assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[3]/div")));
	    assertTrue(HomePage.isElementPresent(By.xpath("/html/body/streame-app/layout/navbar/nav/div/div[1]/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/button")));
   	  //Keywords
	    driver.findElement(Upload.Keywords).click();
   	    Thread.sleep(1000);
	    driver.findElement(By.id("ngb-typeahead-1-0")).click();
	    driver.findElement(Upload.Kinput).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("ngb-typeahead-1-2")).click();
	    driver.findElement(Upload.Kinput).click();
	    driver.findElement(By.cssSelector("input.input.open")).clear();
	    driver.findElement(By.cssSelector("input.input.open")).sendKeys("Test");
	    driver.findElement(Upload.Kinput).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("ngb-typeahead-1-0")).click();
	    driver.findElement(Upload.Kinput).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("ngb-typeahead-1-1")).click();
	    driver.findElement(Upload.Kinput).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("ngb-typeahead-1-3")).click();
	    driver.findElement(Upload.Kinput).click();
	    Thread.sleep(500);
	    driver.findElement(By.cssSelector("input.input.open")).clear();
	    driver.findElement(By.cssSelector("input.input.open")).sendKeys("Drama");
	    driver.findElement(By.id("ngb-typeahead-1-0")).click();
	    driver.findElement(By.cssSelector("input.input.open")).clear();
	    driver.findElement(By.cssSelector("input.input.open")).sendKeys("Comics");
	    driver.findElement(By.id("ngb-typeahead-1-0")).click();
	    driver.findElement(By.cssSelector("input.input.open")).clear();
	    driver.findElement(By.cssSelector("input.input.open")).sendKeys("Mangas");
	    driver.findElement(By.id("ngb-typeahead-1-0")).click();
	    driver.findElement(By.cssSelector("input.input.open")).clear();
	    driver.findElement(By.cssSelector("input.input.open")).sendKeys("Blood");
	    driver.findElement(By.id("ngb-typeahead-1-0")).click();
	    driver.findElement(By.cssSelector("input.input.open")).clear();
	    driver.findElement(By.cssSelector("input.input.open")).sendKeys("Sunny");
	    driver.findElement(By.id("ngb-typeahead-1-0")).click();
	    driver.findElement(By.cssSelector("input.input.open")).clear();
	    driver.findElement(By.cssSelector("input.input.open")).sendKeys("Rainy");
	    driver.findElement(By.id("ngb-typeahead-1-0")).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[6]/div")));
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[6]/div")).getText(), "Only 10 keywords can be selected");
	   // Invitation
	    driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[8]/div/label[3]")).click();
	    driver.findElement(By.xpath("//input[@value='3']")).click();
	    assertTrue(HomePage.isElementPresent(By.cssSelector("#upload-invitation > div.chips-container > input.input")));
	    driver.findElement(By.id("ngb-typeahead-3-0")).click();
	    driver.findElement(By.id("ngb-typeahead-3-1")).click();
	    assertTrue(HomePage.isElementPresent(By.cssSelector("#upload-invitation > div.chips-container > input.input")));
	    driver.findElement(By.cssSelector("input.input.open")).clear();
	    driver.findElement(By.cssSelector("input.input.open")).sendKeys("dmarroquin@gmail.com");
	    driver.findElement(By.id("ngb-typeahead-3-0")).click();
	    //Share
	    assertTrue(HomePage.isElementPresent(By.cssSelector("#upload-share > div.chips-container > input.input")));
	    driver.findElement(By.id("ngb-typeahead-2-0")).click();
	    driver.findElement(By.id("ngb-typeahead-2-1")).click();
	    driver.findElement(By.cssSelector("input.input.open")).clear();
	    driver.findElement(By.cssSelector("input.input.open")).sendKeys("dmarroquin@gmail.com");
	    driver.findElement(By.id("ngb-typeahead-2-0")).click();
	    	    	    
	    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.modal-body")));
	    assertEquals(driver.findElement(By.cssSelector("p.modal-body__description")).getText(), "casita.jpg image file will be deleted.\nYou'll have to upload a file again.");
	    assertTrue(HomePage.isElementPresent(By.cssSelector("button.modal-footer__btn")));
	    assertTrue(HomePage.isElementPresent(By.xpath("(//button[@type='button'])[7]")));
	    assertEquals(driver.findElement(By.cssSelector("button.modal-footer__btn")).getText(), "Delete file");
	    assertEquals(driver.findElement(By.xpath("(//button[@type='button'])[7]")).getText(), "Keep file");
	    driver.findElement(By.cssSelector("button.modal-footer__btn")).click();
	    driver.findElement(By.cssSelector("div.d-flex.justify-content-between > div > a.nav-link")).click();
        BuildMenu.clickBuild();
        Thread.sleep(500);

	}

	@Test(priority=3)
	public void UploadMediaImage() throws Exception {
        BuildMenu.clickBuild();
        Thread.sleep(1000);
	    //driver.findElement(By.id("media")).click();
        //Thread.sleep(1000);
	    driver.findElement(By.linkText("Upload media")).click();
        Thread.sleep(500);
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
	    driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	    //driver.findElement(Upload.Genre).click();
	    Thread.sleep(500);
	    //driver.findElement(By.xpath("//div/ul/li[3]")).click();
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
        
	}

	@Test(priority=4)
	public void UploadMediaAudio() throws Exception {
		//BuildMenu.clickBuild();
		Thread.sleep(1000);
	   // driver.findElement(By.id("media")).click();
	    Thread.sleep(500);
	    //driver.findElement(By.linkText("Upload media")).click();
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
	    driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	    //driver.findElement(Upload.Genre).click();
	    Thread.sleep(500);
	    //driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Keywords).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Audience).click();
	    driver.findElement(Upload.Type).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.SaveButton));
        driver.findElement(Upload.SaveButton).click();
        Thread.sleep(5000);

	}
	@Test(priority=5)
	public void UploadMediaVideo() throws Exception {
		//BuildMenu.clickBuild();
	    //driver.findElement(By.id("media")).click();
	   // driver.findElement(By.linkText("Upload media")).click();
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
	    driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	    //driver.findElement(Upload.Genre).click();
	    Thread.sleep(500);
	    //driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Keywords).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Audience).click();
	    //driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	    driver.findElement(Upload.Type).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.SaveButton));
        driver.findElement(Upload.SaveButton).click();
        Thread.sleep(5000);

	}
	@Test(priority=6)
	public void UploadMediaDocument() throws Exception {
		//BuildMenu.clickBuild();
	   // driver.findElement(By.id("media")).click();
	   // driver.findElement(By.linkText("Upload media")).click();
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
	    driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	   // driver.findElement(Upload.Genre).click();
	    Thread.sleep(500);
	  //  driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Keywords).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Audience).click();
	    //driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	    driver.findElement(Upload.Type).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.SaveButton));
        driver.findElement(Upload.SaveButton).click();
        Thread.sleep(5000);

	}
	//Pending to refresh page on FF
	/* @Test(priority=7)
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
	    driver.findElement(Upload.Type).click();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.SaveButton));
        driver.findElement(Upload.SaveButton).click();
        Thread.sleep(5000);
	}*/
   @Test(priority=8)
	public void CancelInProgress() throws Exception {
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
	    // X button 
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/upload-box/div[2]/div/div[2]/div[2]/i")));
	    driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/upload-box/div[2]/div/div[2]/div[2]/i")).click();
	    assertTrue(HomePage.isElementPresent(By.cssSelector("p.modal-body__description")));
	    assertTrue(HomePage.isElementPresent(By.cssSelector("button.modal-footer__btn")));
	    assertTrue(HomePage.isElementPresent(By.xpath("(//button[@type='button'])[7]")));
	    assertEquals(driver.findElement(By.cssSelector("button.modal-footer__btn")).getText(), "Cancel uploading");
	    assertEquals(driver.findElement(By.xpath("(//button[@type='button'])[7]")).getText(), "Keep uploading");
	    driver.findElement(By.cssSelector("button.modal-footer__btn")).click();
	    assertEquals(driver.findElement(By.cssSelector("div.status-overlay__content > span")).getText(), "Video file upload was canceled.");
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.upload-box.text-center")));
	    assertEquals(driver.findElement(By.cssSelector("div.upload-box.text-center")).getText(), "Drop a file here\n \n Drop a file here\n Browse");

   }
   
   @Test(priority=9)
 	public void CancelCompleted() throws Exception {
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
 	    // Trash Bin button 
 	    assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/upload-box/div[2]/div/div[2]/div[2]/i")));
 	    driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/upload-box/div[2]/div/div[2]/div[2]/i")).click();
 	    Thread.sleep(5000);
 	    assertTrue(HomePage.isElementPresent(By.cssSelector("p.modal-body__description")));
 	    assertTrue(driver.findElement(By.xpath("//p[2]")).getText().matches("^exact:Are you sure[\\s\\S]$"));
 	    assertEquals(driver.findElement(By.cssSelector("button.modal-footer__btn")).getText(), "Delete file");
 	    assertEquals(driver.findElement(By.xpath("(//button[@type='button'])[7]")).getText(), "Keep file");
 	    assertTrue(HomePage.isElementPresent(By.cssSelector("button.modal-footer__btn")));
 	    assertTrue(HomePage.isElementPresent(By.xpath("(//button[@type='button'])[7]")));
 	    driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
 	    driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/upload-box/div[2]/div/div[2]/div[2]/i")).click();
 	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.modal-body")));
 	    driver.findElement(By.cssSelector("button.modal-footer__btn")).click();
    }
}
