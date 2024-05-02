package PageObjects;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class DeleteUser {
	

		private WebDriver driver; 
		private By userButton = By.xpath("//span[normalize-space()='User']");
		private By deleteicon = By.xpath("//tbody/tr[1]/td[6]/div[1]/span[1]/button[2]/span[1]");
		private By lastpageicon = By.xpath("/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[4]");
		
		private By yesButton = By.xpath("//span[normalize-space()='Yes']");
	    private By noButton = By.xpath("//span[normalize-space()='No']");
	    private By alertwindow = By.xpath("/html/body/app-root/app-user/div/p-confirmdialog/div/div");
	    private By closebtn = By.xpath("/html/body/app-root/app-user/div/p-confirmdialog/div/div/div[1]/div/button/span");
	    
		
		public DeleteUser(WebDriver driver)
		{
			this.driver = driver;
			
		}
		public void clickOnUserTab() {
			//driver.navigate().refresh();
 		    driver.findElement(userButton).click();
 		    System.out.println("user click");
 	 }
		
	   public void deleteenable() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			assertEquals(true, driver.findElement(deleteicon).isEnabled());
		   
	   }
	   public void clickdelete() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(lastpageicon).click();
			driver.findElement(deleteicon).click();
		   
	   }
	   
	   public void alertwindow() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			assertEquals(true, driver.findElement(alertwindow).isEnabled());
			driver.findElement(closebtn).click();
		   
	   }
	   
	   public void closebtn() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
	   }
	   
	   public void deluser() {
		   driver.findElement(yesButton).click();
			// Get the current window handle
		/*	String currentWindowHandle = driver.getWindowHandle();
			// Get all window handles
			Set<String> allWindowHandles = driver.getWindowHandles();

	// Iterate through all handles
			for (String handle : allWindowHandles) {
			    // Switch to the window
			    driver.switchTo().window(handle);
			   
			    driver.findElement(yesButton).click();
			}
			// Switch back to the original window
			driver.switchTo().window(currentWindowHandle);*/
		   
	   }
	   public void notdeleteuser() {
		   driver.findElement(noButton).click();
			// Get the current window handle
		/*	String currentWindowHandle = driver.getWindowHandle();
			// Get all window handles
			Set<String> allWindowHandles = driver.getWindowHandles();

	// Iterate through all handles
			for (String handle : allWindowHandles) {
			    // Switch to the window
			    driver.switchTo().window(handle);
			   
			    driver.findElement(noButton).click();
			}
			// Switch back to the original window
			driver.switchTo().window(currentWindowHandle);*/
		   
	   }
	   
	}


