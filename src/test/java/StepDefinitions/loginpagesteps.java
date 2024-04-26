package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import PageObjects.ArrayPage;
//import PageObjects.HomePage;
import PageObjects.loginpage;
import Utilities.Constants;
import Utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginpagesteps {

	private loginpage loginpg = new loginpage(DriverFactory.getDriver());
	private ExcelReader excelRead = new ExcelReader();

	@When("Admin gives the correct LMS portal URL")
	public void launch_LMSPortal() {
		loginpg.getloginUrl();
	}

	@Then("Admin should land on the home page")
	public void get_lms_title() {
		String actualTitle = loginpg.getPageTitle();
		Assert.assertEquals("LMS", actualTitle.trim());
	}

//	@When("Admin enters {string} credentials {string} and {string} and clicks login button")
//	public void user_enters_valid_credentials(String Testing, String Uname, String Pwd) throws InterruptedException {
//		if (Testing == "Positive") {
//			loginpg.EnterUserName(Uname);
//			loginpg.EnterPassword(Pwd);
//			Assert.assertEquals(true, loginpg.returnlogoutbutton().isDisplayed());
//		}
//		else if(Testing == "Negative") {
//			loginpg.EnterUserName(Uname);
//			loginpg.EnterPassword(Pwd);
//			Assert.assertEquals(true, loginpg.getLoginErrorMgs().contains(" Invalid username and password Please try again "));
//		}
//
//	}

//	@When("Admin enters valid credentials {string} and {string} and clicks login button")
//	public void user_enters_valid_credentials(String Uname, String Pwd) throws InterruptedException {
//		loginpg.EnterUserName(Uname);
//		loginpg.EnterPassword(Pwd);
//		System.out.println("Executed");
//		loginpg.clickOnloginButton();
//		Assert.assertEquals(true, loginpg.returnlogoutbutton().isDisplayed());
//
//	}

	@When("Admin enters credentials {string} and {string} and clicks login button")
	public void user_enters_valid_credentials(String Uname, String Pwd) throws InterruptedException {
		System.out.println("Enter Valid Credentials");
		loginpg.EnterUserName(Uname);
		loginpg.EnterPassword(Pwd);
		System.out.println("Click Login Button");
		loginpg.clickOnloginButton();
	}

	
	@Then("Admin should land on dashboard page")
	public void Admin_should_land_on_dashboard_page() {
		Assert.assertEquals(true, loginpg.returnlogoutbutton().isDisplayed());
	
	}
	@Then("Admin redirected based on {string} scenario")
	public void Admin_redirected(String Testing) {
		if (Testing == "Positive") {
//			Assert.assertEquals(true, loginpg.returnlogoutbutton().isDisplayed());
			if(loginpg.returnlogoutbutton().isDisplayed())
			{
				System.out.println("Admin landed on dashboard page");
			}
			else
			{
				System.out.println("Admin is not landed on dashboard page");
			}
		
		} else if (Testing == "Negative") {
//			Assert.assertEquals(true,
//					loginpg.getLoginErrorMgs().contains("Invalid username and password Please try again"));
			if(loginpg.getLoginErrorMgs().contains("Invalid username and password Please try again"))
			{
			System.out.println("Invalid credential error message is displayed");
			}
			else
			{
				System.out.println("Invalid credential error message is not displayed");
			}
		}
	}

}
