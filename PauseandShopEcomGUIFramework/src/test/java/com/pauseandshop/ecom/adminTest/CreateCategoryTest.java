package com.pauseandshop.ecom.adminTest;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pauseandshop.ecom.baseutility.BaseClass;
import com.pauseandshop.ecom.objectrepository.utility.AdminDashboardPage;
import com.pauseandshop.ecom.objectrepository.utility.AdminLoginPage;
import com.pauseandshop.ecom.objectrepository.utility.CreateCatagorypage;
import com.pauseandshop.ecom.objectrepository.utility.CreateSubCategorypage;
import com.pauseandshop.ecom.objectrepository.utility.HomePage;
import com.pauseandshop.ecom.objectrepository.utility.InsertProductPage;
import com.pauseandshop.ecom.objectrepository.utility.ManageProductPage;

public class CreateCategoryTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createCategory() throws Throwable {
		String URL =eLib.getDataFromExcel("Adminlogin", 1, 1);
		String UN = eLib.getDataFromExcel("Adminlogin", 1, 2);
		String PW = eLib.getDataFromExcel("Adminlogin", 1, 3);
		
		// read test script data from Excel file
		String categore = eLib.getDataFromExcel("category", 1, 0).toString();
		String descption = eLib.getDataFromExcel("category", 1, 1).toString();
		driver.get(URL);
		HomePage hp = new HomePage(driver);
		hp.getAdminLink().click();
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(UN, PW);
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.getCreateCategorylink().click();
		CreateCatagorypage ccp = new CreateCatagorypage(driver);
		ccp.createcategory(categore, descption);
		String actcat = driver.findElement(By.xpath("//td[text()='"+categore+"']")).getText();
		System.out.println(actcat);
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(actcat.trim().equals(categore));
		soft.assertAll();
		adp.Logout();
	}
	@Test(groups = "regressionTest")
	public void createSubcategorytest() throws Throwable {
		String URL =eLib.getDataFromExcel("Adminlogin", 1, 1);
		String UN = eLib.getDataFromExcel("Adminlogin", 1, 2);
		String PW = eLib.getDataFromExcel("Adminlogin", 1, 3);
	
		
		// read test script data from Excel file
		String category = eLib.getDataFromExcel("category", 1, 0).toString();
		String subcat = eLib.getDataFromExcel("category", 1, 2).toString() + jLib.getRandomNumber();
		driver.get(URL);
		HomePage hp = new HomePage(driver);
		hp.getAdminLink().click();
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(UN, PW);
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.getSubCategorylink().click();
		CreateSubCategorypage cscp = new CreateSubCategorypage(driver);
		WebElement cat = cscp.getCateDDN();
		cat.click();
		wlib.SelectfromValue(cat, "7");
		cscp.getSubCatEdt().sendKeys(subcat);
		cscp.getCreateBtn().click();
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(subcat);
		Thread.sleep(3000);
		String actsub = driver.findElement(By.xpath("//td[text()='" + subcat + "']")).getText();
		Thread.sleep(3000);
		System.out.println(actsub);
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(actsub.trim().equals(subcat));
		soft.assertAll();
		adp.Logout();

	}
	@Test
	public void DeleteProductTest() throws Throwable {
		
		String URL =eLib.getDataFromExcel("Adminlogin", 1, 1);
		String UN = eLib.getDataFromExcel("Adminlogin", 1, 2);
		String PW = eLib.getDataFromExcel("Adminlogin", 1, 3);
		String productname = eLib.getDataFromExcel("product", 6, 0).toString();

		// return to managelog to delete
		driver.get(URL);
		HomePage hp = new HomePage(driver);
		hp.getAdminLink().click();
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(UN, PW);
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.getManageproductlink().click();
		ManageProductPage mpp=new ManageProductPage(driver);
		Thread.sleep(3000);
	  mpp.getSearEdt().sendKeys(productname);
		WebElement actprod1 = driver.findElement(By.xpath("//tr[td[text()='" + productname + "']]"));
		List<WebElement> deleteprod = actprod1.findElements(By.xpath("//i[@class='icon-remove-sign']"));
		Thread.sleep(1000);
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(!deleteprod.equals(productname));
		soft.assertAll();
		adp.Logout();
	}

	@Test(groups = "regressionTest")
	public void InsertProducttest() throws Throwable {
		String URL =eLib.getDataFromExcel("Adminlogin", 1, 1);
		String UN = eLib.getDataFromExcel("Adminlogin", 1, 2);
		String PW = eLib.getDataFromExcel("Adminlogin", 1, 3);
		// read test script data from Excel file

		String categore = eLib.getDataFromExcel("product", 4, 0).toString();
		String descption = eLib.getDataFromExcel("product", 4, 1).toString();
		String subcat = eLib.getDataFromExcel("product", 4, 2).toString();
		String InsertProduct = eLib.getDataFromExcel("product", 1, 0).toString();
		String productname = eLib.getDataFromExcel("product", 1, 2).toString();
		String productcompany = eLib.getDataFromExcel("product", 1, 3).toString();
		String productpricebefore = eLib.getDataFromExcel("product", 1, 4).toString();
		String productpriceafter = eLib.getDataFromExcel("product", 1, 5).toString();
		String ProductDescription = eLib.getDataFromExcel("product", 1, 6).toString();
		String ProductShippingCharge = eLib.getDataFromExcel("product", 1, 7).toString();
		
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		HomePage hp = new HomePage(driver);
		hp.getAdminLink().click();
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(UN, PW);
		AdminDashboardPage adp=new AdminDashboardPage(driver);
		adp.getCreateCategorylink().click();
		CreateCatagorypage ccp = new CreateCatagorypage(driver);
		ccp.createcategory(categore, descption);
		
		Thread.sleep(1000);
		adp.getSubCategorylink().click();
		CreateSubCategorypage cscp = new CreateSubCategorypage(driver);
		WebElement cat = cscp.getCateDDN();
		cat.click();
		wlib.SelectfromValue(cat, "77");
		cscp.getSubCatEdt().sendKeys(subcat);
		cscp.getCreateBtn().click();
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(subcat);
		Thread.sleep(3000);
		String actsub = driver.findElement(By.xpath("//td[text()='" + subcat + "']")).getText();
		Thread.sleep(3000);
		System.out.println(actsub);
		if (actsub.equals(subcat)) {
			System.out.println(subcat + " information verified==PASS");
		} else {
			System.out.println(subcat + "information is not verified==FAIL");
		}
		Thread.sleep(3000);
		// insert product
		adp.getInsertProductlink().click();
		Thread.sleep(1000);
		InsertProductPage ipp = new InsertProductPage(driver);
		WebElement dDNCat = ipp.getCateDDn();
		Thread.sleep(500);
		wlib.SelectfromText(dDNCat,categore );
		Thread.sleep(1000);
		WebElement dDnSub = ipp.getSubCateDD();
		dDnSub.click();
		wlib.SelectfromText(dDnSub, subcat);
		Thread.sleep(2000);
		WebElement pd = ipp.getProductNameEDT();
		pd.sendKeys(productname);
		System.out.println(pd.getText());
		ipp.getCompanyEDT().sendKeys(productcompany);
		Thread.sleep(500);
		ipp.getPricebdEDT().sendKeys(productcompany);
		Thread.sleep(500);
		ipp.getPricebdEDT().sendKeys(productpricebefore);
		Thread.sleep(500);
		ipp.getPriceafEDT().sendKeys(productpriceafter);
		Thread.sleep(500);
		ipp.getProductDesc().sendKeys(ProductDescription);
		Thread.sleep(500);
		ipp.getShippingchargeEDT().sendKeys(ProductShippingCharge);
		Thread.sleep(500);
		WebElement productavailable = ipp.getAvailabilityDDn();
		productavailable.click();
		wlib.SelectfromValue(productavailable, "In Stock");
		Thread.sleep(2000);
		WebElement choosefile1 = ipp.getImg();
		Thread.sleep(1000);
		File fileupload = new File(
				".\\src\\test\\resources\\Img\\anklet.jpeg");
		choosefile1.sendKeys(fileupload.getAbsolutePath());
		WebElement choosefile2 = ipp.getImg2();
		File fileupload2 = new File(
				".\\src\\test\\resources\\Img\\anklet3.jpeg");
		choosefile2.sendKeys(fileupload.getAbsolutePath());

//upload
		WebElement choosefile3 =ipp.getImg3(); 
		File fileupload3 = new File(
				".\\src\\test\\resources\\Img\\anklet3.jpeg");
		choosefile3.sendKeys(fileupload.getAbsolutePath());
		// save
		ipp.getInsertBtn().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
//go to managelog
		adp.getManageproductlink().click();
		ManageProductPage mpp=new ManageProductPage(driver);
		WebElement search = mpp.getSearEdt();
		search.sendKeys(productname);
		Thread.sleep(1000);
		String actprod = driver.findElement(By.xpath("//td[text()='" + productname + "']")).getText();
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(actprod.trim().equals(productname));
		soft.assertAll();
	}
}