package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DriverFactory.DriverFactory;
import PageObjects.AddNewBatch;
import PageObjects.BatchPageVerification;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewBatchSteps {

	private static final Logger logger = LogManager.getLogger(AddNewBatchSteps.class);

	private AddNewBatch addnew = new AddNewBatch(DriverFactory.getDriver());

	@Then("The pop up should include these Batch Name")
	public void the_pop_up_should_include_these_batch_name() {
       addnew.newbatchname();
	}

	@Then("The pop up should include these Description")
	public void the_pop_up_should_include_these_description() {
       addnew.newbatchdesc();
	}

	@Then("The pop up should include these Program Name") 
	public void the_pop_up_should_include_these_program_name() {
       addnew.newpgmname();
	}

	@Then("The pop up should include these Status")
	public void the_pop_up_should_include_these_status() {
       addnew.newstatus();
	}

	@Then("The pop up should include these No of Classes")
	public void the_pop_up_should_include_these_no_of_classes() {
       addnew.newclasses();
	}
	@When("Fill in all the fields except description")
	public void fill_in_all_the_fields_except_description() {

	}

	@Then("The newly added batch should be present in the data table")
	public void the_newly_added_batch_should_be_present_in_the_data_table() {

	}

	@When("Fill in all the fields with valid values and click save")
	public void fill_in_all_the_fields_with_valid_values_and_click_save() {
       addnew.fillallfields();
	}

	@Given("A new pop up with Batch details appear")
	public void a_new_pop_up_with_batch_details_appear() {
		addnew.clicknewbatch();
	}

	@When("any of the fields have invalid values")
	public void any_of_the_fields_have_invalid_values() throws InterruptedException {
		Thread.sleep(2000);
      addnew.invalidfields();
	}

	@Then("Error message should appear")
	public void error_message_should_appear() {

	}

	@When("Any of the mandatory fields are blank")
	public void any_of_the_mandatory_fields_are_blank() throws InterruptedException {
		Thread.sleep(2000);
       addnew.missingfields();
	}	
}
