package StepDefinitions;

import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import PageObjects.LogoutPage;
import PageObjects.dashboardPage;
import io.cucumber.java.en.Then;

public class LogoutPageSteps {
	
	private LogoutPage Logoutpg = new LogoutPage(DriverFactory.getDriver());
	
	@Then("Admin click Logout button on navigation bar")
	public void LogoutOfLMS() {
		Logoutpg.clickLogoutBtn();
	}
	


}
