package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import PageObjects.editPgmPg;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class editPgmStep {

	private WebDriver driver = DriverFactory.getDriver();

	private editPgmPg enp = new editPgmPg(DriverFactory.getDriver());

	String filePath = System.getProperty("user.dir") + "/src/test/resources/Input.xlsx";

	ExcelReader sheetReader = new ExcelReader();


@Given("Admin is on Manage Program Page for edit")
public void admin_is_on_manage_program_page_for_edit() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(3000);
	enp.clickProgramLink();
	System.out.println(enp.getPgmPageTitletxt());
	Assert.assertTrue(enp.getPgmPageTitletxt().equalsIgnoreCase("Manage Program"));
}

	@When("Admin clicks Edit icon on the data table for any row")
	public void admin_clicks_edit_icon_on_the_data_table_for_any_row() {
		// Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Admin clicks Edit icon on the data table for any row");

		enp.clickEdit();
	}

	@Then("Admin should see a modal open for Program details to edit")
	public void admin_should_see_a_modal_open_for_program_details_to_edit() {
		// Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Admin should see a modal open for Program details to edit");
		String pgmDetailtxt = enp.getPgmEditWin();
		System.out.println(pgmDetailtxt);
		Assert.assertTrue(enp.getPgmEditWin().equalsIgnoreCase("Program Details"));

		enp.cancelBtn();
	}

	@Given("Admin is on Program Details modal window to Edit")
	public void admin_is_on_program_details_modal_window_to_edit() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin updates the program name {string} {int} field and clicks save button")
	public void admin_updates_the_program_name_field_and_clicks_save_button(String Sheetname, Integer Rownumber)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Admin updates the program name {string} {int} field and clicks save button");

		System.out.println(filePath);
		List<Map<String, String>> testData = sheetReader.getData(filePath, Sheetname);
		String PgmName = testData.get(Rownumber).get("Name");
		System.out.println(PgmName);
		enp.clickPgmnamesort();
		enp.clickEditByname(PgmName);
		enp.clearPgmName();
		enp.EnterPgmName(PgmName);
		enp.clicksave();
	}

	@Then("Admin gets a message Successful Program Updated alert and able to see the updated name in the table for the particular program")
	public void admin_gets_a_message_successful_program_updated_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program() {
		// Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Admin gets a message Successful Program Updated alert and able to see the updated name in the table for the particular program");

		String message = enp.toastMsg();
		System.out.println(message);

	}

	@When("Admin updates the Description {string} {int}  field and clicks save button")
	public void admin_updates_the_description_field_and_clicks_save_button(String Sheetname, Integer Rownumber) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Admin updates the Description {string} {int}  field and clicks save button");

		System.out.println(filePath);
		List<Map<String, String>> testData = sheetReader.getData(filePath, Sheetname);
		String PgmDesc = testData.get(Rownumber).get("Description");
		String PgmName = testData.get(Rownumber).get("Name");
		System.out.println(PgmName);
		enp.clickPgmnamesort();
		enp.clickEditByname(PgmName);
		System.out.println(PgmDesc);
		enp.clearDesc();
		enp.EnterPgmdesc(PgmDesc);
		enp.clicksave();	
		
	}

	@Then("Admin gets a message Successful Program Updated alert and able to see the updated description in the table for the particular program")
	public void admin_gets_a_message_successful_program_updated_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program() {
		// Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Admin gets a message Successful Program Updated alert and able to see the updated description in the table for the particular program");

		String messagetwo = enp.toastMsg();
		System.out.println(messagetwo);
	
	}

	@When("Admin updates the Status {string} {int}  and clicks save button")
	public void admin_updates_the_status_and_clicks_save_button(String Sheetname, Integer Rownumber) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Admin updates the Status {string} {int}  and clicks save button");

		List<Map<String, String>> testData = sheetReader.getData(filePath, Sheetname);
		String status = testData.get(Rownumber).get("Status");
		String PgmName = testData.get(Rownumber).get("Name");
		System.out.println(PgmName);
		enp.clickPgmnamesort();
		enp.clickEditByname(PgmName);
		
		System.out.println(status);

		String sts = status.toLowerCase();
		System.out.println(sts);

		switch (sts) {
		case "active":
			enp.ClickStatusActive(status);
			enp.clicksave();
			break;
		case "inactive":
			enp.ClickStatusInActive(status);
			enp.clicksave();
			break;
		}
			
		}

	@Then("Admin gets a message Successful Program Updated alert and able to see the updated status in the table for the particular program")
	public void admin_gets_a_message_successful_program_updated_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program() {
		// Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Admin gets a message Successful Program Updated alert and able to see the updated status in the table for the particular program");

		String messagethr = enp.toastMsg();
		System.out.println(messagethr);

	}

	@When("Admin enters only numbers or special char in name and description field {string} {int}")
	public void admin_enters_only_numbers_or_special_char_in_name_and_description_field(String Sheetname,
			Integer Rownumber) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Admin enters only numbers or special char in name and description field {string} {int}");

		System.out.println(filePath);
		List<Map<String, String>> testData = sheetReader.getData(filePath, Sheetname);
		String PgmDesc = testData.get(Rownumber).get("Description");
		String PgmName = testData.get(Rownumber).get("Name");
		System.out.println(PgmName);
		enp.clickPgmnamesort();
		enp.clickEdit();
		enp.clearPgmName();
		enp.EnterPgmName(PgmName);
		System.out.println(PgmDesc);
		enp.clearDesc();
		enp.EnterPgmdesc(PgmDesc);
		enp.clicksave();	
		enp.cancelBtn();
		
	}

	@Then("Admin gets a Error message alert invalid details to update")
	public void admin_gets_a_error_message_alert_invalid_details_to_update() {
		// Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Admin gets a Error message alert invalid details to update");

		String pgmDescErr = enp.pgmNameErrInvalid();
		String pgmStsErr = enp.pgmDescErrInvalid();
		System.out.println(pgmDescErr + " and " + pgmStsErr);

	}

	@When("Admin clicks Cancel button on edit modal")
	public void admin_clicks_cancel_button_on_edit_modal() {
		// Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Admin clicks Cancel button on edit modal");

		enp.clickEdit();
		enp.cancelBtn();
	}

	@Then("Admin can see the Program details modal disappears and can see nothing changed for particular program")
	public void admin_can_see_the_program_details_modal_disappears_and_can_see_nothing_changed_for_particular_program() {
		// Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Admin can see the Program details modal disappears and can see nothing changed for particular program");

		System.out.println(enp.getPgmPageTitletxt());

	}
}
