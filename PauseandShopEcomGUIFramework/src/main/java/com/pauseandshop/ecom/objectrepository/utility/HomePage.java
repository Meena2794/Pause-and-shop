package com.pauseandshop.ecom.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pauseandshop.ecom.generic.webdriverutily.WebDriverUtility;

public class HomePage {
	WebDriverUtility wu=new WebDriverUtility();
	WebDriver driver;

	public HomePage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Admin Login']") 
	private WebElement adminLink;

	
	@FindBy(xpath = "//a[@href='login.php']")
	private WebElement loginLink;
	
	
	@FindBy(xpath="//div[@id='mc-horizontal-menu-collapse']/div/ul/li[2]/a")
	private WebElement BookLink;
	
	@FindBy(xpath="//div[@class='favorite-button m-t-10']/a[@class='btn btn-primary']")
	private WebElement wishlisticon ;

	@FindBy(xpath="//input[@class='search-field']")
	private WebElement searchEdt;
	
	@FindBy(xpath="//a[@href='product-details.php?pid=33']")
	private WebElement prodimg;
	
	@FindBy(xpath="//li//a[@href='my-wishlist.php']")
	private WebElement wishlistlink;
	
	@FindBy(xpath="//li//a[@href='logout.php']")
	private WebElement logoutlink;
	
	@FindBy(xpath="//span[text()='Track Order']")
	private WebElement  trackOrderlink;

	public WebElement getTrackOrderlink() {
		return trackOrderlink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}

	public WebElement getWishlistlink() {
		return wishlistlink;
	}

	public WebElement getProdimg() {
		return prodimg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getAdminLink() {
		return adminLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}
	
	public WebElement getBookLink() {
		return BookLink;
	}
	
	

	public WebElement getWishlisticon() {
		return wishlisticon;
	}
	
	public void logout() {
		wu.scrollToElementjs(logoutlink, driver);
		logoutlink.click();
	}


}
