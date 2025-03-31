package com.pauseandshop.ecom.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pauseandshop.ecom.generic.webdriverutily.WebDriverUtility;

public class UpdateStatusPage {
	WebDriverUtility wu= new WebDriverUtility();
	WebDriver driver;

	public UpdateStatusPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//[@id=\"updateticket\"]/table/tbody/tr[2]/td[2]")
	private WebElement orderId;
	
	@FindBy(xpath="//form[@id='updateticket']/table/tbody/tr[3]/td[2]/span/select")
	private WebElement statusDDn;
	
	@FindBy(xpath="//form[@id=\"updateticket\"]/table/tbody/tr[4]/td[2]/span/textarea")
	private WebElement remarkEdt;
	
	@FindBy(xpath="//input[@value='update']")
	private WebElement updateBtn;
	
	@FindBy(xpath="//input[@value='Close this Window ']")
	private WebElement closethisWindowBtn;

	public WebElement getOrderId() {
		return orderId;
	}

	public WebElement getStatusDDn() {
		return statusDDn;
	}

	public WebElement getRemarkEdt() {
		return remarkEdt;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public WebElement getClosethisWindowBtn() {
		return closethisWindowBtn;
	}
	
	public void UpdateStatus(String inProcess, String desc ) {
		wu.SelectfromValue(statusDDn, inProcess);
		remarkEdt.sendKeys(desc);
		updateBtn.click();
	}
}
