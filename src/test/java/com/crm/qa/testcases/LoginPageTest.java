package com.crm.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends TestBase {
	LoginPage objLogin;
	HomePage homepage;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	public LoginPageTest() throws IOException {
super();// it will call base class constructor first using Super class constructor, then it will go to SetUp Method
		
	}
	
	@BeforeTest
	public void extentTest() {
		extent = new ExtentReports(System.getProperty("user.dir")+ "/test-output-Pinkey/ExtentReport.html",true);// user.dir= takes
		//the path of the project class.
		extent.addSystemInfo("User Name", "PinkeyM");
		extent.addSystemInfo("OS", "Windows 10");
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}
	
	public static String TakeScreenshot(WebDriver driver, String ScreenshotName) throws Exception {
		String DateName= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());// here new Date() will current date
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+ "/FailedTestsScreenshots/"+ScreenshotName + DateName + ".png";
		File finalDestination=  new File(destination);
		FileUtils.copyFile(source,finalDestination);
		return destination;
	}

	@BeforeMethod
	public void SetUp() throws IOException {
		initialization();// calling the initialization method from base class 
		objLogin= new LoginPage();
		
}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		extentTest= extent.startTest("LoginPageTitleTest");
		
		String Titel=objLogin.TitleActions();
		System.out.println(Titel);
		Assert.assertEquals(Titel, "Cogmento CRM1");
	
	}
	
	/*@Test(priority=2)
	public void TextTest() {
		String  TextDisplay=objLogin.TextName();
		Assert.assertEquals(TextDisplay, "Forgot your password?");
		
	}
	
	@Test(priority=3)
	public void LoginTest() throws IOException {
		homepage=objLogin.Login(prop.getProperty("UN"), prop.getProperty("PWD"));
	}*/
	@AfterMethod
	public void teardown(ITestResult result) throws Exception {//This method is invoked when any test method gets failed
		if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test case is failed" +result.getName() );	// to add  name in extent report
			extentTest.log(LogStatus.FAIL, "Test case is failed" +result.getThrowable() );// to add error/exception in extent report
			String ScreenshotPath= LoginPageTest.TakeScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ScreenshotPath));// to add screenshot in extent report.
		}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test case skipped is" + result.getName());
			
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case skipped is" + result.getName());
		}
		extent.endTest(extentTest);
		driver.close();
	}

}
