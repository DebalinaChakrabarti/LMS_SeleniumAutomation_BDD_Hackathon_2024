package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DriverFactory.DriverFactory;
import PageObjects.DeleteMultipleBatches;
import PageObjects.EditBatch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditBatchSteps {
	
	private static final Logger logger = LogManager.getLogger(EditBatchSteps.class);

	private EditBatch editbatch = new EditBatch(DriverFactory.getDriver());
	

	@Given("The edit icon on row level in data table is enabled")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled() throws InterruptedException {
		  Thread.sleep(2000);
          editbatch.editenable();
	}

	@When("Admin click the edit icon")
	public void admin_click_the_edit_icon() throws InterruptedException {
		 Thread.sleep(1000);
         editbatch.clickedit();
	}

	@Given("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {

	}

	@When("Update the fields with valid values and click save")
	public void update_the_fields_with_valid_values_and_click_save() {
        editbatch.updatevalues();
	}

	@Then("The updated batch details should appear on the data table")
	public void the_updated_batch_details_should_appear_on_the_data_table() {

	}

	@When("Update the fields with invalid values and click save")
	public void update_the_fields_with_invalid_values_and_click_save() {
	   editbatch.clickedit();	
       editbatch.updateinvalidvalues();
	}

	@When("Erase data from mandatory field")
	public void erase_data_from_mandatory_field() {
	  editbatch.clickedit();	
      editbatch.erasemandatory();
	}

	@When("Erase data from description field")
	public void erase_data_from_description_field() {

	}

}
