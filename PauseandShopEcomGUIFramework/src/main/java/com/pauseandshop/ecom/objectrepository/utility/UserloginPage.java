package com.pauseandshop.ecom.objectrepository.utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pauseandshop.ecom.generic.webdriverutily.WebDriverUtility;

public class UserloginPage {
	
	WebDriverUtility wu = new WebDriverUtility();
	WebDriver driver;
	

	public UserloginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="email")
	private WebElement usernameEdt;

	@FindBy(name="password")
	private WebElement passwordEdt;


	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	
//	 Business Action
		public void UserLogin( String USERNAME, String PASSWORD) throws InterruptedException {
			wu.waitForPageToLoad(driver);
			wu.maximizeWindow(driver);
			Thread.sleep(500);
			usernameEdt.sendKeys(USERNAME);
			passwordEdt.sendKeys(PASSWORD,Keys.ENTER);
		}

}
