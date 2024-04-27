package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import PageObjects.manageProgramPage;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class manageProgramPg {
	
	private WebDriver driver = DriverFactory.getDriver();
	
	private manageProgramPage mpp = new manageProgramPage(DriverFactory.getDriver()) ;
	
	@Given("admin enters the LMS site")
	public void admin_enters_the_lms_site() {
	    // Write code here that turns the phrase above into concrete actions
		mpp.getLoginPage();
	}

	@When("Admin enter <username> and <password>")
	public void admin_enter_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		mpp.setUserName("sdetorganizers@gmail.com");
		mpp.setPassword("UIHackathon@02");
		mpp.clickOnLoginButton();
	}
	
	@Then("Admin suceessfully loggedin")
	public void admin_suceessfully_loggedin() {
	    // Write code here that turns the phrase above into concrete actions
		mpp.getLoginPageTitle();
	}
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("dashboard page title : "+mpp.getdashboardPageTitle().trim());
		
		}

	

	@When("Admin clicks Program link on the navigation bar")
	public void admin_clicks_program_link_on_the_navigation_bar() {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		mpp.clickprogramLink();
	}

	@Then("Validate the Program page Validate Page title")
	public void validate_the_program_page_validate_page_title() {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoggerLoad.info("Start : Validate the Program page Validate Page title");
		
		boolean prgmtxt = mpp.getPgmPageTitle();
		System.out.println(prgmtxt);
		String Pgmtxt =mpp.getPgmPageTitletxt();
		System.out.println("Manage Program datatable title : "+Pgmtxt);
		
		LoggerLoad.info("End : Validate the Program page Validate Page title");
	}

	@Then("Validate the Program page Validate Pagination text is displayed")
	public void validate_the_program_page_validate_pagination_text_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Start : Validate the Program page Validate Pagination text is displayed");
		
		boolean Pgtntxt = mpp.getPaginationtxt();
		System.out.println("Pagination text is displayed : "+Pgtntxt);
		
		LoggerLoad.info("End : Validate the Program page Validate Pagination text is displayed");
	}

	@Then("Validate the Program page Validate datatable footer text is displayed")
	public void validate_the_program_page_validate_datatable_footer_text_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Start : Validate the Program page Validate datatable footer text is displayed");
		
		boolean Fttxt = mpp.getFootertxt();
		System.out.println("Footer text is displayed : "+Fttxt);
		
		LoggerLoad.info("End : Validate the Program page Validate datatable footer text is displayed");
	}

	@Then("Validate the Program page Validate multiple program Delete Button is visible")
	public void validate_the_program_page_validate_multiple_program_delete_button_is_visible() {
	    // Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Start : Validate the Program page Validate multiple program Delete Button is visible");
		
		boolean mltdlt = mpp.multDelBtn();
		System.out.println("Multiple delete option button is displayed : "+mltdlt);
		
		LoggerLoad.info("End : Validate the Program page Validate multiple program Delete Button is visible");
	}

	@Then("Validate the Program page Validate A New Program button is visible")
	public void validate_the_program_page_validate_a_new_program_button_is_visible() {
	    // Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Start : Validate the Program page Validate A New Program button is visible");
		
		boolean newPgm = mpp.newPgmBtn();
		System.out.println("A New Program button is displayed : "+newPgm);	

		LoggerLoad.info("End : Validate the Program page Validate A New Program button is visible");	
	}

	@Then("Validate the Program page Validate Datatable Headers are visible")
	public void validate_the_program_page_validate_datatable_headers_are_visible() {
	    // Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Start : Validate the Program page Validate Datatable Headers are visible");
		
		boolean pgmnm = mpp.pgmName();
		System.out.println("Program Name is displayed : "+pgmnm);	
		
		boolean pgmds = mpp.pgmDesc();
		System.out.println("Program Description is displayed : "+pgmds);
		
		boolean pgmsts = mpp.Pgmsts();
		System.out.println("Program status is displayed : "+pgmsts);
		
		boolean eddl = mpp.edtdlt();
		System.out.println("Edit/Delete is displayed : "+eddl);
		
		LoggerLoad.info("End : Validate the Program page Validate Datatable Headers are visible");
		
	}

	@Then("Validate the Program page Validate Sortable icon near datatable header is visible")
	public void validate_the_program_page_validate_sortable_icon_near_datatable_header_is_visible() {
	    // Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Start : Validate the Program page Validate Sortable icon near datatable header is visible");
		
		boolean srtone = mpp.srtOne();
		System.out.println("Program Name sort icon is displayed : "+srtone);	
		
		boolean srttwo = mpp.srtTwo();
		System.out.println("Program Description sort icon is displayed : "+srttwo);
		
		boolean srtthr = mpp.srtThr();
		System.out.println("Program status sort icon is displayed : "+srtthr);	

		LoggerLoad.info("End : Validate the Program page Validate Sortable icon near datatable header is visible");		
	}

	@Then("Validate the Program page Validate table checkbox are visible")
	public void validate_the_program_page_validate_table_checkbox_are_visible() {
	    // Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Start : Validate the Program page Validate table checkbox are visible");
		
		boolean chkone = mpp.chkOne();
		System.out.println("checkbox one for row one is displayed : "+chkone);	
		
		boolean chktwo = mpp.chkTwo();
		System.out.println("checkbox one for row two is displayed : "+chktwo);
		
		boolean chkthr = mpp.chkThr();
		System.out.println("checkbox one for row three is displayed : "+chkthr);	
		
		boolean chkfour = mpp.chkFour();
		System.out.println("checkbox one for row four is displayed : "+chkfour);	
		
		boolean chkfive = mpp.chkFive();
		System.out.println("checkbox one for row five is displayed : "+chkfive);

		LoggerLoad.info("End : Validate the Program page Validate table checkbox are visible");		
	}

	@Then("Validate the Program page Validate editprogram and deleteprogram button are visible")
	public void validate_the_program_page_validate_editprogram_and_deleteprogram_button_are_visible() {
	    // Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Start : Validate the Program page Validate editprogram and deleteprogram button are visible");
		
		boolean editicon = mpp.editicon();
		System.out.println("Edit icon is displayed : "+editicon);	
		
		boolean delicon = mpp.deleteicon();
		System.out.println("Delete icon is displayed : "+delicon);

		LoggerLoad.info("End : Validate the Program page Validate editprogram and deleteprogram button are visible");
	}

	@Then("Validate the Program page Validate Search box input is visible")
	public void validate_the_program_page_validate_search_box_input_is_visible() {
	    // Write code here that turns the phrase above into concrete actions
		LoggerLoad.info("Start : Validate the Program page Validate Search box input is visible");
		
		boolean srchbox = mpp.srchBox();
		System.out.println("Search box is displayed : "+srchbox);
		
		String srchtxt =mpp.srchtxt();
		System.out.println("Search box placeholder text is "+srchtxt);
		
		

		LoggerLoad.info("End : Validate the Program page Validate Search box input is visible");
	}


}
