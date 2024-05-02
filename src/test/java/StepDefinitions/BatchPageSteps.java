package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DriverFactory.DriverFactory;
import PageObjects.BatchPageVerification;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchPageSteps {
	
	private static final Logger logger = LogManager.getLogger(BatchPageSteps.class); 

	private BatchPageVerification batchPageverify = new BatchPageVerification(DriverFactory.getDriver());
	

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {

	} 

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) {
          batchPageverify.clickbatch();
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String string) {
         batchPageverify.checkurl(); 
	}
	
	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String string) {
		batchPageverify.checkheader();
	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
        batchPageverify.checkpaginator();
	}

	@Then("Admin Should see the data table with headers Batch name, Batch Description etc")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_etc() {
       batchPageverify.checktableheader(); 
	}

	@Then("Admin should be able to see the {string} icon button that is disabled")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled(String string) {
       batchPageverify.checkdisabledeleteicon();
	}

	@Then("Admin should be able to see the {string} button")
	public void admin_should_be_able_to_see_the_button(String string) {
       batchPageverify.checknewbatch(); 
	}

	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() {
       batchPageverify.batchcheckbox();
	}

	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
       batchPageverify.checkediticon();
	}

	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
       batchPageverify.checkdeleteicon();
	}

	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) {
       batchPageverify.clicknewbatch();
	}

	@Then("A new pop up with Batch details appears")
	public void a_new_pop_up_with_batch_details_appears() {
       batchPageverify.checknewbatchdetails();
	}	
}
