//package StepDefinitions;
//
//
//import java.io.IOException;
//import java.util.*;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.Assert;
//import org.openqa.selenium.WebDriver;
//
//import DriverFactory.DriverFactory;
//import PageObjects.ArrayPage;
//import PageObjects.HomePage;
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//
//public class ArrayPageSteps {
//	
//	private static final Logger logger = LogManager.getLogger(ArrayPageSteps.class);
//
//	private ArrayPage arrayPage = new ArrayPage(DriverFactory.getDriver());
//	private HomePage homePage = new HomePage(DriverFactory.getDriver());
//
//	
//	
//	@When("The user clicks {string} on Array Page")
//    public void the_user_clicks_button_on_array_page(String string) throws InterruptedException {
//		arrayPage.navigateInArray(string);
//	}
//	 
//	 @Given ("The user is on the {string} of Array Page")
//	 public void the_user_is_on_of_array(String expectedTitle) {
//		 String Title = homePage.getPageTitle();
//			System.out.println("The title of the Page is " + Title  + "The expected title is " + expectedTitle);
//			Assert.assertTrue(Title.contentEquals(expectedTitle)); 
//			logger.info("----------page name------------------");
//	 }
//
//    @Given("user is on {string} of Array Page")
//    public void the_user_is_on_array_page(String expectedTitle) {
// 	   	arrayPage.getPracticeQuestUrl();
// 	   String Title = homePage.getPageTitle();
//    System.out.println("The title of the Page is " + Title +  " The expected title is " + expectedTitle);
//    Assert.assertTrue(Title.contentEquals(expectedTitle)); 
// }
//    
//
//    @Then("user navigates to Assessment page with Run button to test")
//    public void user_navigates_to_Assessment_page_with_run_button_to_test() {
//       	 homePage.getPageTitle();
//        System.out.println("The title of the Page is Assessment" );
//       
//}
//    
//    @And("user is on question {string} page with Run button to test")
//    public void user_is_on_question_page_with_run_button_to_test(String expectedTitle) {
//       	 String Title = homePage.getPageTitle();
//        System.out.println("The title of the Page is " + Title +  " The expected title is " + expectedTitle );
//        Assert.assertTrue(Title.contentEquals(expectedTitle)); 
//    }
//     
//    @When("user enters following python code in tryEditor")
//    public void user_enters_following_python_code_in_tryEditor(DataTable dataTable) throws InterruptedException {
//  	   List<String> userList = dataTable.asList(String.class);
//  	   for (String e : userList) {
//  	   arrayPage.clearCodeEditor();
//       arrayPage.fillCodeEditor(e);
//       System.out.println(e);			
//  	}
//  }
//
//      @When("user clicks on run button to test")
//       public void user_clicks_on_run_button_to_test() {
//    	       	arrayPage.clickOnRunButton();
//
//    }
//      @Then("The user should be presented with error message")
//      public void the_user_should_be_presented_with_error_message() throws InterruptedException {
//      		arrayPage.present_alertMsg();
//      		logger.error("--------------------error msg-------------");
//      }
//      
//}
//
//      
//      
//    
//      
//
