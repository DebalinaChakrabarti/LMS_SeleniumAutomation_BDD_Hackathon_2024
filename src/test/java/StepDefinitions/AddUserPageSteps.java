package StepDefinitions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import PageObjects.addUserPage;
import Utilities.ExcelReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddUserPageSteps {
	
	public boolean addUser;
	public String popUp;
	 int rownumber;
	 public String sheetName;

	private WebDriver driver = DriverFactory.getDriver();
private addUserPage addUserPg = new addUserPage(DriverFactory.getDriver());
	
	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {
	   
	}

	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) {
	   addUserPg.clickAddNewUser();
	}

	@Then("Admin should see a pop-up open for user details with the following <fields>")
	public void admin_should_see_a_pop_up_open_for_user_details_with_the_following_fields(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	   addUser = addUserPg.AddNewUserValidate();
	    if(addUser) {
	    	
	 		    System.out.println("User details popup with all fields and buttons is displayed.");
	 	    } else {
	 	        System.out.println("User details popup is not displayed with all fields and buttons.");
	 	    }
	 	
	    //addUserPg.closeAddUser();
	}

	@Given("Admin is on Add New User popup window")
	public void admin_is_on_add_new_user_popup_window() throws InterruptedException {
//	   addUserPg.popUpWindow();
//	    System.out.println("User details popup with all fields text box is displayed." + popUp );
	    
	}
	
	@Then("Admin should see text boxes for the <names>")
	public void admin_should_see_text_boxes_for_the_fields(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    addUserPg.UserTextBoxes();}
//	    if(addUserPg.UserTextBoxes()) {
//	    System.out.println("User details popup with all fields text box is displayed.");
//    } else {
//        System.out.println("User details popup is not displayed with text boxes.");
//    }}
	   

	@Then("Admin should see drop-downs for the <fieldsNames>")
	public void admin_should_see_drop_downs_for_the_fieldsNames() {
	   
		DataTable dataTable = null;
		List<String> fieldsNames = dataTable.asList();
		    boolean allDropdownsDisplayed = addUserPg.dropDownFields(fieldsNames);

		    if (allDropdownsDisplayed) {
		        System.out.println("All dropdowns for fields: " + fieldsNames + " are visible.");
		    } else {
		        System.out.println("Not all dropdowns for fields: " + fieldsNames + " are visible.");
		    }
		}
	


	@Given("Admin is on the User details pop-up")
	public void admin_is_on_the_user_details_pop_up() {
	    
	}

	@When("Admin enters mandatory fields in the form and clicks on the submit button from  {string} {int}")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_the_submit_button_from(String sheetName, Integer rownumber) throws IOException, InterruptedException {

		String filePath = System.getProperty("user.dir") +  "/src/test/resources/Test_Data/LMS_Data.xlsx";
	    System.out.println(filePath);
	    ExcelReader sheetReader = new ExcelReader();

	    List<Map<String, String>> data = sheetReader.getData(filePath, sheetName);
	    Map<String, String> userData = data.get(rownumber);
	    System.out.println("User Data from Excel: " + userData); // Print userData to verify its contents

	    addUserPage.enterMandatoryFields(userData);
	    //addUserPage.clickSubmit();
	    Thread.sleep(2000);
	    
	    addUserPg.clickClose();
	        }
	
	@Then("Admin gets a message {string}")
	public void admin_gets_a_message(String string) {
	   addUserPg.getSucessMsg();
	}

	@When("Admin skips mandatory fields in the form and clicks on the submit button from  {string} {int}")
	public void admin_skips_mandatory_fields_in_the_form_and_clicks_on_the_submit_button_from(String sheetName, Integer rownumber) throws IOException, InterruptedException {

		String filePath = System.getProperty("user.dir") +  "/src/test/resources/Test_Data/LMS_Data.xlsx";
	    System.out.println(filePath);
	    ExcelReader sheetReader = new ExcelReader();

	    List<Map<String, String>> data = sheetReader.getData(filePath, sheetName);
	   
		Map<String, String> userData = data.get(rownumber);
	    System.out.println("User Data from Excel: " + userData); // Print userData to verify its contents
		addUserPage.missMandatoryFields(userData);
		    addUserPage.clickSubmit();
//		  addUserPg.clickClose();
	}

	@Then("Admin should see an error message below the fields and the fields will be highlighted in red color")
	public void admin_should_see_an_error_message_below_the_fields_and_the_fields_will_be_highlighted_in_red_color() throws InterruptedException {
	    addUserPg.ErrorMsg();
	    Thread.sleep(5000);
	    addUserPg.clickClose();
	}

