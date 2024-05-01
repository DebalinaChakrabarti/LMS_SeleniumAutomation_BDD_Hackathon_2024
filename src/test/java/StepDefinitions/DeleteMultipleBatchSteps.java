package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DriverFactory.DriverFactory;
import PageObjects.DeleteBatch;
import PageObjects.DeleteMultipleBatches;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteMultipleBatchSteps {

	private static final Logger logger = LogManager.getLogger(DeleteMultipleBatchSteps.class);

	private DeleteMultipleBatches delmultiple = new DeleteMultipleBatches(DriverFactory.getDriver());

	@Given("None of the checkboxes in data table are selected")
	public void none_of_the_checkboxes_in_data_table_are_selected() {

	}

	@Then("The delete icon under the {string} header should be disabled")
	public void the_delete_icon_under_the_header_should_be_disabled(String string) {
          delmultiple.checkdeletedisable();
	}

	@Given("One of the checkbox\\/ row is selected")
	public void one_of_the_checkbox_row_is_selected() {
         delmultiple.clicksingleicon(); 
	}

	@When("Click delete icon below {string} header")
	public void click_delete_icon_below_header(String string) {
         delmultiple.clicksingledelicon();
	}

	@Then("The respective row in the data table is deleted")
	public void the_respective_row_in_the_data_table_is_deleted() {

	}

	@Given("Two or more checkboxes\\/row is selected")
	public void two_or_more_checkboxes_row_is_selected() {
         delmultiple.deletemultirow();
	}
	
	@Then("The respective row in the table is deleted")
	public void the_respective_row_in_the_table_is_deleted() {
         delmultiple.alertwindow();
	}	
}
