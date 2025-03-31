package com.pauseandshop.ecom.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsertProductPage {

//	WebDriver driver;

	public InsertProductPage(WebDriver driver) {
//		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//select[@class='span8 tip'])[1]")
	private WebElement cateDDn;

	@FindBy(xpath = "//select[@id='subcategory']")
	private WebElement subCateDD;

	@FindBy(name = "productName")
	private WebElement productNameEDT;

	@FindBy(name = "productCompany")
	private WebElement CompanyEDT;

	@FindBy(name = "productpricebd")
	private WebElement pricebdEDT;
	
	@FindBy(name="productprice")
	private WebElement priceafEDT;		

	@FindBy(xpath = "//div[@class=' nicEdit-main']")
	private WebElement productDesc;

	@FindBy(name = "productShippingcharge")
	private WebElement ShippingchargeEDT;

	@FindBy(id = "productAvailability")
	private WebElement AvailabilityDDn;

	@FindBy(xpath = "//input[@id='productimage1']")
	private WebElement img;

	@FindBy(name = "productimage2")
	private WebElement img2;

	@FindBy(name = "productimage3")
	private WebElement img3;

	@FindBy(xpath = "//button[@class='btn']")
	private WebElement insertBtn;
	

	public WebElement getCateDDn() {
		return cateDDn;
	}

	public WebElement getSubCateDD() {
		return subCateDD;
	}

	public WebElement getProductNameEDT() {
		return productNameEDT;
	}

	public WebElement getCompanyEDT() {
		return CompanyEDT;
	}

	public WebElement getPricebdEDT() {
		return pricebdEDT;
	}

	public WebElement getPriceafEDT() {
		return priceafEDT;
	}
	public WebElement getProductDesc() {
		return productDesc;
	}

	public WebElement getShippingchargeEDT() {
		return ShippingchargeEDT;
	}

	public WebElement getAvailabilityDDn() {
		return AvailabilityDDn;
	}

	public WebElement getImg() {
		return img;
	}

	public WebElement getImg2() {
		return img2;
	}

	public WebElement getImg3() {
		return img3;
	}

	public WebElement getInsertBtn() {
		return insertBtn;
	}

}
