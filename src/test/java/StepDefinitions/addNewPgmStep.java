package StepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import PageObjects.addNewPgmPg;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addNewPgmStep {

	private WebDriver driver = DriverFactory.getDriver();

	private addNewPgmPg anp = new addNewPgmPg(DriverFactory.getDriver());

	String filePath = System.getProperty("user.dir") + "/src/test/resources/Input.xlsx";

	ExcelReader sheetReader = new ExcelReader();
	
	
	@Given("Admin is on Manage Program Page")
	public void admin_is_on_manage_program_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getCurrentUrl());
//		anp.getPgmPageTitletxt();
//		anp.clickanewpgmLink();
	}

	@When("Admin clicks A New Program button")
	public void admin_clicks_a_new_program_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		anp.clickanewpgmLink();
	}

	@Then("Validate Program details modal Validate buttons are visible")
	public void validate_program_details_modal_validate_buttons_are_visible() {
		// Write code here that turns the phrase above into concrete actions
		boolean cancel = anp.cancelBtn();
		System.out.println(cancel);

		boolean save = anp.saveBtn();
		System.out.println(save);

	}

	@Then("Validate Program details modal Validate all the input name and description fields are visible")
	public void validate_program_details_modal_validate_all_the_input_name_and_description_fields_are_visible() {
		// Write code here that turns the phrase above into concrete actions
		boolean name = anp.name();
		System.out.println(name);

		boolean Desc = anp.desc();
		System.out.println(Desc);

	}

	@Then("Validate Program details modal Validate status radio buttons are visible")
	public void validate_program_details_modal_validate_status_radio_buttons_are_visible() {
		// Write code here that turns the phrase above into concrete actions

		boolean Stsone = anp.stsone();
		System.out.println(Stsone);

		boolean Ststwo = anp.ststwo();
		System.out.println(Ststwo);

	}

	@Given("Admin is on Program Details modal window")
	public void admin_is_on_program_details_modal_window() {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		anp.clickanewpgmLink();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("Admin clicks Save button without entering any data")
	public void admin_clicks_save_button_without_entering_any_data() {
		// Write code here that turns the phrase above into concrete actions
		anp.clicksave();
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
		// Write code here that turns the phrase above into concrete actions
		String pgmNameErr = anp.pgmNameErr();
		System.out.println(pgmNameErr);
		String pgmDescErr = anp.pgmDescErr();
		System.out.println(pgmDescErr);
		String pgmStsErr = anp.pgmStsErr();
		System.out.println(pgmStsErr);
	}

	@When("Admin enters only Program Name {string} {int} in text box and clicks Save button")
	public void admin_enters_only_program_name_in_text_box_and_clicks_save_button(String Sheetname, Integer Rownumber)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		System.out.println(filePath);
		List<Map<String, String>> testData = sheetReader.getData(filePath, Sheetname);
		String name = testData.get(Rownumber).get("Name");
		System.out.println(name);
		anp.EnterPgmName(name);
		anp.clicksave();
	}

	@Then("Admin gets a message alert for Description and status field")
	public void admin_gets_a_message_alert_for_description_and_status_field() {
		// Write code here that turns the phrase above into concrete actions
		String pgmDescErr = anp.pgmDescErr();
		String pgmStsErr = anp.pgmStsErr();
		System.out.println(pgmDescErr + " and " + pgmStsErr);

	}

	@When("Admin enters only Program Description {string} {int}  in text box and clicks Save button")
	public void admin_enters_only_program_description_in_text_box_and_clicks_save_button(String Sheetname,
			Integer Rownumber) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		List<Map<String, String>> testData = sheetReader.getData(filePath, Sheetname);
		String description = testData.get(Rownumber).get("Description");
		System.out.println(description);
		anp.EnterPgmdesc(description);
		anp.clicksave();

	}

	@Then("Admin gets a message alert for program name and status field")
	public void admin_gets_a_message_alert_for_program_name_and_status_field() {
		// Write code here that turns the phrase above into concrete actions
		String pgmNameErr = anp.pgmNameErr();
		String pgmStsErr = anp.pgmStsErr();
		System.out.println(pgmNameErr + " and " + pgmStsErr);

	}

	@When("Admin selects only Status {string} {int}  and clicks Save button")
	public void admin_selects_only_status_and_clicks_save_button(String Sheetname, Integer Rownumber)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		List<Map<String, String>> testData = sheetReader.getData(filePath, Sheetname);
		String status = testData.get(Rownumber).get("Status");
		System.out.println(status);

		String sts = status.toLowerCase();
		System.out.println(sts);

		switch (sts) {
		case "active":
			anp.ClickStatusActive(status);
			anp.clicksave();
			break;
		case "inactive":
			anp.ClickStatusInActive(status);
			anp.clicksave();
			break;
		}

	}

	@Then("Admin gets a message alert program Name and Description field")
	public void admin_gets_a_message_alert_program_name_and_description_field() {
		// Write code here that turns the phrase above into concrete actions

		String pgmNameErr = anp.pgmNameErr();
		String pgmDescErr = anp.pgmDescErr();
		System.out.println(pgmNameErr + " and " + pgmDescErr);

	}

	@When("Admin enters only numbers or special char in Pgm name and Desc {string} {int} column")
	public void admin_enters_only_numbers_or_special_char_in_pgm_name_and_desc_column(String Sheetname,
			Integer Rownumber) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		List<Map<String, String>> testData = sheetReader.getData(filePath, Sheetname);
		String name = testData.get(Rownumber).get("Name");
		String description = testData.get(Rownumber).get("Description");
		System.out.println(name);
		System.out.println(description);
		anp.EnterPgmName(name);
		anp.EnterPgmdesc(description);
		anp.clicksave();

	}

	@Then("Admin gets a Error message alert for invalid inputs")
	public void admin_gets_a_error_message_alert_for_invalid_inputs() {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String pgmNameErr = anp.pgmNameErrInvalid();
		String pgmDescErr = anp.pgmDescErrInvalid();
		String pgmStsErr = anp.pgmStsErr();
		System.out.println(pgmNameErr + " and " + pgmDescErr + " " + pgmStsErr);
	}

	@When("Admin clicks Cancel or Close X Icon on Program Details form")
	public void admin_clicks_cancel_or_close_x_icon_on_program_details_form() {
		anp.closeanewpgm();
	}

	@Then("Program Details popup window should be closed without saving")
	public void program_details_popup_window_should_be_closed_without_saving() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println(anp.getPgmPageTitletxt());
	}

	@When("Enter all the required name and description and status {string} {int} with valid values and click Save button")
	public void enter_all_the_required_name_and_description_and_status_with_valid_values_and_click_save_button(
			String Sheetname, Integer Rownumber) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		List<Map<String, String>> testData = sheetReader.getData(filePath, Sheetname);
		String name = testData.get(Rownumber).get("Name");
		String description = testData.get(Rownumber).get("Description");
		String status = testData.get(Rownumber).get("Status");
		String sts = status.toLowerCase();
		anp.EnterPgmName(name);
		anp.EnterPgmdesc(description);
		switch (sts) {
		case "active":
			anp.ClickStatusActive(status);
			anp.clicksave();
			break;
		case "inactive":
			anp.ClickStatusInActive(status);
			anp.clicksave();
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Then("Admin gets a message Successful Program Created alert and able to see the new program added in the data table")
	public void admin_gets_a_message_successful_program_created_alert_and_able_to_see_the_new_program_added_in_the_data_table() {
		// Write code here that turns the phrase above into concrete actions
		String message = anp.toastMsg();
		System.out.println(message );
	}

}
