package StepDefinitions;

import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private WebDriver driver = DriverFactory.getDriver();
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	
	
	@Given("admin enter the LMS site")
	public void admin_enter_the_lms_site() {
		loginpage.getLoginPage();
	}

	@When("Admin enters <username> and <password>")
	public void admin_enters_username_and_password() {
		loginpage.setUserName("sdetorganizers@gmail.com");
		loginpage.setPassword("UIHackathon@02");
		loginpage.clickOnLoginButton();
	}

	@Then("Admin suceessfully logged in")
	public void admin_suceessfully_logged_in() {
	}
}