@When("Admin enters invalid data in all of the fields in the form and clicks on the submit button from {string} {int}")
public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_the_submit_button_from(String sheetName, Integer rownumber) throws IOException, InterruptedException {
	String filePath = System.getProperty("user.dir") + "/src/test/resources/Test_Data/LMS_Data.xlsx";
    System.out.println(filePath);
    ExcelReader sheetReader = new ExcelReader();

    List<Map<String, String>> data = sheetReader.getData(filePath, sheetName);
   
	Map<String, String> userData = data.get(rownumber);
    System.out.println("User Data from Excel: " + userData); // Print userData to verify its contents
	addUserPage.enterMandatoryFields(userData);
	    addUserPage.clickSubmit();
}

@Then("Admin gets an error message and user is not created")
public void admin_gets_an_error_message_and_user_is_not_created() throws InterruptedException {
   Assert.assertTrue(addUserPg.getErrorMsg());
   
  //Thread.sleep(2000);
//   addUserPg.clickClose();
}

@When("Admin clicks on the submit button without entering data")
public void admin_clicks_on_the_submit_button_without_entering_data() throws InterruptedException {
    Thread.sleep(3000);
	addUserPage.clickSubmit();
}

@Then("user wont be created and Admin gets an error message")
public void user_wont_be_created_and_admin_gets_an_error_message() throws InterruptedException {
    addUserPg.ErrorMsg();
    Thread.sleep(3000);
    addUserPg.clickClose();
}

@When("Admin clicks Close Icon on User Details form")
public void admin_clicks_cancel_close_icon_on_user_details_form() throws InterruptedException {
	Thread.sleep(3000);
	addUserPg.clickClose();
}

@Then("User Details popup window should be closed without saving")
public void user_details_popup_window_should_be_closed_without_saving() {
   addUserPg.isUserDetailsPopupOpen();
  // System.out.println( "popup window is closed + " addUserPg.isUserDetailsPopupOpen());
   }

@When("Admin clicks Cancel button")
public void admin_clicks_cancel_button() throws InterruptedException {
	Thread.sleep(2000); 
	addUserPg.clickCancle();
}

//@Then("Admin can see the User details popup disappears without adding any user")
//public void admin_can_see_the_user_details_popup_disappears_without_adding_any_user() {
//   
//}

@When("Admin fills in all the fields with valid values and clicks submit from {string} {int}")
public void admin_fills_in_all_the_fields_with_valid_values_and_clicks_submit_from(String sheetName, Integer rownumber) throws IOException, InterruptedException  {
	String filePath = System.getProperty("user.dir") + "/src/test/resources/Book1.xlsx";
    System.out.println(filePath);
    ExcelReader sheetReader = new ExcelReader();

    List<Map<String, String>> data = sheetReader.getData(filePath, sheetName);
   
	Map<String, String> userData = data.get(rownumber);
    System.out.println("User Data from Excel: " + userData); // Print userData to verify its contents
	addUserPage.enterMandatoryFields(userData);
	    addUserPage.clickSubmit();
}

@Then("the newly added user should be present in the data table in Manage User page")
public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() {
   addUserPg.getSucessMsg();
   addUserPg.searchNewUser();
	System.out.println("Valid user name entered is "  + addUserPg.searchNewUser());
}
}