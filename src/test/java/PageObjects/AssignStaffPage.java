package PageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignStaffPage {

	
	private WebDriver driver;

	private By userButton = By.id("user");
	private By AssignStaffButton = By.xpath("//span[normalize-space()='Assign Staff']");

	private By AssignStaffForm = By.xpath("//div[@role='dialog']");
	private By saveButton = By.xpath("//button[@class='p-button-rounded p-button-success p-button p-component ng-star-inserted']");
    private By cancelButton = By.xpath("//span[normalize-space()='Cancel']");
    private By closewindow =By.xpath("/html[1]/body[1]/app-root[1]/app-user[1]/div[1]/p-dialog[2]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]");

    public AssignStaffPage(WebDriver driver)
   	{
   		this.driver = driver;
   		
   	}
       public void clickOnUserTab() throws InterruptedException {

          Thread.sleep(2000);
   		    driver.findElement(userButton).click();
   		    System.out.println("user click");
	
}
       
       public void AssignStaffModule()
      	{
       	    driver.findElement(AssignStaffButton).click();
   		    System.out.println("user click on AssignStaff");
      		
      	}
       public void AssignStaffFormVisibile() {
   		
   		assertEquals(true, driver.findElement(AssignStaffForm).isDisplayed());
   		driver.findElement(saveButton).isDisplayed();
   		driver.findElement(cancelButton).isDisplayed();
   		driver.findElement(closewindow).click();
   		System.out.println("Validated assign staff form");
       }
}
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
