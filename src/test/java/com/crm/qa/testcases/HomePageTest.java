package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import junit.framework.Assert;

public class HomePageTest<ContactsPage> extends TestBase{
	LoginPage Loginpage;
	HomePage homepage;
    ContactsPage contacts;
    Logger log= Logger.getLogger(HomePageTest.class);//for creating own logs

	public HomePageTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void SetUp() throws IOException {
		initialization();
		log.info("**************************************Launching chrome");
		//contacts = new ContactsPage();
		Loginpage= new LoginPage();// i have created Login Page class object because for accessing HomePage first I need to login.
		homepage=Loginpage.Login(prop.getProperty("UN"), prop.getProperty("PWD"));
	}
	
	@Test(priority=1)
	public void HomePageTiTleTest() {
		String title=homepage.Title();
		Assert.assertEquals(title, "Cogmento CRM");
		System.out.println(title);
	}
	
	@Test(priority=2)
	public void LabelTest() {
		Assert.assertTrue(homepage.Label());

	}
	@Test(priority=3)
	public void ContactsTest() throws IOException {
		contacts=(ContactsPage) homepage.ClickOnContacts();
	}
	@Test
	public void DealsTest() {
		homepage.ClickOnDeals();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	

}
