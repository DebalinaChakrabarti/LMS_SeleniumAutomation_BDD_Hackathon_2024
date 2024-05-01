package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;

import PageObjects.loginpage;
import Utilities.Constants;
import Utilities.ExcelReader;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private loginpage loginpg = new loginpage(DriverFactory.getDriver());
	private ExcelReader excelRead = new ExcelReader();

	@When("Admin gives the correct LMS portal URL")
	public void launch_LMSPortal() {
		loginpg.getloginUrl();
	}
	

	@When("Admin gives the invalid LMS portal URL")
	public void launch_invalidLMSPortal() {
		loginpg.getinvalidloginUrl();
	}

	@Then("Admin should land on the home page")
	public void get_lms_title() {
		String actualTitle = loginpg.getPageTitle();
		Assert.assertEquals("LMS", actualTitle.trim());
	}
	String Uname = "sdetorganizers@gmail.com";
	String Pwd = "UIHackathon@02";
	@When("Admin enters valid credentials and clicks login button")
	public void user_enters_valid_credentials() throws InterruptedException {
		System.out.println("Enter Valid Credentials");
		loginpg.EnterUserName(Uname);
		loginpg.EnterPassword(Pwd);
		System.out.println("Click Login Button");
		loginpg.clickOnloginButton();
	}

	@When("Admin enters credentials {string} and {string} and clicks login button")
	public void user_enters_valid_credentials(String Uname, String Pwd) throws InterruptedException {
		System.out.println("Enter Valid Credentials");
		loginpg.EnterUserName(Uname);
		loginpg.EnterPassword(Pwd);
		System.out.println("Click Login Button");
		loginpg.clickOnloginButton();
	}

	@When("Admin enters credentials {string} and {string} and clicks login button through keypad")
	public void user_enters_valid_credentials_clicksLoginThroughKeypad(String Uname, String Pwd)
			throws InterruptedException {
		System.out.println("Enter Valid Credentials");
		loginpg.EnterUserName(Uname);
		loginpg.EnterPassword(Pwd);
		System.out.println("Click Login Button");
		loginpg.clickOnloginButtonThroughKeypad();
	}

	@Then("Admin should land on dashboard page")
	public void Admin_should_land_on_dashboard_page() throws InterruptedException {
		Assert.assertEquals(true, loginpg.returnlogoutbutton().isDisplayed());

	}

	@Then("Admin should see the Error message please check expected {string} displays")
	public void Error_Msg_Validation(String expMsg) {

		String actualMsg = loginpg.getLoginErrorMgs().trim();
		Assert.assertEquals(true, actualMsg.contains(expMsg.trim()),
				expMsg + " is not displayed and it is displaying the following wrong message " + actualMsg);

	}

	@When("Admin should see {string}")
	public void LoginPageValidation(String expField) {
		if (expField.contains("Please login to LMS application")) {
			Assert.assertTrue(loginpg.getLoginHeadingText().contains("Please login to LMS application"),
					"'Please login to LMS application' field is not displayed");
			System.out.println("'Please login to LMS application' field is  displayed");
		} else if (expField.contains("username")) {
			Assert.assertTrue(loginpg.userNameFieldExist(), "'username' field is not displayed");
			System.out.println("'username' field is  displayed");
		} else if (expField.contains("password")) {
			Assert.assertTrue(loginpg.passwordFieldExist(), "'password' field is not displayed");
			System.out.println("'password' field is  displayed");
		} else if (expField.contains("userfieldlabel")) {
			Assert.assertTrue(loginpg.getusernameLabelText().contains("User *"),
					"'usernameLabel' field is not displayed");
			System.out.println("'User *' label field is  displayed");
		} else if (expField.contains("passwordfieldlabel")) {
			Assert.assertTrue(loginpg.getpasswordLabelText().contains("Password *"),
					"'usernameLabel' field is not displayed");
			System.out.println("'Password *' label field is  displayed");
		} else if (expField.contains("login")) {
			Assert.assertTrue(loginpg.loginButtonExists(), "'login' button is not displayed");
			System.out.println("'Login' button is  displayed");
		} else if (expField.contains("logBtnlabel")) {
			Assert.assertTrue(loginpg.getloginBtnLabelText().contains("Login"),
					"'login' button label is not displayed");
			System.out.println("'Login' button label is  displayed");
		}

	}
	
	@Then ("Admin should recieve 404 page not found error")
	public void ValidatePageNotFoundMessage() {
		Assert.assertTrue(loginpg.getPageTitle().contains("Application Error"),
				"'page not found page' is not displayed");
		System.out.println("'page not found page'  is  displayed");
	}
	
	
	@Then ("Admin should see user in {string} color")
	public void colorvalidation(String expcolor)
	{
		if (expcolor.contains("usercolor")) {
			Assert.assertTrue(loginpg.getusercolorText().trim().contains("rgba(0, 0, 0, 0.54)"),
					"'Gray color' is not displayed for 'User'");
			System.out.println("'Gray color' is displayed for 'User'");
		} 
		else if (expcolor.contains("passwordcolor")) {
			Assert.assertTrue(loginpg.getpasswordcolorText().trim().contains("rgba(0, 0, 0, 0.54)"),
					"'Gray color' is not displayed for 'Password'");
			System.out.println("'Gray color' is displayed for 'Password'");
		} 
	}
	

	
	@Then ("Admin should see input and loginbutton are in center of login page")
	public void alignmentloginFieldsValidation()
	{
			Assert.assertTrue(loginpg.getloginfieldsposition().trim().contains("center"),
					"Input and login button are not center alligned");
			System.out.println("Input and login button are center alligned");
		
	}
	
	@Then ("Admin should see expected logo image in login page")
	public void loginFieldsImageValidation()
	{
			Assert.assertTrue(loginpg.getloginimage().trim().contains("assets/img/LMS-logo.jpg"),
					"Expected image source is not displayed in loginpage");
			System.out.println("Expected image source is displayed in loginpage");
		
	}
	
	
	
	


}
