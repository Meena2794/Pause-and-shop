package com.pauseandshop.ecom.objectrepository.utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pauseandshop.ecom.generic.webdriverutily.WebDriverUtility;

public class ManageProductPage {
	WebDriverUtility wu = new WebDriverUtility();

//	WebDriver driver;

	public ManageProductPage(WebDriver driver) {
//		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
		private WebElement searEdt;

		public WebElement getSearEdt() {
			return searEdt;
		}
		
	
}
