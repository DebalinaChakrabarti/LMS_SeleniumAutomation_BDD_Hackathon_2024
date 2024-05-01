package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import PageObjects.LoginPage;
import PageObjects.Program;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramMultipleDeleteSteps {

	private WebDriver driver = DriverFactory.getDriver();
	private Program programPage = new Program(DriverFactory.getDriver());
	private static final Logger logger = LogManager.getLogger(ProgramMultipleDeleteSteps.class);
	

	
	@Given("Admin is in the manage program page after clicking Program on the navigation bar in the Program module")
	public void admin_is_in_the_manage_program_page_after_clicking_program_on_the_navigation_bar() throws InterruptedException {
		Thread.sleep(3000);
		
		programPage.clickProgramLink();
		Assert.assertTrue(programPage.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
		LoggerLoad.info("ProgramMultipleDeleteSteps");
	}

	@When("Admin clicks any checkbox in the data table in the Program module")
	public void admin_clicks_any_checkbox_in_the_data_table() {
		LoggerLoad.info("ProgramMultipleDeleteSteps-------Admin clicks any checkbox in the data table");
		programPage.selectOneProgramChk();
		String isSelected = programPage.isSelectedProgramChk();
		Assert.assertTrue(isSelected.equalsIgnoreCase("true"));
	}

	@Then("Admin should see common delete option enabled under header Manage Program in the Program module")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
		LoggerLoad.info("ProgramMultipleDeleteSteps-------Admin should see common delete option enabled under header Manage Program");
		Assert.assertTrue(programPage.isEnabledCommonDeleteBtn());
	}
	@Given("Admin clicks common delete button after selecting the check box in the data table to reach on confirm deletion alert in the Program module")
	public void admin_clicks_delete_button_after_selecting_the_check_box_in_the_data_table_to_reach_on_confirm_deletion_alert() {
		LoggerLoad.info("ProgramMultipleDeleteSteps-------Admin clicks delete button after selecting the check box in the data table to reach on confirm deletion alert");
		programPage.clickCommonDeleteButton();
	}

	@When("Admin clicks <YES> button on the alert in the Program module")
	public void admin_clicks_yes_button_on_the_alert() throws InterruptedException {
//		Thread.sleep(2000);
//		programPage.commonDeleteAlertConfirmYes();
	}

	@Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table in the Program module")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() throws InterruptedException {
		LoggerLoad.info("ProgramMultipleDeleteSteps-------Admin should land on Manage Program page and can see the selected program is deleted from the data table");
		Thread.sleep(2000);
		Assert.assertTrue(programPage.commonDeleteAlertConfirmYes());
		Thread.sleep(1000);
		Assert.assertTrue(programPage.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	@Given("Admin clicks common delete after selecting the check box in the data table to reach on confirm deletion alert in the Program module")
	public void admin_clicks_delete_after_selecting_the_check_box_in_the_data_table_to_reach_on_confirm_deletion_alert() throws InterruptedException {
		LoggerLoad.info("ProgramMultipleDeleteSteps-------Admin clicks delete after selecting the check box in the data table to reach on confirm deletion alert");
		programPage.selectOneProgramChk();
		String isSelected = programPage.isSelectedProgramChk();
		Assert.assertTrue(isSelected.equalsIgnoreCase("true"));
		Thread.sleep(1000);
		programPage.clickCommonDeleteButton();
	}

	@When("Admin clicks <NO> button on the alert in the Program module")
	public void admin_clicks_no_button_on_the_alert() throws InterruptedException {
//		Thread.sleep(2000);
//		programPage.commonDeleteAlertConfirmNo();
	}

	@Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table in the Program module")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() throws InterruptedException {
		LoggerLoad.info("ProgramMultipleDeleteSteps-------Admin should land on Manage Program page and can see the selected program is not deleted from the data table");
		Thread.sleep(2000);
		Assert.assertTrue(programPage.commonDeleteAlertConfirmNo());
		Thread.sleep(1000);
		Assert.assertTrue(programPage.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	@Given("Admin clicks common delete button after selecting multiple check boxes in the data table to reach on confirm deletion alert in the Program module")
	public void admin_clicks_delete_button_after_selecting_multiple_check_boxes_in_the_data_table_to_reach_on_confirm_deletion_alert() throws InterruptedException {
		LoggerLoad.info("ProgramMultipleDeleteSteps-------Admin clicks delete button after selecting multiple check boxes in the data table to reach on confirm deletion alert");
		Thread.sleep(1000);
		programPage.selectMultipleProgramChk();
		Thread.sleep(1000);
		programPage.clickCommonDeleteButton();
	}

	@When("Admin clicks <YES> button on alert in the Program module")
	public void admin_clicks_yes_button_on_alert() {
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table in the Program module")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table() throws InterruptedException {
		LoggerLoad.info("ProgramMultipleDeleteSteps-------Admin should land on Manage Program page and can see the selected programs are deleted from the data table");
		Thread.sleep(2000);
		Assert.assertTrue(programPage.commonDeleteMultipleAlertConfirmYes());
		Thread.sleep(1000);
		Assert.assertTrue(programPage.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	@Given("Admin clicks common delete after selecting multiple check boxes in the data table to reach on confirm deletion alert in the Program module")
	public void admin_clicks_delete_after_selecting_multiple_check_boxes_in_the_data_table_to_reach_on_confirm_deletion_alert() throws InterruptedException {
		LoggerLoad.info("ProgramMultipleDeleteSteps-------Admin clicks delete after selecting multiple check boxes in the data table to reach on confirm deletion alert");
		programPage.selectMultipleProgramChk();
		Thread.sleep(1000);
		programPage.clickCommonDeleteButton();
	}

	@When("Admin clicks <NO> button on alert in the Program module")
	public void admin_clicks_no_button_on_alert() {
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are not deleted from the data table in the Program module")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_not_deleted_from_the_data_table() throws InterruptedException {
		LoggerLoad.info("ProgramMultipleDeleteSteps-------Admin should land on Manage Program page and can see the selected programs are not deleted from the data table");
		Thread.sleep(2000);
		Assert.assertTrue(programPage.commonDeleteMultipleAlertConfirmNo());
		Thread.sleep(1000);
		Assert.assertTrue(programPage.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}


}

