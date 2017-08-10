package com.streame.pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.streame.base.Setup;

public class ChannelPage  extends Setup{
	public WebDriver driver;
	public By createLink = By.xpath("//channel-menu/h4");
	public By slug = By.id("title");
	
	public ChannelPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String RandomNumber(int length){
	    return RandomStringUtils.randomNumeric(length);
	} 
}
