package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;

import PageObjects.userPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserPageSteps {
	public String url;
	public String PgHeading;
	public boolean Pgicon;
	public boolean PgText;
	public boolean colID;
	public boolean colName;
	public boolean colLocation;
	public boolean colPhNo;
	public boolean colEdit;
	public boolean newUser;
	public boolean student;
	public boolean staff;
	public boolean textBox;
	int totalCheckBoxes;
    public boolean editIcon;
    public boolean deleteIcon;
	public String search;
	public String search1;
	public String result;
	public boolean result1;
	
	
	
	private WebDriver driver = DriverFactory.getDriver();
	private userPage userPg = new userPage(DriverFactory.getDriver());
	
	@SuppressWarnings("deprecation")
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() throws Exception {
		//Thread.sleep(500);
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) {
	   	userPg.clickOnUserTab();
	}

	@Then("Admin should see {string} on the page url")
	public void Admin_should_see_on_the_page_url(String string) {
		 url = userPg.getUserPageURL();
	     System.out.println("the current url is "  + url);
//	     Assert.assertEquals("URL contains: " +  "user", url);
//	     Assert.assertEquals("URL contains: " +  "user", url);
	     Assert.assertTrue("URL contain 'user'", url.contains("user"));
	}
	

	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String string) {
	  PgHeading =  userPg.getPageHeading();
	  System.out.println("User Module Page heading is "  + PgHeading);
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table on the page")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table_on_the_page(String string) {
		Pgicon = userPg.isPaginationIconDisplayed();
     PgText = userPg.isPaginationTextDisplayed();
     System.out.println("Pagination icon displayed: "  +  Pgicon );
     System.out.println("Pagination text displayed: " +  PgText );
      Assert.assertTrue("Pgination icon is not displayed", Pgicon);
	
	}

	@Then("Admin should see cloumname Id is visible on the page")
	public void admin_should_see_cloumname_id_is_visible_on_the_page() {
	   colID = userPg.isColumnIDDisplayed();
	   System.out.println("Coulm Id is visible on the page "  +  colID );
	   Assert.assertTrue("Column ID is not displayed", userPg.isColumnIDDisplayed());
	}

	@Then("Admin should see cloumname Name is visible on the page")
	public void admin_should_see_cloumname_name_is_visible_name_on_the_page() {
	   colName = userPg.isColumnNameDisplayed();
	   System.out.println("cloum Name is visible on the page "  +  colName );
	}

	@Then("Admin should see cloumname Location is visible on the page")
	public void admin_should_see_cloumname_location_is_visible_on_the_page() {
	  colLocation =  userPg.isColumnLocationDisplayed();
	   System.out.println("cloumName Location is visible on the page "  +  colLocation );   
	}

	@Then("Admin should see cloumname Phone Number is visible on the page")
	public void admin_should_see_cloumname_phone_number_is_visible_on_the_page() {
	   colPhNo =  userPg.isColumnPhoneNoDisplayed();
	    System.out.println("cloumName Phone Number is visible on the page "  +  colPhNo );
	}

	@Then("Admin should see cloumname Edit\\/Delete is visible on the page")
	public void admin_should_see_cloumname_edit_delete_is_visible_on_the_page() {
	   colEdit =  userPg.isColumnEditDisplayed();
	    System.out.println("cloumName Edit/Delete is visible on the page "  +  colEdit );
	}

	@Then("Admin should see {string} button above the data table on the page")
	public void admin_should_see_button_above_the_data_table_on_the_page(String string) {
	  newUser =  userPg.isAddNewUserDisplayed();
	    System.out.println("+ A New User is visible on the page "  +  newUser );
	 staff =    userPg.isAssignStaffDisplayed();
	    System.out.println("+ A Assign staff is visible on the page "  +  staff );
	 student =    userPg.isAssignStudentDisplayed();
	    System.out.println("+ A Assign student is visible on the page "  +  student );
	}

	@Then("Admin should see search text box above the data table on the page")
	public void admin_should_see_search_text_box_above_the_data_table_on_the_page() {
	    textBox = userPg.isSearchTextBoxVisible();
	    System.out.println("search text box is visible on the page "  +  textBox );
	}

	@Then("Admin should see records displayed on the data table on the page")
	public void admin_should_see_records_displayed_on_the_data_table_on_the_page() {
	  userPg.isDataTableVisible();
	  // Asserting that the actual count matches the expected count
	    int expectedRowCount = 5;
	    Assert.assertEquals("Number of records displayed doesn't match the expected count", expectedRowCount, 5);
   
	}

	@Then("Admin should see each row in the data table should have a checkbox on the page")
	public void admin_should_see_each_row_in_the_data_table_should_have_a_checkbox_on_the_page() {
		 totalCheckBoxes = userPg.isCheckBoxVisible();
	    
//	    // Printing the total number of checkboxes found
	    System.out.println("Total number of checkboxes found in the data table: " + totalCheckBoxes);
       
     // Printing the number of rows with checkboxes
        System.out.println("Number of rows with checkboxes: " + totalCheckBoxes);
        
        // Asserting that at least one row has a checkbox
        Assert.assertTrue("No row contains a checkbox", totalCheckBoxes > 0);
	    // Asserting that at least one checkbox is present in the row
	    Assert.assertTrue("No checkbox found in any row", totalCheckBoxes > 0);
	}
	
	@Then("Admin should see each row in the data table should have an enabled {string} on the page")
	public void admin_should_see_each_row_in_the_data_table_should_have_an_enabled_on_the_page(String string) {
		editIcon =  userPg.isEditButtonEnabled();
		   System.out.println("Each row displayed with enabled editIcon: " + editIcon);
		   // Asserting that the edit icon is present and enabled in the row
	         Assert.assertTrue("Edit icon is not present or enabled in a row", editIcon);
	         
	         deleteIcon =  userPg.isDeleteButtonEnabled();
			   System.out.println("Each row displayed with enabled deleteIcon: " + deleteIcon);
			   // Asserting that the edit icon is present and enabled in the row
		         Assert.assertTrue("Deletet icon is not present or enabled in a row", deleteIcon);
		}
	

    @Given("Admin is on Mange user page")
    public void admin_is_on_mange_user_page() {
//    	driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
    	userPg.getPageHeading();
	System.out.println("User Module Page heading is "  + PgHeading);
	
}
    
    @When("When Admin enters valid user in Search box")
    public void when_admin_enters_valid_user_in_search_box(io.cucumber.datatable.DataTable dataTable) {
//    	driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
    	search  = userPg.enterValidUser();
    	System.out.println("Valid user name entered is "  + search);
    	
    }

    @When("When Admin enters invalid user in Search box")
    public void when_admin_enters_invalid_user_in_search_box(io.cucumber.datatable.DataTable dataTable) {
    	 userPg.enterInValidUser();
    	System.out.println("Valid user name entered is "  +  userPg.enterInValidUser());
    }
    
    
	@Then("Admin should see user displayed with the entered name")
	public void admin_should_see_user_displayed_with_the_entered_name() throws InterruptedException {
	   result = userPg.searchedValidUser();
	   System.out.println("name of the user searched is "  + search);
   	Assert.assertTrue("Search result not found", result.contains("Testing Squad"));
	}


	@Then("Admin should see zero entries on the data table")
	public void admin_should_see_zero_entries_on_the_data_table() throws InterruptedException {

		   System.out.println("name of the user searched is "  + search1);
	Assert.assertTrue("Search result not found", userPg.searchedInValidUser());
		}



}
	