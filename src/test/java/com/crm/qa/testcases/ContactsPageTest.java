package com.crm.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContact;
import com.crm.qa.utils.TestUtilsClass;

public class ContactsPageTest extends TestBase{
	
	LoginPage Loginpage;
	HomePage homepage;
	ContactsPage Contacts;
	String SheetName= "contacts";

	public ContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException {
	initialization();
	Loginpage = new LoginPage();
	
	homepage = Loginpage.Login(prop.getProperty("UN"), prop.getProperty("PWD"));
	Contacts= new ContactsPage();
	//driver.manage().timeouts().implicitlyWait(TestUtilsClass.Implicit_Timeout, TimeUnit.SECONDS);
	}
	
	/*@Test(priority=1)
	public void ContactLink() throws IOException {
		homepage.ClickOnContacts();
		//Assert.assertEquals(true, true);
	}
	
	@Test(priority=2)
	public void Text() throws IOException, InterruptedException  {
		
		//homepage.ClickOnContacts();
		//Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(TestUtilsClass.Implicit_Timeout, TimeUnit.SECONDS);
		Contacts.ClickOnContactsLink();
	
	}*/
	
	@DataProvider

	public Object[][] CRMgetTestData() throws InterruptedException {
		Thread.sleep(3000);
	Object data[][]=TestUtilsClass.getTestData(SheetName);	
	return data;
	}
	
	@Test(priority=3, dataProvider="CRMgetTestData")
	public void Details(String FirstName, String LastName) throws InterruptedException {
		Contacts.ClickOnContactsLink();
		//Contacts.EnterDetails("Juhi", "Kany");
		Contacts.EnterDetails(FirstName, LastName);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}