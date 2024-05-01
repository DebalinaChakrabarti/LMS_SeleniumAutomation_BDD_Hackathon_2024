package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import PageObjects.Program;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProgramSortingSteps {

//	private static final Logger logger = LogManager.getLogger(ProgramSortingSteps.class);
	private WebDriver driver = DriverFactory.getDriver();
	private Program programPage = new Program(DriverFactory.getDriver());

	
	@Given("Check if Admin is logged in or not for the Program Mdule")
	public void admin_is_logged_in() throws InterruptedException {
		LoggerLoad.info("ProgramSortingSteps---Admin is logged in");
		Thread.sleep(2000);
		Assert.assertEquals(programPage.checkLogoutLink(), true);//checking if logged in
		
	}

	@When("Admin clicks on {string} on the Navigation Bar to reach the Program module")
	public void admin_clicks_on_on_the_navigation_bar(String linkName) throws InterruptedException {
		LoggerLoad.info("ProgramSortingSteps---Admin clicks on Program on the Navigation Bar");
		if(linkName.equalsIgnoreCase("Program"))
		{
			Thread.sleep(2000);
			LoggerLoad.info("Admin clicks on {string} on the Navigation Bar" +linkName);
			programPage.clickProgramLink();
			
		}
	}

	@Then("Admin should be redirected to the Manage Program Page in the Program module")
	public void admin_should_be_redirected_to_the_manage_program_page() {
		LoggerLoad.info("ProgramSortingSteps---Admin should be redirected to the Manage Program Page");
		Assert.assertTrue(programPage.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	@Given("Admin is on Manage Program page in the Program module")
	public void admin_is_on_manage_program_page() {
		LoggerLoad.info("ProgramSortingSteps---Admin is on Manage Program page");		
		Assert.assertTrue(programPage.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	@When("Admin clicks the sort icon of program name column in the Program module")
	public void admin_clicks_the_sort_icon_of_program_name_column() {
		LoggerLoad.info("ProgramSortingSteps---Admin clicks the sort icon of program name column");
		programPage.clickProgramNameColumnHeader();
	}

	@Then("The data get sorted on the table based on the program name column values in ascending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order() {
		LoggerLoad.info("ProgramSortingSteps---The data get sorted on the table based on the program name column values in ascending order");
		programPage.getSortedProgramNameListAsc();
	}

	@Given("The data is in the ascending order on the table based on Program Name column in the Program module")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_name_column() {
		LoggerLoad.info("ProgramSortingSteps---The data is in the ascending order on the table based on Program Name column");
		//compare original vs sorted list
		  Assert.assertTrue(programPage.getOriginalProgramNameList().equals(programPage.getSortedProgramNameListAsc()));
	}
	@When("Admin clicks the sort icon of program name column to sort Program name in descending order in the Program module")
	public void admin_clicks_the_sort_icon_of_program_name_column_to_sort_program_name_in_descending_order() {
		LoggerLoad.info("ProgramSortingSteps---Admin clicks the sort icon of program name column to sort Program name in descending order");
		programPage.clickProgramNameColumnHeader();

	}

	@Then("The data get sorted on the table based on the program name column values in descending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() {
		LoggerLoad.info("ProgramSortingSteps---The data get sorted on the table based on the program name column values in descending order");
		programPage.getSortedProgramNameListDesc();
		Assert.assertTrue(programPage.getOriginalProgramNameList().equals(programPage.getSortedProgramNameListDesc()));
	}

	@When("Admin clicks the sort icon of program Desc column in the Program module")
	public void admin_clicks_the_sort_icon_of_program_desc_column() {
		LoggerLoad.info("ProgramSortingSteps---Admin clicks the sort icon of program Desc column");
		programPage.clickProgramDescColumnHeader();
	}

	@Then("The data get sorted on the table based on the program description column values in ascending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order() {
		LoggerLoad.info("ProgramSortingSteps---The data get sorted on the table based on the program description column values in ascending order");
		programPage.getSortedProgramDescriptionListAsc();
	}

	@Given("The data is in the ascending order on the table based on Program Description column in the Program module")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_description_column() {
		LoggerLoad.info("ProgramSortingSteps---The data is in the ascending order on the table based on Program Description column");  
		//compare original vs sorted list
		  Assert.assertTrue(programPage.getOriginalProgramDescList().equals(programPage.getSortedProgramDescriptionListAsc()));
	}

	@When("Admin clicks the sort icon of program Desc column to sort Program description in descending order in the Program module")
	public void admin_clicks_the_sort_icon_of_program_desc_column_to_sort_program_description_in_descending_order() {
		LoggerLoad.info("ProgramSortingSteps---Admin clicks the sort icon of program Desc column to sort Program description in descending order");
		programPage.clickProgramDescColumnHeader();
	}

	@Then("The data get sorted on the table based on the program description column values in descending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order() {
		LoggerLoad.info("ProgramSortingSteps---The data get sorted on the table based on the program description column values in descending order");
		programPage.getSortedProgramDescriptionListDesc();
		Assert.assertTrue(programPage.getOriginalProgramDescList().equals(programPage.getSortedProgramDescriptionListDesc()));
	}

	@When("Admin clicks the sort icon of program Status column in the Program module")
	public void admin_clicks_the_sort_icon_of_program_status_column() {
		LoggerLoad.info("ProgramSortingSteps---Admin clicks the sort icon of program Status column");
		programPage.clickProgramStatusColumnHeader();
	}

	@Then("The data get sorted on the table based on the program status column values in ascending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order() {
		LoggerLoad.info("ProgramSortingSteps---The data get sorted on the table based on the program status column values in ascending order");
		programPage.getSortedProgramStatusListAsc();
	}

	@Given("The data is in the ascending order on the table based on Program Status column in the Program module")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_status_column() {
		LoggerLoad.info("ProgramSortingSteps---The data is in the ascending order on the table based on Program Status column");
		Assert.assertTrue(programPage.getOriginalProgramStatusList().equals(programPage.getSortedProgramStatusListAsc()));
	}

	@When("Admin clicks the sort icon of program Status column to sort Program status in descending order in the Program module")
	public void admin_clicks_the_sort_icon_of_program_status_column_to_sort_program_status_in_descending_order() {
		LoggerLoad.info("ProgramSortingSteps---Admin clicks the sort icon of program Status column to sort Program status in descending order");
		programPage.clickProgramStatusColumnHeader();
	}
	
	@Then("The data get sorted on the table based on the program status column values in descending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order() {
		LoggerLoad.info("ProgramSortingSteps---The data get sorted on the table based on the program status column values in descending order");
		programPage.getSortedProgramStatusListDesc();
		Assert.assertTrue(programPage.getOriginalProgramStatusList().equals(programPage.getSortedProgramStatusListDesc()));
	}
}
