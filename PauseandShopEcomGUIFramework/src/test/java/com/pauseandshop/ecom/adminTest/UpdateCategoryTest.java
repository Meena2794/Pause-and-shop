package com.pauseandshop.ecom.adminTest;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pauseandshop.ecom.baseutility.BaseClass;
import com.pauseandshop.ecom.objectrepository.utility.AdminDashboardPage;
import com.pauseandshop.ecom.objectrepository.utility.AdminLoginPage;
import com.pauseandshop.ecom.objectrepository.utility.CreateCatagorypage;
import com.pauseandshop.ecom.objectrepository.utility.HomePage;
import com.pauseandshop.ecom.objectrepository.utility.PendingOrderPage;
import com.pauseandshop.ecom.objectrepository.utility.UpdateStatusPage;

public class UpdateCategoryTest extends BaseClass {
	@Test(groups = "regressionTest")
	public  void UpdateCategoryTest() throws Throwable, IOException {
		
		String URL =eLib.getDataFromExcel("Adminlogin", 1, 1);
		String UN = eLib.getDataFromExcel("Adminlogin", 1, 2);
		String PW = eLib.getDataFromExcel("Adminlogin", 1, 3);
		
			// read test script data from Excel file
			String  categore= eLib.getDataFromExcel("category", 1, 2).toString();
			driver.get(URL);
			HomePage hp = new HomePage(driver);
			hp.getAdminLink().click();
			AdminLoginPage alp = new AdminLoginPage(driver);
			alp.adminLogin(UN, PW);
			AdminDashboardPage adp=new AdminDashboardPage(driver);
			adp.getCreateCategorylink().click();
			WebElement table = driver.findElement(By.xpath("//h3[text()='Manage Categories']"));
			wlib.mouseMovementonElement(driver, table);
		CreateCatagorypage ccp=new CreateCatagorypage(driver);
		ccp.getSearchEdt().sendKeys("Books",Keys.ENTER);
			String actcat = driver.findElement(By.xpath("//td[text()='Books']")).getText();
			Thread.sleep(3000);
			System.out.println(actcat);
			driver.findElement(By.xpath("//a[@href='edit-category.php?id=3']")).click();
			driver.findElement(By.xpath("//button[@type='submit']"));
			SoftAssert soft=new SoftAssert();
			soft.assertTrue(actcat.equals("Books"));
			soft.assertAll();
			adp.Logout();

}
	@Test(groups = "regressionTest")
	public void UpdateStatusTest() throws Throwable {
		String URL = eLib.getDataFromExcel("Adminlogin", 1, 1);
		String UN = eLib.getDataFromExcel("Adminlogin", 1, 2);
		String PW = eLib.getDataFromExcel("Adminlogin", 1, 3);

		// read test script data from Excel file

		String status = eLib.getDataFromExcel("category", 3, 1).toString();
		driver.get(URL);
		HomePage hp = new HomePage(driver);
		hp.getAdminLink().click();
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(UN, PW);
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.getOrdermanagementDDn().click();
		adp.getPendingOrdersTab().click();
		PendingOrderPage pop = new PendingOrderPage(driver);
		pop.getSearchBtn().sendKeys("novel", Keys.ENTER);
		pop.getEditBtn().click();
		UpdateStatusPage usp = new UpdateStatusPage(driver);
		usp.UpdateStatus("inprocess", "delivered in 2days");
		wlib.SwitchToAlertAndAccept(driver);
		String actstatus = driver.findElement(By.xpath("//b[text()='Update Order !']")).getText();
		System.out.println(actstatus);
		if (actstatus.equals(status)) {
			System.out.println(status + " information verified==PASS");
		} else {
			System.out.println(status + "information is not verified==FAIL");
		}
		System.out.println("======Logout======");
		adp.Logout();

	}

	}
