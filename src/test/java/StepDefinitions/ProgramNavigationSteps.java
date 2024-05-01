package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;

import DriverFactory.DriverFactory;
import PageObjects.Program;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramNavigationSteps {

//	private static final Logger logger = LogManager.getLogger(ProgramSortingSteps.class);
	private WebDriver driver = DriverFactory.getDriver();
	private Program programPage = new Program(DriverFactory.getDriver());

	
	@When("Admin clicks on Batch link on Manage Program page")
	public void admin_clicks_on_batch_link_on_manage_program_page() {
		LoggerLoad.info("ProgramNavigationSteps---Admin clicks on Batch link on Manage Program page");
		programPage.clickBatchLink();
	}

	@Then("Check if Admin is re-directed to Batch page")
	public void admin_is_re_directed_to_batch_page() {
		LoggerLoad.info("ProgramNavigationSteps---Admin is re-directed to Batch page");
		Assert.assertTrue(driver.getCurrentUrl().contains("/batch"));//checking if in Batch page
	}

	@When("Admin clicks on User link on Manage Program page")
	public void admin_clicks_on_user_link_on_manage_program_page() {
		LoggerLoad.info("ProgramNavigationSteps---Admin clicks on User link on Manage Program page");
		programPage.clickUserLink();
	}

	@Then("Check if Admin is re-directed to User page")
	public void admin_is_re_directed_to_user_page() {
		LoggerLoad.info("ProgramNavigationSteps---Admin is re-directed to User page");
		Assert.assertTrue(driver.getCurrentUrl().contains("/user"));//checking if in User page
	}

	@When("Admin clicks on Logout link on Manage Program page")
	public void admin_clicks_on_logout_link_on_manage_program_page() {
		LoggerLoad.info("ProgramNavigationSteps---Admin clicks on Logout link on Manage Program page");
		programPage.clickLogoutLink();
	}

	@Then("Check if Admin is re-directed to Login page")
	public void admin_is_re_directed_to_login_page() {
		LoggerLoad.info("ProgramNavigationSteps---Admin is re-directed to Login page");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"));//checking if in Login page
	}
	
	
	}
