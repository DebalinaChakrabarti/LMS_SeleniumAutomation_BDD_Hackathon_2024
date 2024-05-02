package StepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DriverFactory.DriverFactory;
import PageObjects.AssignStaffPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignStaffSteps {
     
	private static final Logger logger = LogManager.getLogger(AssignStaffSteps.class);

	private AssignStaffPage userPage = new AssignStaffPage(DriverFactory.getDriver());
	
	@Given("Admin is on User Page..")
	public void admin_is_on_User_page() throws InterruptedException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		userPage.clickOnUserTab();
	}

	@When("Admin clicks on {string} button..")
	public void admin_clicks_button(String string) {
	    userPage.AssignStaffModule();
	}

	@Then("User should see a pop up open for assign staff with empty form along with Save and Cancel button and close icon on the top..")
	public void User_should_see_a_pop_up_open_for_assign_staff_with_save_and_cancel_button_and_close_icon_on_the_top() {
		userPage.AssignStaffFormVisibile();
		
	}
}
