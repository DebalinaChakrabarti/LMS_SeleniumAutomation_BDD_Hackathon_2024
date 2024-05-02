package PageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AssignStudentPage {

	private WebDriver driver;

	private By userButton = By.xpath("//span[normalize-space()='User']");
	private By AssignStudentButton = By.xpath("//span[normalize-space()='Assign Student']");

	private By AssignStudentForm = By.xpath("/html/body/app-root/app-user/div/p-dialog[3]/div/div");
	private By saveButton = By.xpath("//button[@class='p-button-rounded p-button-success p-button p-component ng-star-inserted']");
    private By cancelButton = By.xpath("//span[normalize-space()='Cancel']");
    private By closewindow =By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c132-8 pi pi-times']");

    private By roleID = By.xpath("//input[@id='roleId']");
    private By EmailID = By.xpath("//span[@class='ng-tns-c101-57 p-dropdown-label p-inputtext p-placeholder ng-star-inserted']");
    private By ProgramName = By.xpath("//input[@id='programName']");
    private By BatchName= By.xpath("//input[@id='programName']");
    private By Status= By.xpath("//div[@class='radio']");
    private By ActiveButtton=  By.xpath("//div[normalize-space()='Active']//p-radiobutton[@name='userStatus']");
    private By InActiveButtton= By.xpath("//input[@id='Inactive']");
    
    public AssignStudentPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
    public void clickOnUserTab() throws InterruptedException {
            Thread.sleep(2000);
		    driver.findElement(userButton).click();
		    System.out.println("user click");
    }
    public void AssignStudentModule()
   	{
    	    driver.findElement(AssignStudentButton).click();
		    System.out.println("user click on AssignStudent");
   		
   	}
    public void AssignStudentFormVisibile() {
		
		assertEquals(true, driver.findElement(AssignStudentForm).isDisplayed());
		driver.findElement(saveButton).isDisplayed();
		driver.findElement(cancelButton).isDisplayed();
		driver.findElement(closewindow).click();
		System.out.println("Validated assign student form");
    }
     public void AssignStudentFormRoleid() {
		
		driver.findElement(roleID).isDisplayed();
    }
     public void AssignStudentFormEmailid() {
 		
 		driver.findElement(EmailID).isDisplayed();
     }
     public void AssignStudentFormProgramName() {
  		
  		driver.findElement(ProgramName).isDisplayed();
      }
     public void AssignStudentFormBatchName() {
   		
   		driver.findElement(BatchName).isDisplayed();
       }
     public void AssignStudentFormStatus() {
    		
    		driver.findElement(Status).isDisplayed();
    		driver.findElement(ActiveButtton).click();
        }

     

}
