package com.cucumberFramework.pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumberFramework.helper.WaitHelper;

import junit.framework.Assert;

public class OrrangeHrmPage {
	
	private WebDriver driver;
	
	@FindBy(id = "txtUsername")
	public WebElement userName;
	
	@FindBy(id = "btnLogin")
	private WebElement loginBtn;
	
	@FindBy(id = "txtPassword")
	private WebElement enterPassword;
	
	@FindBy(xpath = "//div[text()='Primary']")
	private WebElement primarySection;	
	
	@FindBy(id = "menu_attendance_punchIn")
	private WebElement punchInOutButton;
	
	@FindBy(xpath = "//*[contains(text(),'Punched in Time')]")
	private WebElement punchedInOut;
	
	@FindBy(id = "attendance_note")
	private WebElement noteTextBox;
	
	@FindBy(id = "menu_time_viewTimeModule")
	private WebElement menuTimeTab;  
	
	@FindBy(id = "employee")
	private WebElement employeeName;  
	
	
	WaitHelper waitHelper;
	
	public OrrangeHrmPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.WaitForElement(userName, 60);
	}
	

	public void enterUserName(String user){
		waitHelper.WaitForElement(userName,2);
		userName.sendKeys(user);
	}
	
	public void enterPassword(String password){
		waitHelper.WaitForElement(enterPassword,2);
		enterPassword.sendKeys(password);
	}
	
	public void clickOnNextBtn(){
		loginBtn.click();
	}
	
		
	public void verifyPrimarySection() throws InterruptedException{
		Thread.sleep(10000);
		Assert.assertEquals(true, primarySection.isDisplayed());
	}
	
	
	public void clickOnPunchInOutButton () throws InterruptedException 
	{
		Thread.sleep(10000);
		punchInOutButton.click();
		Thread.sleep(10000);
	}
	
	public void verifyPunchedInOutVariable () throws InterruptedException 
	{
		Thread.sleep(10000);
		Assert.assertEquals(true, punchedInOut.isDisplayed());
	}
	
	public void verifyPunchInOutButton () throws InterruptedException 
	{
		Assert.assertEquals(true,punchInOutButton.isDisplayed());
		Thread.sleep(10000);
		//punchInOutButton.click();
	}
	
	public void enterNoteInPunchInOut () throws InterruptedException 
	{
		noteTextBox.sendKeys("enter note pad");
		Thread.sleep(10000);
		//punchInOutButton.click();
	}
	
	public void clickOnMenuTimeTab () throws InterruptedException 
	{
		
		Thread.sleep(10000);
		menuTimeTab.click();
		Thread.sleep(2000);
		//punchInOutButton.click();
	}
	
	public void enterEmployeeName () throws InterruptedException 
	{
		
		Thread.sleep(10000);
		employeeName.sendKeys("Cecil Bonaparte");
		Thread.sleep(2000);
		//punchInOutButton.click();
	}
	
	
	
	/*
	 * public void clickHeadphonesLnk(){ Actions builder = new Actions(driver);
	 * builder.moveToElement(allShopNav).build().perform();
	 * builder.moveToElement(TvApplElecPanel).build().perform(); JavascriptExecutor
	 * js = (JavascriptExecutor)driver; js.executeScript("arguments[0].click();",
	 * headPhonesCatLnk);
	 * 
	 * }
	 */
		
	
}
