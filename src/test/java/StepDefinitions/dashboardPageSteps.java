package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import PageObjects.dashboardPage;
import PageObjects.loginpage;
import Utilities.ExcelReader;
import io.cucumber.java.en.Then;

public class dashboardPageSteps {

	private dashboardPage dashboardpg = new dashboardPage(DriverFactory.getDriver());

	@Then("Admin should see manage program as header")
	public void Admin_should_land_on_dashboard_page() throws InterruptedException {
		Assert.assertTrue(dashboardpg.getManageprogrameBtnLabelText().trim().contains("Manage Program"),
				"'Dashboard - Manage Program' page is not displayed");
		System.out.println("'Dashboard - Manage Program' page is displayed");
//Test
	}

	@Then("Maximum navigation time in milliseconds, defaults to 30 seconds")
	public void Maximum_navigation_time_dashboard() {

		if (dashboardpg.navigation_Time() <= 30) {
			Assert.assertTrue(true, "Dashboard page navigation time is " + dashboardpg.navigation_Time());
		} else {
			Assert.assertTrue(false, "Dashboard page navigation time is " + dashboardpg.navigation_Time());
		}
	}

	@Then("Admin should see LMS -Learning management system  as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		Assert.assertTrue(
				dashboardpg.getLearningManagementSystemTitle().trim().contains("LMS - Learning Management System"),
				"'Dashboard -LMS - Learning Management System' page is not displayed");
		System.out.println("'Dashboard - LMS - Learning Management System' page is displayed");

	}

	@Then("Admin should see correct spelling in navigation bar text for {string}")
	public void admin_should_see_correct_spelling_in_navigation_bar_text(String expField) {
		if (expField.contains("Program")) {
			Assert.assertTrue(dashboardpg.getProgrambuttonlink().contains("Program"),
					"'Program' spelling is  not as expected");
			System.out.println("'Program' spelling is as expected");
		} else if (expField.contains("Batch")) {
			Assert.assertTrue(dashboardpg.getbatchbuttonlink().contains("Batch"),
					"'Batch' spelling is  not as expected");
			System.out.println("'Batch' spelling is as expected");
		} else if (expField.contains("User")) {
			Assert.assertTrue(dashboardpg.getuserbuttonlink().contains("User"), "'User' spelling is  not as expected");
			System.out.println("'User' spelling is as expected");
		} else if (expField.contains("Logout")) {
			Assert.assertTrue(dashboardpg.getlogoutbuttonlink().contains("Logout"),
					"'Logout' spelling is  not as expected");
			System.out.println("'Logout' spelling is as expected");

		}

	}

	@Then("Admin should see correct {int} order in navigation bar text for {string}")
	public void admin_should_see_correct_order_in_navigation(int order, String expField) {
		dashboardpg.getorder(order, expField);
	}

	
	
	@Then ("Admin should see {string} is aligned as expected on navigation bar of DashboardPage")
	public void alignmentLMSTitleValidation(String fieldName)
	{
			if(fieldName.contains("LMS"))
			{
			Assert.assertTrue(dashboardpg.getLMSTitleposition().trim().contains("start"),
					"LMS Title is not left alligned on navigation bar");
			System.out.println("LMS Title is left alligned on navigation bar");
			}
			else if (fieldName.contains("Program"))
			{
				Assert.assertTrue(dashboardpg.getProgrambuttonFieldposition().trim().contains("center"),
						"Program button is not center alligned on navigation bar");
				System.out.println("Program button is center alligned on navigation bar");
			}
			else if (fieldName.contains("Batch"))
			{
				Assert.assertTrue(dashboardpg.getBatchbuttonFieldposition().trim().contains("center"),
						"Batch button is not center alligned on navigation bar");
				System.out.println("Batch button is center alligned on navigation bar");
			}
			else if (fieldName.contains("User"))
			{
				Assert.assertTrue(dashboardpg.getUserbuttonFieldposition().trim().contains("center"),
						"User button is not center alligned on navigation bar");
				System.out.println("User button is center alligned on navigation bar");
			}
			else if (fieldName.contains("Logout"))
			{
				Assert.assertTrue(dashboardpg.getLogoutbuttonFieldposition().trim().contains("center"),
						"Logout button is not center alligned on navigation bar");
				System.out.println("Logout button is center alligned on navigation bar");
			}
			
		
	}

}
