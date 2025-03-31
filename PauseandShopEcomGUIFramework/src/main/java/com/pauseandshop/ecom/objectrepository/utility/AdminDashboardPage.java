package com.pauseandshop.ecom.objectrepository.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pauseandshop.ecom.generic.webdriverutily.WebDriverUtility;

public class AdminDashboardPage {

	WebDriverUtility wu = new WebDriverUtility();

	WebDriver driver;

	public AdminDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='category.php']")
	private WebElement createCategorylink;

	@FindBy(xpath = "//a[@href='subcategory.php']")
	private WebElement subCategorylink;

	@FindBy(xpath = "//a[text()='Insert Product ']")
	private WebElement insertProductlink;

	@FindBy(xpath = "//img[@src='images/user.png']")
	private WebElement adminImg;

	@FindBy(linkText = "Logout")
	private WebElement logoutLink;

	@FindBy(xpath = "//div[2]/div/div/div[1]/div/ul[1]/li[1]/a")
	private WebElement ordermanagementDDn;
	
	@FindBy(xpath="//a[@href='pending-orders.php']")
	private WebElement pendingOrdersTab;
	
	@FindBy(xpath="//a[@href='manage-products.php']")
	private WebElement manageproductlink;
	
	public WebElement getOrdermanagementDDn() {
		return ordermanagementDDn;
	}

	public WebElement getPendingOrdersTab() {
		return pendingOrdersTab;
	}

	public WebElement getManageproductlink() {
		return manageproductlink;
	}

	public WebElement getCreateCategorylink() {
		return createCategorylink;
	}

	public WebElement getSubCategorylink() {
		return subCategorylink;
	}

	public WebElement getInsertProductlink() {
		return insertProductlink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	//Business  Action
	public void Logout() {
		wu.mouseMovementonElement(driver, adminImg);
		logoutLink.click();

	}
	public void UpdateOrder() {
		ordermanagementDDn.click();
		pendingOrdersTab.click();
	}

}
