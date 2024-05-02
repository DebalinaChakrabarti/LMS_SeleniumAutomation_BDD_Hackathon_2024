package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import PageObjects.Program;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaginationSteps {

//	private static final Logger logger = LogManager.getLogger(ProgramSortingSteps.class);
	private WebDriver driver = DriverFactory.getDriver();
	private Program programPage = new Program(DriverFactory.getDriver());

	
	@Then("Admin should be on Manage Program Page in program module")
	public void admin_should_be_on_manage_program_page_in_program_module() {
		LoggerLoad.info("PaginationSteps----Admin should be on Manage Program Page in program module");

		Assert.assertTrue(programPage.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	@Given("Admin is on Manage Program page in program module")
	public void admin_is_on_manage_program_page_in_program_module() {
		LoggerLoad.info("PaginationSteps---Admin is on Manage Program page in program module");
		Assert.assertTrue(programPage.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() throws InterruptedException {
		LoggerLoad.info("PaginationSteps---Admin clicks Next page link on the program table");
		Thread.sleep(1000);
		programPage.clickNextLink();
	}

	@Then("Admin should see the Pagination has Next active link on the program table")
	public void admin_should_see_the_pagination_has_Next_active_link() {
		LoggerLoad.info("PaginationSteps---Admin should see the Pagination has Next active link");
		Assert.assertTrue(programPage.isActiveNextLink());
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled in program module")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
		LoggerLoad.info("PaginationSteps---Admin should see the last page record on the table with Next page link are disabled");
		Assert.assertTrue(!programPage.isActiveNextLink(),"Next Page link is Disabled");
		Assert.assertTrue(programPage.getOriginalProgramNameList().size()>0,"Last page record is present");
	}


	@When("Admin clicks Last page link on the program table")
	public void admin_clicks_last_page_link() throws InterruptedException {
		LoggerLoad.info("PaginationSteps---Admin clicks Last page link");
		Thread.sleep(1000);
		programPage.clickLastLink();
	}


	@Given("Admin is on last page of Program table")
	public void admin_is_on_last_page_of_program_table() {
		LoggerLoad.info("PaginationSteps---Admin is on last page of Program table");
		Assert.assertTrue(!programPage.isActiveLastLink());
	}

	@When("Admin clicks Previous page link on the program table")
	public void admin_clicks_Previous_page_link() throws InterruptedException {
		LoggerLoad.info("PaginationSteps---Admin clicks Previous page link");
		Thread.sleep(1000);
		programPage.clickPreviousLink();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link in program module")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
		LoggerLoad.info("PaginationSteps---Admin should see the previous page record on the table with pagination has previous page link");
		Assert.assertTrue(programPage.isActivePreviousLink());
		Assert.assertTrue(programPage.getOriginalProgramNameList().size()>0,"Previous page record is present");
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() {
		LoggerLoad.info("PaginationSteps---Admin is on Previous Program page");
		Assert.assertTrue(programPage.isActivePreviousLink());
	}

	@When("Admin clicks First page link on the program table")
	public void admin_clicks_first_page_link() throws InterruptedException {
		LoggerLoad.info("PaginationSteps---Admin clicks First page link");
		Thread.sleep(1000);
		programPage.clickFirstLink();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled in program module")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
		LoggerLoad.info("PaginationSteps---Admin should see the very first page record on the table with Previous page link are disabled");
		Assert.assertTrue(!programPage.isActivePreviousLink(),"Previous Page Link is Disabled");
		Assert.assertTrue(programPage.isFirstPage(),"First Page Record is present");
	}


}
