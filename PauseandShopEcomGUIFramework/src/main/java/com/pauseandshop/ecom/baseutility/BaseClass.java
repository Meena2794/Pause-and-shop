package com.pauseandshop.ecom.baseutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.pauseandshop.ecom.generic.databaseutility.DataBaseUtility;
import com.pauseandshop.ecom.generic.fileutility.ExcelUtility;
import com.pauseandshop.ecom.generic.fileutility.Fileutility;
import com.pauseandshop.ecom.generic.webdriverutily.JavaUtility;
import com.pauseandshop.ecom.generic.webdriverutily.WebDriverUtility;

public class BaseClass {
	/* create object */
	public DataBaseUtility dbLib = new DataBaseUtility();
	public Fileutility fLib = new Fileutility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver ;
	public static WebDriver sdriver;

	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("======ConnecttoDB,ReportConfig======");
		dbLib.getDbconnections();
	}

	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBC() throws Throwable {
		System.out.println("======LanuchBrowser======");
		String Browser1 = fLib.getDataFromProperties("browser");
		if (Browser1.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser1.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser1.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;// to store session id
	}
	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBM() throws IOException {
		System.out.println("======Login======");
		
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAM() {
		System.out.println("======Logout======");
		
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAC() {
		System.out.println("======CloseBrowser======");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAS() {
		System.out.println("======ClosetoDB,Reportbackup======");
		dbLib.closeDbconnection();
	}
}
