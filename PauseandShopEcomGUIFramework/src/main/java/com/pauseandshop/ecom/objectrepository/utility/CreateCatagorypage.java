package com.pauseandshop.ecom.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCatagorypage {

	WebDriver driver;

	public CreateCatagorypage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "category")
	private WebElement categoryNameEdt;

	@FindBy(name = "description")
	private WebElement descriptionEdt;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement creatBtn;
	
	@FindBy(xpath="//div[@id='DataTables_Table_0_filter']/label/input")
	private WebElement searchEdt;
	
	@FindBy(xpath="//h3[text()='Manage Categories']")
	private WebElement table;
	
	public WebElement getTable() {
		return table;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getCategoryNameEdt() {
		return categoryNameEdt;
	}

	public WebElement getDescriptionEdt() {
		return descriptionEdt;
	}

	public WebElement getCreatBtn() {
		return creatBtn;
	}

//Business  Action
	public void createcategory(String cateName, String desc) {
		categoryNameEdt.sendKeys(cateName);
		descriptionEdt.sendKeys(desc);
		creatBtn.click();
	}

	
}
