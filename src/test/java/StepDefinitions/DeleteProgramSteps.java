package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import PageObjects.Program;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteProgramSteps {

//	private static final Logger logger = LogManager.getLogger(ProgramSortingSteps.class);
	private WebDriver driver = DriverFactory.getDriver();
	private Program programPage = new Program(DriverFactory.getDriver());

	@Given("Check if Admin is logged in for the Program Mdule")
	public void check_if_admin_is_logged_in_for_the_program_mdule() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(programPage.checkLogoutLink(), true);//checking if logged in
	}

	@When("Admin clicks on Program on the Navigation Bar to reach the Program module")
	public void admin_clicks_on_program_on_the_navigation_bar_to_reach_the_program_module() throws InterruptedException {
		Thread.sleep(2000);
//		programPage.clickProgramLink();
//		Thread.sleep(2000);
	}

	@Then("Admin should be redirected to the Manage Program in the Program module")
	public void admin_should_be_redirected_to_the_manage_program_in_the_program_module() {
//		Assert.assertTrue(programPage.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	@Given("Admin is on Manage Program in the Program module")
	public void admin_is_on_manage_program_in_the_program_module() {
	}

	
	@When("Admin clicks Delete button on the data table for any row in the Program module")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row_in_the_program_module() throws InterruptedException {
		LoggerLoad.info("DeleteProgramSteps---Admin clicks Delete button on the data table for any row in the Program module");
		Thread.sleep(2000);
		programPage.clickSpecificDeleteButton();
	}

	@Then("Admin should see a alert open with heading Confirm along with  YES and NO button for deletion in the Program module")
	public void admin_should_see_a_alert_open_with_heading_confirm_along_with_yes_and_no_button_for_deletion_in_the_program_module() throws InterruptedException {
		LoggerLoad.info("DeleteProgramSteps---Admin should see a alert open with heading Confirm along with  YES and NO button for deletion in the Program module");
		Thread.sleep(2000);
		Assert.assertTrue(programPage.isDisplayedConfirmHeaderYesNo(),"heading Confirm along with  YES and NO button for deletion is present");
	}

	@When("Admin clicks on Delete button on the data table for any row in the Program module")
	public void admin_clicks_on_delete_button_on_the_data_table_for_any_row_in_the_program_module() {
	}

	@Then("Admin should see a message {string}")
	public void admin_should_see_a_message(String msg) {
		LoggerLoad.info("DeleteProgramSteps---Admin should see a message ");
		Assert.assertTrue(programPage.isDisplayedSpecificDeleteConfirmMsg(),"Admin is able to see a confirmation message");
	}

	@Given("Admin is on Confirm Deletion alert popup in the Program module")
	public void admin_is_on_confirm_deletion_alert_popup_in_the_program_module() {
		LoggerLoad.info("DeleteProgramSteps---Admin is on Confirm Deletion alert popup in the Program module");
		Assert.assertTrue(programPage.isDisplayedConfirmHeader(),"Admin is on Confirm Deletion Alert popup");
	}

	@When("Admin clicks YES button on the alert in the Program module")
	public void admin_clicks_yes_button_on_the_alert_in_the_program_module() {
		LoggerLoad.info("DeleteProgramSteps---Admin clicks YES button on the alert in the Program module");
	}

	@Then("Admin gets a message Successful Program Deleted alert and able to see that program deleted in the data table in the Program module")
	public void admin_gets_a_message_successful_program_deleted_alert_and_able_to_see_that_program_deleted_in_the_data_table_in_the_program_module() throws InterruptedException {
		LoggerLoad.info("DeleteProgramSteps---Admin gets a message Successful Program Deleted alert and able to see that program deleted in the data table in the Program module");
		Assert.assertTrue(programPage.specificDeleteAlertConfirmYes(),"Successful Program Deleted alert message is displayed and program is not present in the data table");
		
	}

	@Given("Admin is on Confirm Delete alert popup in the Program module")
	public void admin_is_on_confirm_delete_alert_popup_in_the_program_module() throws InterruptedException {
		LoggerLoad.info("DeleteProgramSteps---Admin is on Confirm Delete alert popup in the Program module");
		Thread.sleep(2000);
		programPage.clickSpecificDeleteButton();
	}

	@When("Admin clicks NO button on the alert in the Program module")
	public void admin_clicks_no_button_on_the_alert_in_the_program_module() throws InterruptedException {
		LoggerLoad.info("DeleteProgramSteps---Admin clicks NO button on the alert in the Program module");
		Thread.sleep(2000);
//		programPage.clickNoConfirmDelete();
	}

	@Then("Admin can see the deletion alert disappears without deleting in the Program module")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting_in_the_program_module() throws InterruptedException {
		LoggerLoad.info("DeleteProgramSteps---Admin can see the deletion alert disappears without deleting in the Program module");
		Assert.assertTrue(programPage.specificDeleteAlertConfirmNo(),"Program is present in the data table");
	}

	@When("Admin clicks Close X Icon on Deletion alert in the Program module")
	public void admin_clicks_close_x_icon_on_deletion_alert_in_the_program_module() throws InterruptedException {
		LoggerLoad.info("DeleteProgramSteps---Admin clicks Close X Icon on Deletion alert in the Program module");
//		Thread.sleep(2000);
//		programPage.clickCloseConfirmDelete();
//		System.out.println("***********************************");
	}

	@Then("Admin can see the deletion alert disappears without any changes in the Program module")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes_in_the_program_module() throws InterruptedException {
		LoggerLoad.info("DeleteProgramSteps---Admin can see the deletion alert disappears without any changes in the Program module");
		Thread.sleep(2000);
		Assert.assertTrue(programPage.specificDeleteAlertConfirmClose(),"Program is present in the data table");
	}
}
