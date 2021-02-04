package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.utils.TestUtilsClass;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public TestBase() throws IOException { //constructor, it has same name as of class
		
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Pinkeym\\Java Testing\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
prop.load(ip);
	}
		
	public static void initialization() {
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pinkeym\\Documents\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TestUtilsClass.Page_Timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtilsClass.Implicit_Timeout, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			WebDriverWait wait= new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("sdfd")));
			
		
			
			
		}
	}

}
