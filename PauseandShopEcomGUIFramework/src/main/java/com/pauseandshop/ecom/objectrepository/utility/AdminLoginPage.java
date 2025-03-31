package com.pauseandshop.ecom.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pauseandshop.ecom.generic.webdriverutily.WebDriverUtility;

public class AdminLoginPage {

	WebDriverUtility wu = new WebDriverUtility();
	WebDriver driver;
	

	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "inputEmail")
	private WebElement usernameEdt;

	@FindBy(id = "inputPassword")
	private WebElement passwordEdt;

	@FindBy(name = "submit")
	private WebElement loginBtn;

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	// Business Action
	public void adminLogin( String USERNAME, String PASSWORD) throws InterruptedException {
		wu.waitForPageToLoad(driver);
		wu.maximizeWindow(driver);
		Thread.sleep(500);
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}

}
