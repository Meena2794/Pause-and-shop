package com.pauseandshop.ecom.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishListPage {
	WebDriver driver;

	public MyWishListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//tr//th[text()='my wishlist']")
	private WebElement headertxt;
	
	@FindBy(xpath="//a[text()='SliverAnklet']")
	private WebElement myproduct;


	public WebElement getMyproduct() {
		return myproduct;
	}


	public WebElement getHeadertxt() {
		return headertxt;
	}

	public void verifyproduct() {
		myproduct.getText();
		
	}
}
