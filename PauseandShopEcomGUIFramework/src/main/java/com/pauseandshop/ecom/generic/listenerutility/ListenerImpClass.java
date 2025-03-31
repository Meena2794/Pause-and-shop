package com.pauseandshop.ecom.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pauseandshop.ecom.baseutility.BaseClass;
import com.pauseandshop.ecom.generic.webdriverutily.UtilityClassObject;



public class ListenerImpClass {
	public class listimpclass implements ITestListener, ISuiteListener{
		public ExtentReports reports;
		public ExtentTest test;//this can't participate in llel execution i.e we created utilityclassobj class
		   String time = new Date().toString().replace("","_").replace(":", "_");

		@Override
		public void onStart(ISuite suite) {
			System.out.println("Report Configration");
			ExtentSparkReporter
			spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
			spark.config().setDocumentTitle("crm Test suite result");
			spark.config().setReportName("crmreport");
			spark.config().setTheme(Theme.DARK);
			//add env info& create test
			reports=new ExtentReports();
			reports.attachReporter(spark);
			reports.setSystemInfo("OS","windows-10");
			reports.setSystemInfo("Browser", "Chrome-100");
			reports.createTest("Enviroment","Env");
		}

		@Override
		public void onFinish(ISuite suite) {
			System.out.println("Report Backup ");
			reports.flush();
		}

		@Override
		public void onTestStart(ITestResult result) {
			System.out.println("======"+result.getMethod().getMethodName()+"<====start====>");
			test= reports.createTest(result.getMethod().getMethodName());
			UtilityClassObject.setTest(test);
			test.log(Status.INFO,result.getMethod().getMethodName()+"<====started====>");
			}

		@Override
		public void onTestSuccess(ITestResult result) {
			System.out.println("======"+result.getMethod().getMethodName()+"<====end====>");
			test.log(Status.PASS,result.getMethod().getMethodName()+"<====completed====>");
		}



		@Override
		public void onTestFailure(ITestResult result) {
			String testName = result.getMethod().getMethodName();
			TakesScreenshot eDriver = (TakesScreenshot)(BaseClass.sdriver);
		    String scr = eDriver.getScreenshotAs(OutputType.BASE64);
		   test.addScreenCaptureFromBase64String(scr, testName+" "+time); //to get all failed tc in diff folder
		   test.log(Status.FAIL,result.getMethod().getMethodName()+"<====failed====>");
		}

		@Override
		public void onTestSkipped(ITestResult result) {
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
		}

		


	}

}
