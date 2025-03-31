package com.pauseandshop.ecom.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PendingOrderPage {
	WebDriver driver;

	public PendingOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchBtn;

	@FindAll({ @FindBy(xpath = "//a[@title='Update order')"),
			@FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody/tr/td[9]//a)") })
	private WebElement editBtn;

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

}
