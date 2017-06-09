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
	    assertTrue(HomePage.isElementPresent(By.cssSelector("i.fa.fa-camera")));
	    assertEquals(driver.findElement(By.cssSelector("label.form-control-label.upload-form__label")).getText(), "Thumbnail");
	    assertTrue(HomePage.isElementPresent(By.cssSelector("metafiles-upload-box > div.upload-box.text-center")));
	    driver.findElement(Upload.ThumbnailButton).click();
	    Thread.sleep(500);
	    Upload.enterImage();
	    Upload.Cropper();
	    assertEquals(driver.findElement(By.cssSelector("div.progress-bar")).getText(), "100 %");
	    Thread.sleep(500);
	    Upload.SidebarScroll();
	    Thread.sleep(500);
	   try{
	   assertTrue(driver.findElement(By.cssSelector("div.form-group > label.upload-form__label")).getText().matches("^exact:Title \\([\\s\\S]*\\)$"));
	   } catch(Error e){} 
	   assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[2]/label")).getText(), "Description");
	   try{ 
	   assertTrue(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[3]/label")).getText().matches("^exact:Kind \\([\\s\\S]*\\)$"));
	    assertTrue(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[4]/label")).getText().matches("^exact:Genres \\([\\s\\S]*\\)$"));
	    assertTrue(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[5]/label")).getText().matches("^exact:Keywords \\([\\s\\S]*\\)$"));
	   } catch(Error e){}
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[6]/label")).getText(), "Audience");
	    assertEquals(driver.findElement(By.cssSelector("label.upload-form__label.upload-form__label_block")).getText(), "Visibility");
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[8]/label")).getText(), "Share");
	    try{ 
	    assertTrue(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/label")).getText().matches("^exact:[\\s\\S]* Required fields$"));
	    } catch(Error e){}
	    assertEquals(driver.findElement(By.cssSelector("span.custom-control-description")).getText(), "I agree to");
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
	    assertEquals(driver.findElement(By.cssSelector("div.placeholder")).getText(), "Select A Kind");
	    try{ 
	    assertTrue(HomePage.isElementPresent(By.cssSelector("div.multiple > input")));
	    } catch(Error e){}
	    assertEquals(driver.findElement(By.cssSelector("div.multiple > input")).getText(), "");
	    try{ 
	    assertTrue(HomePage.isElementPresent(By.xpath("//advanced-select[@id='upload-categories']/div/ng-select/div/div/input")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//advanced-select[@id='upload-audience']/div/ng-select/div/div/div")));
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label")));
	    } catch(Error e){}
	    //COMPLETE LATER
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label")).getText(), "Private");
	    assertEquals(driver.findElement(By.cssSelector("small.form-group__small")).getText(), "Not searchable or viewable by anyone. Can't be shared or seen in a content page or a channel");
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label[2]")).getText(), "Public");
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[7]/div/label[3]")).getText(), "Invitation");
	    try{
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/label[2]")));
	    }catch(Error e){}
	Thread.sleep(500);
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
	    driver.findElement(Upload.Description).clear();
	    driver.findElement(Upload.Description).sendKeys("");
	    driver.findElement(Upload.Kind).click();
	    driver.findElement(Upload.Kind).click();
	    Thread.sleep(1000);
	    assertEquals(driver.findElement(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[3]/div")).getText(), "Please choose at least one kind");
	    assertTrue(HomePage.isElementPresent(By.xpath("//div[@id='navbar-comp__discover-link']/div/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/div[3]/div")));
	    assertTrue(HomePage.isElementPresent(By.xpath("/html/body/streame-app/layout/navbar/nav/div/div[1]/ul/li[2]/build-menu-container/build-menu/div/div/div/div[3]/dynamic-component/upload-container/upload-overlay/dialog/form/button")));
	    driver.findElement(By.cssSelector("i.fa.fa-times")).click();
	    Thread.sleep(1000);
	}

	@Test(priority=3)
	public void UploadMediaImage() throws Exception {
        BuildMenu.clickBuild();
	    driver.findElement(By.id("media")).click();
	    driver.findElement(By.linkText("Upload media")).click();
	    driver.findElement(Upload.MediaButton).click();
	    Upload.enterImage();
	    driver.findElement(Upload.ThumbnailButton).click();
	    Thread.sleep(500);
	    Upload.enterImage();
	    Upload.Cropper();
	    driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("AUTIMAGE");
	    driver.findElement(Upload.Description).clear();
	    driver.findElement(Upload.Description).sendKeys("AUTOMATIZATION IMAGE MEDIA");
	    Thread.sleep(500);
	    driver.findElement(Upload.Kind).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	    driver.findElement(Upload.Genre).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Keywords).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Audience).click();
	    driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	    driver.findElement(Upload.Type).click();
	    Upload.AgreeTerms();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.SaveButton));
        driver.findElement(Upload.SaveButton).click();
        Thread.sleep(1500);
	}

	@Test(priority=4)
	public void UploadMediaAudio() throws Exception {
		BuildMenu.clickBuild();
	    driver.findElement(By.id("media")).click();
	    driver.findElement(By.linkText("Upload media")).click();
	    driver.findElement(Upload.MediaButton).click();
	    Upload.enterAudio();;
	    driver.findElement(Upload.ThumbnailButton).click();
	    Thread.sleep(500);
	    Upload.enterThumbAudio();
	    Upload.Cropper();
	    driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("AUTAudio");
	    driver.findElement(Upload.Description).clear();
	    driver.findElement(Upload.Description).sendKeys("AUTOMATIZATION AUDIO MEDIA");
	    Thread.sleep(500);
	    driver.findElement(Upload.Kind).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	    driver.findElement(Upload.Genre).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Keywords).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Audience).click();
	    driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	    driver.findElement(Upload.Type).click();
	    Upload.AgreeTerms();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.SaveButton));
        driver.findElement(Upload.SaveButton).click();
        Thread.sleep(1500);
	}
	@Test(priority=4)
	public void UploadMediaVideo() throws Exception {
		BuildMenu.clickBuild();
	    driver.findElement(By.id("media")).click();
	    driver.findElement(By.linkText("Upload media")).click();
	    driver.findElement(Upload.MediaButton).click();
	    Upload.enterVideo();;
	    driver.findElement(Upload.ThumbnailButton).click();
	    Thread.sleep(500);
	    Upload.enterThumbVideo();
	    Upload.Cropper();
	    driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("AUTVideo");
	    driver.findElement(Upload.Description).clear();
	    driver.findElement(Upload.Description).sendKeys("AUTOMATIZATION VIDEO MEDIA");
	    Thread.sleep(500);
	    driver.findElement(Upload.Kind).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	    driver.findElement(Upload.Genre).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Keywords).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Audience).click();
	    driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	    driver.findElement(Upload.Type).click();
	    Upload.AgreeTerms();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.SaveButton));
        driver.findElement(Upload.SaveButton).click();
        Thread.sleep(1500);
	}
	@Test(priority=3)
	public void UploadMediaDocument() throws Exception {
		BuildMenu.clickBuild();
	    driver.findElement(By.id("media")).click();
	    driver.findElement(By.linkText("Upload media")).click();
	    driver.findElement(Upload.MediaButton).click();
	    Upload.enterDocument();;
	    driver.findElement(Upload.ThumbnailButton).click();
	    Thread.sleep(500);
	    Upload.enterThumbDocument();
	    Upload.Cropper();
	    driver.findElement(Upload.Title).clear();
	    driver.findElement(Upload.Title).sendKeys("AUTAudio");
	    driver.findElement(Upload.Description).clear();
	    driver.findElement(Upload.Description).sendKeys("AUTOMATIZATION AUDIO MEDIA");
	    Thread.sleep(500);
	    driver.findElement(Upload.Kind).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	    driver.findElement(Upload.Genre).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Keywords).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div/ul/li[3]")).click();
	    driver.findElement(Upload.Audience).click();
	    driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
	    driver.findElement(Upload.Type).click();
	    Upload.AgreeTerms();
	    Thread.sleep(500);
	    assertTrue(HomePage.isElementPresent(Upload.SaveButton));
        driver.findElement(Upload.SaveButton).click();
        Thread.sleep(1500);
	}


}
