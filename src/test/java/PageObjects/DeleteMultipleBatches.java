package PageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteMultipleBatches {

	private WebDriver driver;

	private By deletecommonicon = By.xpath("/html/body/app-root/app-batch/div/mat-card/mat-card-title/div[2]/div[1]/button");
	private By clicksingleicon = By.xpath("//*/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]");
	private By clicksingledelicon = By.xpath("//*/div[1]/table/tbody/tr[1]/td[7]/div/span[2]/button");
	private By clickmultiicon = By.xpath("//*/div[1]/table/tbody/tr[2]/td[1]/p-tablecheckbox/div/div[2]");
	private By yesButton = By.xpath("/html/body/app-root/app-batch/p-confirmdialog/div/div/div[3]/button[2]");
	
		
	public DeleteMultipleBatches(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public void checkdeletedisable() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		assertEquals(false, driver.findElement(deletecommonicon).isEnabled());
		
	}
	
	public void clicksingleicon() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(clicksingleicon).click();

	}

	public void clicksingledelicon() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//driver.findElement(clicksingledelicon).click();
		driver.findElement(deletecommonicon).click(); 

	}
	
	public void deletemultirow() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(clicksingleicon).click();
		driver.findElement(clickmultiicon).click();


	}
	
	public void alertwindow() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(yesButton).click();
		
	}

}
