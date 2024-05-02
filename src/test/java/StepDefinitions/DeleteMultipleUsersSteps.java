package StepDefinitions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import DriverFactory.DriverFactory;
import PageObjects.DeleteMultipleUsers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteMultipleUsersSteps {

	private static final Logger logger = LogManager.getLogger(DeleteMultipleUsersSteps.class);

	private DeleteMultipleUsers delmultiple = new DeleteMultipleUsers(DriverFactory.getDriver());
	private DeleteMultipleUsers userPage = new DeleteMultipleUsers(DriverFactory.getDriver());

	@Given("None of the checkboxes in data table are selected.")
	public void none_of_the_checkboxes_in_data_table_are_selected() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//userPage.clickOnUserTab();
	}

	@Then("The delete icon under the {string} header should be disabled.")
	public void the_delete_icon_under_the_header_should_be_disabled(String string) {
          delmultiple.checkdeletedisable();
	}

	@Given("One checkbox is selected.")
	public void One_checkbox_is_selected() {
         delmultiple.clicksingleicon(); 
	}

	@When("Click delete below Manage User header.")
	public void Click_delete_below_Manage_User_header() throws InterruptedException{
         Thread.sleep(2000);
		delmultiple.clicksingledelicon();
	}

	@Then("The respective row in the data table is deleted.")
	public void the_respective_row_in_the_data_table_is_deleted() throws InterruptedException {
		   delmultiple.alertwindow();
	}

	@Given("Two or more checkboxes are selected in the user data table.")
	public void Two_or_more_checkboxes_are_elected_in_the_user_data_table() {
         
         
	}
	@When("Click del button below Manage User header.")
	public void click_del_button_below_Manage_User_header(){
		delmultiple.deletemultirow();
	}	
	
	@Then("The respective row in the table is deleted.")
	public void the_respective_row_in_the_table_is_deleted() throws InterruptedException {
         delmultiple.alertwindow();
	}	
	
	
}
