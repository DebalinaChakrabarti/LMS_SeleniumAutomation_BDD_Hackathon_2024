package PageObjects;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class DeleteMultipleUsers {
	

		private WebDriver driver;

		private By userButton = By.xpath("//span[normalize-space()='User']");
		private By deletecommonicon = By.xpath("/html/body/app-root/app-user/div/mat-card/mat-card-title/div[2]/div[1]/button");
		private By clicksingleicon = By.xpath("//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
		private By clicksingledelicon = By.xpath("//tbody/tr[1]/td[6]/div[1]/span[1]/button[2]/span[1]");
		//private By clickmultiicon = By.xpath("//*/div[1]/table/tbody/tr[2]/td[1]/p-tablecheckbox/div/div[2]");
		//private By yesButton = By.xpath("//span[@class='p-button-icon p-button-icon-left pi pi-check']");
		private By yesButton = By.xpath("//*[text()='Yes']");
		private By lastpageicon = By.xpath("/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[4]");
		private By clickmultiicon =By.xpath("//tr[2]/td[1]");
		private By prevBtn = By.xpath("//button[@class='p-paginator-prev p-paginator-element p-link p-ripple']");
		
		public DeleteMultipleUsers(WebDriver driver)
		{
			this.driver = driver;
			
		}
		
		public void clickOnUserTab() {
			//driver.navigate().refresh();
 		    driver.findElement(userButton).click();
 		    System.out.println("user click");
 		    
		}  
 		    
 		 public void checkdeletedisable() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			assertEquals(false, driver.findElement(deletecommonicon).isEnabled());
			
		}
		
		public void clicksingleicon() {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			//driver.findElement(lastpageicon).click();
			driver.findElement(clicksingleicon).click();

		}

		public void clicksingledelicon() {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//driver.findElement(clicksingledelicon).click();
			driver.findElement(prevBtn).click();
			driver.findElement(deletecommonicon).click(); 

		}
		
		public void deletemultirow() {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(prevBtn).click();
			
			driver.findElement(clicksingleicon).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			if(driver.findElement(clickmultiicon)!=null)
			driver.findElement(clickmultiicon).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(deletecommonicon).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		
		public void alertwindow() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(2000);
			driver.findElement(yesButton).click();
		}

	}
