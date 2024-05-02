package StepDefinitions;


import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import DriverFactory.DriverFactory;
import PageObjects.addUserPage;
import PageObjects.editUserPage;
import Utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditUserPageSteps {
	
	
//	public boolean addUser;
//	public String popUp;
	 int rownumber;
	 public String sheetName;

	private WebDriver driver = DriverFactory.getDriver();
private editUserPage editPg = new editUserPage(DriverFactory.getDriver());
private addUserPage addPg = new addUserPage(DriverFactory.getDriver());
	
@When("Admin clicks on the edit icon")
public void admin_clicks_on_the_edit_icon() throws InterruptedException {
	Thread.sleep(2000);
	editPg.searchUser();
	System.out.println("Valid user name entered is "  + editPg.searchUser());
	
	editPg.clickOnEdit();
    
}

@Then("A new pop up with User details appears")
public void a_new_pop_up_with_user_details_appears() {
	editPg.isUserDetailsPopupOpen();
	addPg.clickClose();
}

@When("Admin updates user form with valid values and submits from {string} {int}")
public void admin_updates_user_form_with_valid_values_and_submits_from(String sheetName, Integer rownumber) throws InterruptedException {
editPg.clearFeildNames();
	
	String filePath = System.getProperty("user.dir") + "/src/test/resources/Test_Data/LMS_Data.xlsx";
    System.out.println(filePath);
    ExcelReader sheetReader = new ExcelReader();

    List<Map<String, String>> data = sheetReader.getData(filePath, sheetName);
   
	Map<String, String> userData = data.get(rownumber);
    System.out.println("User Data from Excel: " + userData); // Print userData to verify its contents
	addPg.missMandatoryFields(userData);
	    addPg.clickSubmit();
}

@Then("User updated Successfully is displayed")
public void user_updated_successfully_is_displayed() {
	 editPg.getsucessUpdateMsg();
	    editPg.searchUser();
		System.out.println("Valid user name entered is "  + editPg.searchUser());
}

@When("Admin updates user form with invalid values and submits from {string} {int}")
public void admin_updates_user_form_with_invalid_values_and_submits_from(String sheetName, Integer rownumber) throws InterruptedException {
   
	String filePath = System.getProperty("user.dir") + "/src/test/resources/Test_Data/LMS_Data.xlsx";
    System.out.println(filePath);
    ExcelReader sheetReader = new ExcelReader();

    List<Map<String, String>> data = sheetReader.getData(filePath, sheetName);
   
	Map<String, String> userData = data.get(rownumber);
    System.out.println("User Data from Excel: " + userData); // Print userData to verify its contents
	addPg.missMandatoryFields(userData);
	    addPg.clickSubmit();
}

@Then("Error message is received is displayed")
public void error_message_is_received_is_displayed() {
   editPg.getfailedUpdateMsg();
}

@When("Admin updates user form with optional valid values and submits from {string} {int}")
public void admin_updates_user_form_with_optional_valid_values_and_submits_from(String string, Integer int1) throws InterruptedException {

	String filePath = System.getProperty("user.dir") + "/src/test/resources/Test_Data/LMS_Data.xlsx";
    System.out.println(filePath);
    ExcelReader sheetReader = new ExcelReader();

    List<Map<String, String>> data = sheetReader.getData(filePath, sheetName);
   
	Map<String, String> userData = data.get(rownumber);
    System.out.println("User Data from Excel: " + userData); // Print userData to verify its contents
	addPg.missMandatoryFields(userData);
	
	//    addPg.clickClose();  
}

@Given("Admin is on User details pop up")
public void admin_is_on_user_details_pop_up() {
	editPg.searchUser();
	editPg.clickOnEdit();
}


} 