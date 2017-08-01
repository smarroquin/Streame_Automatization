package com.streame.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BuildMenu {
	public WebDriver driver;
	public By BuildLink = By.cssSelector("button.nav-link.build-menu-button");
	
	public BuildMenu(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickBuild() {
		WebElement buildLink = driver.findElement(BuildLink);
		if(buildLink.isDisplayed())
			buildLink.click();

	}
	
}
