package com.crm.qa.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	

	@FindBy(name="email")
	WebElement UN;

	@FindBy(name="password")
	WebElement PWd;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement Login;
	
	@FindBy(linkText="Sign Up")
	WebElement SignUp;
	
	@FindBy(xpath="//div[@class='ui message']")
	WebElement Text;
	
	public LoginPage() throws IOException {
		//initializing the page objects:
		PageFactory.initElements(driver, this);// Interview qn: How will we initialize PageFactory? Ans: usingPageFactory.initElements(driver, this);
		// Here this is all the elements of the Login Page class.
		
		// TODO Auto-generated constructor stub
	}
	
	//actions: 
		public  String TitleActions() {
			return driver.getTitle(); //here we are returning the title of the page.
			  
		  }
		
		public String TextName() {
			return Text.getText();
		}
		
		public HomePage Login(String un, String PWD) throws IOException {
			UN.sendKeys(un);
			PWd.sendKeys(PWD);
			Login.click();
			return new HomePage();
		
		}
		

}


