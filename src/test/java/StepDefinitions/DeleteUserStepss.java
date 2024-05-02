//package StepDefinitions;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import DriverFactory.DriverFactory;
//import PageObjects.DeleteUser;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class DeleteUserStepss {
//
//	
//		private static final Logger logger = LogManager.getLogger(DeleteUserStepss.class);
//        private DeleteUser del = new DeleteUser(DriverFactory.getDriver());
//		 private DeleteUser userPage = new DeleteUser(DriverFactory.getDriver());
//
//		@Given("The delete icon on row level in data table is enabled")
//		public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//			userPage.clickOnUserTab();
//			del.deleteenable(); 
//		}
//
//		@When("Admin click the delete icon")
//		public void admin_click_the_delete_icon() {
//	         del.clickdelete(); 
//		}
//
//		@Then("Alert appears with yes and No option")
//		public void alert_appears_with_yes_and_no_option() {
//	         //del.alertwindow();
//			 del.deluser();
//		}
//
//		@Given("Admin clicks the delete icon")
//		public void admin_clicks_the_delete_icon() {
//			//del.clickdelete();
//		}
//
//		@When("You click yes option")
//		public void you_click_yes_option() {
//	       // del.deluser();
//		}
//
//		@Then("User deleted alert pops and user is no more available in data table")
//		public void User_deleted_alert_pops_and_user_is_no_more_available_in_data_table() {
//               System.out.println("User delted successfully");
//		}
//
//		@When("you click No option")
//		public void you_click_no_option() {
//	        //del.notdeleteuser();
//		}
//
//		@Then("User is still listed in data table")
//		public void batch_is_still_listed_in_data_table() {
//			System.out.println("User not deleted.");
//		}
//
//	}
