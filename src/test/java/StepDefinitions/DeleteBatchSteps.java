package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DriverFactory.DriverFactory;
import PageObjects.AddNewBatch;
import PageObjects.DeleteBatch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteBatchSteps {

	private static final Logger logger = LogManager.getLogger(DeleteBatchSteps.class); 

	private DeleteBatch del = new DeleteBatch(DriverFactory.getDriver());

	@Given("The delete icon on row level in data table is enabled")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
         del.deleteenable(); 
	}

	@When("Admin click the delete icon")
	public void admin_click_the_delete_icon() {
         del.clickdelete(); 
	}

	@Then("Alert appears with yes and No option")
	public void alert_appears_with_yes_and_no_option() {
         del.alertwindow();
	}

	@Given("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
		del.clickdelete();
	}

	@When("You click yes option")
	public void you_click_yes_option() {
        del.delbatch();
	}

	@Then("Batch deleted alert pops and batch is no more available in data table")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() {

	}

	@When("you click No option")
	public void you_click_no_option() {
        del.notdeletebatch();
	}

	@Then("Batch is still listed in data table")
	public void batch_is_still_listed_in_data_table() {

	}

}
