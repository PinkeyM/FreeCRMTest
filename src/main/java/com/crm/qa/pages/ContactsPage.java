package com.crm.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtilsClass;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement ClickOnNew;
	
	@FindBy(name="first_name")
	WebElement EnterName; 
	
	@FindBy(name="last_name")
	WebElement EnterLastName;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement ClickOnSave;


	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void ClickOnContactsLink() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(TestUtilsClass.Implicit_Timeout, TimeUnit.SECONDS);
		/*Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();*/
		ContactsLink.click();
		//driver.manage().timeouts().implicitlyWait(TestUtilsClass.Implicit_Timeout, TimeUnit.SECONDS);
		Thread.sleep(5000);
		ClickOnNew.click();
		Thread.sleep(5000);

	}
	
	//public NewContact ClickOnTextLink() throws IOException {
	
	//	ClickOnNew.click();
		//return new NewContact();
		
	
	//}
	
	public void EnterDetails(String name, String last) throws InterruptedException {
		EnterName.sendKeys(name);
		EnterLastName.sendKeys(last);
		Thread.sleep(3000);
		ClickOnSave.click();
	}
	
}
	


