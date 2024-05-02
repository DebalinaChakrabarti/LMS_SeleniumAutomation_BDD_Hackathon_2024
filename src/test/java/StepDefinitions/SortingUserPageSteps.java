package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import DriverFactory.DriverFactory;
import PageObjects.addUserPage;
import PageObjects.sortUserPage;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortingUserPageSteps {
	
	
	private WebDriver driver = DriverFactory.getDriver();
    private sortUserPage sortPg = new sortUserPage(DriverFactory.getDriver());

@When("Admin clicks on ID sort icon")
public void admin_clicks_on_id_sort_icon() throws InterruptedException {
//    sortPg.clearSeactchBox();
	sortPg.clickPrgButton();
	Thread.sleep(2000);
	sortPg.clickOnUserTab();
    Thread.sleep(4000);
	sortPg.clickColumIDHeader();
}

@Then("Admin should see User details are sorted by ID")
public void admin_should_see_user_details_are_sorted_by_id() {
	
	 assertTrue(sortPg.isUserDetailsSortedByID());
	
}

	
@When("Admin clicks on name sort icon")
public void admin_clicks_on_name_sort_icon() throws InterruptedException {
    Thread.sleep(2000);
	sortPg.clickColumnNameHeader();
}

@Then("Admin should see User details are sorted by Name")
public void admin_should_see_user_details_are_sorted_by_name() throws InterruptedException {

	assertTrue(sortPg.isUserDetailsSortedByName());
   Thread.sleep(2000);
}

@When("Admin clicks on Location sort icon")
public void admin_clicks_on_location_sort_icon() {
	sortPg.clickColumnLocationHeader();
}

@Then("Admin should see User details are sorted by Location")
public void admin_should_see_user_details_are_sorted_by_location() {
	assertTrue(sortPg.isUserDetailsSortedByLocation());
}

@When("Admin clicks on Phone number sort icon")
public void admin_clicks_on_phone_number_sort_icon() {
	sortPg.clickColumnPhoneNoHeader();
}

@Then("Admin should see User details are sorted by Phone number")
public void admin_should_see_user_details_are_sorted_by_phone_number() {
	assertTrue(sortPg.isUserDetailsSortedByPhoneNo());
}
}