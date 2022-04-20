package com.cucumberFramework.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.FilpKartHomePage;
import com.cucumberFramework.pageObjects.FlipKartLoginPage;
import com.cucumberFramework.pageObjects.GmailPage;
import com.cucumberFramework.pageObjects.OrrangeHrmPage;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;


public class StepDefinitions extends TestBase {

	FlipKartLoginPage loginPage = new FlipKartLoginPage(driver);
	FilpKartHomePage homePage = new FilpKartHomePage(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	//ConfigFileReader reader=new ConfigFileReader();
	GmailPage gmail=new GmailPage(driver);
	OrrangeHrmPage orHrm=new OrrangeHrmPage(driver);
	WaitHelper helper = new WaitHelper(driver);
	

@Given("^Go to URL \"([^\"]*)\"$")
public void go_to_URL(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //driver.get(arg1);
//	driver.get(reader.getApplicationUrl());
	driver.navigate().to(arg1);
	}

@Given("^Click to Log in$")
public void click_to_Log_in() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	loginPage.clickOnLoginLink();
    
}

@When("^Sign in with \"([^\"]*)\" and \"([^\"]*)\"$")
public void sign_in_with_and(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
//loginPage.enterUserName(arg1);
	loginPage.enterUserName(arg1);
	
loginPage.enterPassword(arg2);
loginPage.clickSignInButton();
}
/*
 * @When("^Click on the Electronics$") public void click_on_the_Electronics()
 * throws Throwable { // Write code here that turns the phrase above into
 * concrete actions loginPage.clickOnElectronics(); }
 */

@Then("^user able to logged in successfully$")
public void observe_the_product_screen() throws Throwable {
    homePage.myAccountIsDisplayed();
}
@Then("^Observe the cursor on Electronics highlighted$")
public void Observe_the_cursor_on_Electronics_highlighted() throws Throwable {
    homePage.verifyElectronicsHighlighted();
}	
@When("^Move the mouse on Search bar$")
public void move_the_mouse_on_Search_bar() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
 homePage.moveToSearchBar();
   
}

@When("^Type any product on search bar \"([^\"]*)\"$")
public void type_any_product_on_search_bar(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	homePage.enterTextInSearchbar(arg1);
    
}

@Then("^Check the search result page with product given$")
public void check_the_search_result_page_with_product_given() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	homePage.printResultsText();
}
@Then("^user able to see the error message$")
public void user_able_to_see_the_error_message() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(10000);
    loginPage.verifyLoginErrorMessage();
    System.out.println(loginPage.loginErrorMessage.getText());
}

@Then("^verify page error$")
public void verify_page_error() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    loginPage.verifyWrongUrlErrorMessage();
}
@Given("^navigate to gmail page$")
public void navigate(){
      
       driver.get("http://www.gmail.com");         
       }

@Then("^home page should be displayed$")
public void verifySuccessful(){
      String expectedText="Gmail";
      String actualText=driver.findElement(By.xpath("//*[@id='gbq1']/div/a/span")).getText();
     
      }

@When("^User login into the gmail using \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_login_into_the_gmail_using_and(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	gmail.enterUserName(arg1);
	gmail.clickOnNextBtn();
	gmail.enterPassword(arg2);
	gmail.clickOnNextBtn();	
	
}

@Then("^very by default primary section is selected$")
public void very_by_default_primary_section_is_selected() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   
}

// Orrange HRM Step Definitions

@Given("^Launch application \"([^\"]*)\"$")
public void launch_application(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.navigate().to(arg1);
}

@When("^Enter username and password as \"([^\"]*)\" and \"([^\"]*)\"$")
public void enter_username_and_password_as_and(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	//orHrm.wait();
	
	orHrm.enterUserName(arg1);
	//helper.wait(2);
	//orHrm.wait();
	orHrm.enterPassword(arg2);
}

@When("^user clicks login button$")
public void user_clicks_login_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	orHrm.clickOnNextBtn();
}

@When("^user clicks time menu tab$")
public void user_clicks_time_menu_tab() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	orHrm.clickOnMenuTimeTab();
}

@Then("^Verify user able to navigate to Punch in and out button$")
public void verify_user_able_to_navigate_to_Dashboard_page_by_default() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	orHrm.verifyPunchInOutButton();
	orHrm.clickOnPunchInOutButton();
 
}
@And("^Verify user able to navigate to Punch in and out tab$")
public void verify_user_able_to_navigate_to_Punch_in_out_tab() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	orHrm.verifyPunchedInOutVariable();
	orHrm.enterNoteInPunchInOut();
}

@And("^Verify user able to search Employee name$")
public void verify_user_able_to_search_employee_name() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	orHrm.enterEmployeeName();
	//orHrm.enterNoteInPunchInOut();
}

}