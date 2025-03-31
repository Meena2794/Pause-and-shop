package com.pauseandshop.ecom.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pauseandshop.ecom.generic.webdriverutily.WebDriverUtility;

public class CreateSubCategorypage {
	WebDriverUtility wu=new WebDriverUtility();
//	WebDriver driver;
	public  CreateSubCategorypage(WebDriver driver) {
//		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//select[@name='category']")
	private WebElement cateDDN;
	 
	@FindBy(xpath="//input[@class='span8 tip']")
	private WebElement subCatEdt;
	
	@FindBy(xpath="//button[@class='btn']")
	private WebElement createBtn;
	
	
	public WebElement getCateDDN() {
		return cateDDN;
	}

	public WebElement getSubCatEdt() {
		return subCatEdt;
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}
	//Business  Action
	public void createSubCategory(String category,String subcategory) throws InterruptedException {

		wu.SelectfromValue(cateDDN, category);
		subCatEdt.sendKeys(subcategory);
		createBtn.click();
	}
}
