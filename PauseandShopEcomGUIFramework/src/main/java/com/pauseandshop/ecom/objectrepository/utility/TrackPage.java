package com.pauseandshop.ecom.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pauseandshop.ecom.generic.webdriverutily.WebDriverUtility;

public class TrackPage {
	WebDriverUtility wu = new WebDriverUtility();

	WebDriver driver;

	public TrackPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[text()='Order ID']")
	private WebElement orderidfield;
	
	@FindBy(xpath="//input[@name='orderid']")
	private WebElement orderIdEdt;	
}
