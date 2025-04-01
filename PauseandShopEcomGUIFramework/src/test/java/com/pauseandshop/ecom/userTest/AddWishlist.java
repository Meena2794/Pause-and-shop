                                                                                                                                      package com.pauseandshop.ecom.userTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.pauseandshop.ecom.baseutility.BaseClass;
import com.pauseandshop.ecom.objectrepository.utility.HomePage;
import com.pauseandshop.ecom.objectrepository.utility.MyWishListPage;
import com.pauseandshop.ecom.objectrepository.utility.UserloginPage;

@Listeners(com.pauseandshop.ecom.generic.listenerutility.listimpclass.class)
public class AddWishlist extends BaseClass {
	@Test(groups = "smokeTest")
	public void AddProduct2Wishlisht() throws Throwable, IOException {
		String URL = eLib.getDataFromExcel("UserLogin", 1, 1);
		String UN = eLib.getDataFromExcel("UserLogin", 1, 2);
		String PW = eLib.getDataFromExcel("UserLogin", 1, 3);

		String productname = eLib.getDataFromExcel("track", 4, 0);
		String Expectedwishlsttxt = eLib.getDataFromExcel("track", 7, 0);
		driver.get(URL);
//	Click on User login button
		wlib.waitForPageToLoad(driver);
		HomePage hp = new HomePage(driver);
		hp.getLoginLink().click();
//	Enter the valid user name,the valid password and click on login button
		UserloginPage ulp = new UserloginPage(driver);
		ulp.UserLogin(UN, PW);
		hp.getBookLink().click();
		hp.getSearchEdt().sendKeys(productname, Keys.ENTER);
		wlib.scrollToElementjs(hp.getProdimg(), driver);
		wlib.scrollToElementjs(hp.getWishlisticon(), driver);
		hp.getWishlistlink().click();
		MyWishListPage mwp = new MyWishListPage(driver);
		String Actwishlstprod = mwp.getHeadertxt().getText();
		System.out.println(Actwishlstprod);
		//Boolean condition1 =Expectedwishlsttxt.contains(Actwishlstprod);
		Assert.assertTrue(Expectedwishlsttxt.contains(Actwishlstprod));

		String actprod = mwp.getMyproduct().getText();
		System.out.println(actprod);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(actprod.contains(productname));
		soft.assertAll();
		Thread.sleep(2000);
		hp.logout();
	}

	@Test(groups = "regressionTest")
	public void TrackOrderTest() throws Throwable {
		String URL = eLib.getDataFromExcel("UserLogin", 1, 1);
		String UN = eLib.getDataFromExcel("UserLogin", 1, 2);
		String PW = eLib.getDataFromExcel("UserLogin", 1, 3);

		String msg = eLib.getDataFromExcel("track", 1, 0);
		// Open the brower and Enter the URL
		driver.get(URL);
		wlib.waitForPageToLoad(driver);
//	Click on User login button
		HomePage hp = new HomePage(driver);
		hp.getLoginLink().click();
//	Enter the valid user name,the valid password and click on login button
		UserloginPage ulp = new UserloginPage(driver);
		ulp.UserLogin(UN, PW);

		driver.findElement(By.xpath("//a[text()='Home']")).click();
//	CLICK ON TRACK ORDER BUTTON on top right corner
		WebElement track = hp.getTrackOrderlink();
		wlib.mouseMovementonElement(driver, track);
		track.click();
//	Enter valid ORDER ID AND EMAIL Address CLICK ON TRACK
		WebElement orderid = driver.findElement(By.xpath("//label[text()='Order ID']"));
		wlib.scrollToElementAction(driver, orderid);
//	Enter valid ORDER ID AND EMAIL Address CLICK ON TRACK
		driver.findElement(By.xpath("//input[@name='orderid']")).sendKeys("132");
		driver.findElement(By.id("exampleBillingEmail1")).sendKeys("anuj.lpu1@gmail.com");
		driver.findElement(By.xpath("//button[text()='Track']")).submit();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@href='javascript:void(0);']")).click();
		wlib.switchToTabonurl(driver, "track-order.php?oid=132");
		String actordertrackdetail = driver.findElement(By.xpath("//b[text()='Order Tracking Details !']")).getText();
		Thread.sleep(3000);
		System.out.println(actordertrackdetail);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(actordertrackdetail.trim().equals(msg));
		soft.assertAll();
		wlib.switchToTabonurl(driver, "order-details.php");
		wlib.waitForElementpresent(driver, hp.getLogoutlink());
		
	}

}
