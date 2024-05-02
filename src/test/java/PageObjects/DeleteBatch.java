package PageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteBatch {

	private WebDriver driver; 

	private By deleteicon = By.xpath("//*/div/div[1]/table/tbody/tr[1]/td[7]/div/span[2]/button");
	
	private By yesButton = By.xpath("/html/body/app-root/app-batch/p-confirmdialog/div/div/div[3]/button[2]");
    private By noButton = By.xpath("//*[text()='No']");
    private By alertwindow = By.xpath("/html/body/app-root/app-batch/p-confirmdialog/div/div");
    private By closebtn = By.xpath("/html/body/app-root/app-batch/p-confirmdialog/div/div/div[1]/div/button/span");
    
	
	public DeleteBatch(WebDriver driver) 
	{
		this.driver = driver;
		
	}
	
   public void deleteenable() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		assertEquals(true, driver.findElement(deleteicon).isEnabled());
	   
   }
   public void clickdelete() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
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
   
   public void delbatch() {
	   driver.findElement(yesButton).click();
	   
   }
   public void notdeletebatch() {
	   driver.findElement(noButton).click();
	   
   }
   
}
