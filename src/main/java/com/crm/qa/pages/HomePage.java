package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement UserNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(linkText="Deals")
	WebElement DealsLink;
    
	@FindBy(linkText="Tasks")
	WebElement TasksLink;
	
	
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String Title() {
		return driver.getTitle();
	}
	
	public boolean Label() {
		return UserNameLabel.isDisplayed();
		
	}
	
	public ContactsPage ClickOnContacts() throws IOException {
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage ClickOnDeals() {
		DealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage ClickonTasks() throws IOException {
		TasksLink.click();
		return new TasksPage();
}
	
	
	
}
