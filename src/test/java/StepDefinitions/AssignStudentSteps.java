//package StepDefinitions;
//
//import java.util.NoSuchElementException;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import DriverFactory.DriverFactory;
//
//import PageObjects.AssignStudentPage;
//import PageObjects.DeleteUser;
//import io.cucumber.java.en.*;
//
//public class AssignStudentSteps {
//	
//	private static final Logger logger = LogManager.getLogger(AssignStudentSteps.class);
//
//	
//	private AssignStudentPage userPage = new AssignStudentPage(DriverFactory.getDriver());
//	
//	
//	@Given("Admin is on Manage User Page")
//	public void admin_is_on_manage_user_page() throws InterruptedException {
//		
//		try {
//			userPage.clickOnUserTab();
//			
//		} catch (NoSuchElementException ex) {
//			System.out.println("NoSuchElementException has been handled.");
//	    }
//	}
//
//	@When("Admin clicks {string} button")
//	public void admin_clicks_button(String string) {
//	    userPage.AssignStudentModule();
//	}
//
//	@Then("Admin should see a pop up open with empty form along with Save and Cancel button and close icon")
//	public void admin_should_see_a_pop_up_open_with_empty_form_along_with_save_and_cancel_button_and_close_icon() {
//		userPage.AssignStudentFormVisibile();
//		
//	}
//	
//	@Then("Admin is able to see user role as R03 and below input {string} on form")
//	public void admin_is_able_to_see_user_role_as_r03_and_below_input_on_form(String fieldname) {
//	   
//		if (fieldname.equalsIgnoreCase("User Role")) {
//			userPage.AssignStudentFormRoleid();
//			
//		}
//		else if(fieldname.equalsIgnoreCase("Student Email id")) {
//			userPage.AssignStudentFormEmailid();
//		}
//			else if(fieldname.equalsIgnoreCase("Program Name")) {
//				userPage.AssignStudentFormProgramName();
//			}	
//		
//			else if(fieldname.equalsIgnoreCase("Batch Name")) {
//				userPage.AssignStudentFormBatchName();
//			}
//		
//			else  {
//				userPage.AssignStudentFormStatus();
//				//(fieldname.equalsIgnoreCase("Status"))
//			}	
//	}
//	
//}
